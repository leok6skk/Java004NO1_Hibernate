package _01_ProductTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import _00_Util.GlobalService;

@WebServlet("/_01_ProductTest/InsertProduct2.do")
// 啟動檔案上傳的功能：
// 1. <form>標籤的 method屬性必須是"post", 而且
// enctype屬性必須是"multipart/form-data"
// 注意：enctype屬性的預設值為"application/x-www-form-urlencoded"
// 2. 定義可以挑選上傳檔案的表單欄位：
// <input type='file' name='user-defined_name' />
// 註: HTTP multipart request: 由Http客戶端(如瀏覽器)所建構的ㄧ種請求，用來
// 同時上傳表單資料與檔案。
//
// what-should-a-multipart-http-request-with-multiple-files-look-like?
// http://stackoverflow.com/questions/913626/what-should-a-multipart-http-request-with-multiple-files-look-like

// 在Servlet 3.0中，若要能夠處理瀏覽器送來的multipart request, Servlet必須
// 以註釋『javax.servlet.annotation.MultipartConfig』來宣告。
//
// MultipartConfig的屬性說明:
// location: 上傳之表單資料與檔案暫時存放在Server端之路徑。此路徑必須存在。
// fileSizeThreshold: 檔案的大小臨界值，超過此臨界值，上傳檔案會用存放在硬碟，
// 否則存放在主記憶體。
// maxFileSize: 上傳單一檔案之長度限制，如果超過此數值，Container會丟出例外
// maxRequestSize: 上傳所有檔案的總長度限制，如果超過此數值，Container會丟出例外
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
public class InsertProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		ProductDAO pd = new ProductDAO();

		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();

		String productIdStr = "";
		String PGPriceStr = "";
		String nameStr = "";
		String avgCostStr = "";
		String oPlaceStr = "";
		String sLifeStr = "";
		String suppierIdStr = "";
		String fileNameStr = "";
		int PGPrice = 0;
		double avgCost = 0;
		int sLife = 0;
		long sizeInBytes = 0;
		InputStream is = null;

		Collection<Part> parts = request.getParts();
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				System.out.println("fldName=" + fldName);
				String value = request.getParameter(fldName);
				if (p.getContentType() == null) {
					if (fldName.equals("productId")) {
						productIdStr = value;
						if (productIdStr == null || productIdStr.trim().length() == 0) {
							errorMsg.add("序號必須輸入");
						} else if (!isInteger(productIdStr)) {
							errorMsg.add("序號必須是整數");
						} else if (pd.ifExist(productIdStr)) {
							errorMsg.add("序號已存在請重新輸入");
						}
					} else if (fldName.equals("PGPrice")) {
						PGPriceStr = value;
						if (PGPriceStr == null || PGPriceStr.trim().length() == 0) {
							errorMsg.add("定價必須輸入");
						} else if (!isInteger(PGPriceStr)) {
							errorMsg.add("定價必須是整數");
						} else {
							PGPrice = Integer.parseInt(PGPriceStr);
						}
					} else if (fldName.equals("name")) {
						nameStr = value;
						if (nameStr == null || nameStr.trim().length() == 0)
							errorMsg.add("產品名稱必須輸入");
					} else if (fldName.equals("avgCost")) {
						avgCostStr = value;
						if (avgCostStr == null || avgCostStr.trim().length() == 0) {
							errorMsg.add("成本必須輸入");
						} else if (!isDouble(avgCostStr)) {
							errorMsg.add("成本必須是小數");
						} else {
							avgCost = Double.parseDouble(avgCostStr);
						}
					} else if (fldName.equals("oPlace")) {
						oPlaceStr = value;
						if (oPlaceStr == null || oPlaceStr.trim().length() == 0)
							errorMsg.add("生產地必須輸入");
					} else if (fldName.equals("sLife")) {
						sLifeStr = value;
						if (sLifeStr == null || sLifeStr.trim().length() == 0) {
							errorMsg.add("保存期必須輸入");
						} else if (!isInteger(sLifeStr)) {
							errorMsg.add("保存期必須是整數");
						} else {
							sLife = Integer.parseInt(sLifeStr);
						}
					} else if (fldName.equals("suppierId")) {
						suppierIdStr = value;
						if (suppierIdStr == null || suppierIdStr.trim().length() == 0)
							errorMsg.add("供應商必須輸入");
					}

				} else {
			
					fileNameStr = GlobalService.getFileName(p); // 此為圖片檔的檔名;
					fileNameStr = GlobalService.adjustFileName(fileNameStr, GlobalService.IMAGE_FILENAME_LENGTH);
					System.out.println(fileNameStr);
					if (fileNameStr != null && fileNameStr.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					}
					 else {
					 errorMsg.add("必須挑選圖片檔");
					 }
				}
			}
		}

		try (PrintWriter out = response.getWriter();) {
			String toJson = null;

			ProductBean pb = new ProductBean(productIdStr, PGPrice, nameStr, avgCost, oPlaceStr, sLife, suppierIdStr,
					fileNameStr);

			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else {
				String s = "資料 " + productIdStr + "新增成功";
				pd.insert(pb, is, sizeInBytes);
				toJson = new Gson().toJson(s);
			}

			System.out.println(toJson);
			out.println(toJson);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		return pattern.matcher(value).matches();
	}

	public static boolean isDouble(String value) {
		Pattern pattern = Pattern.compile("^([-+]?\\d+)(\\.\\d+)?$");
		return pattern.matcher(value).matches();
	}

}
