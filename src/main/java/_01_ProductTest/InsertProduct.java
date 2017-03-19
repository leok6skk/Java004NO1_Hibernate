package _01_ProductTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import _01_ProductTest.ProductDAO;

@WebServlet("/_01_ProductTest/InsertProduct.do")

public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		
    	ProductDAO pd = new ProductDAO();

		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();
		
		String productIdStr = request.getParameter("productId");
		String PGPriceStr = request.getParameter("PGPrice");
		String name = request.getParameter("name");
		String avgCostStr = request.getParameter("avgCost");
		String oPlaceStr = request.getParameter("oPlace");
		String sLifeStr = request.getParameter("sLife");
		String suppierIdStr = request.getParameter("suppierId");
		String fileNameStr = "";
		
		
		if (productIdStr == null || productIdStr.trim().length() == 0) {
			errorMsg.add("序號必須輸入");
		} else if (!isInteger(productIdStr)) {
			errorMsg.add("序號必須是整數");
		}else if (pd.ifExist(productIdStr)){
			errorMsg.add("序號已存在請重新輸入");
		}

		int PGPrice = 0;
		if (PGPriceStr == null || PGPriceStr.trim().length() == 0) {
			errorMsg.add("定價必須輸入");
		} else if (!isInteger(PGPriceStr)) {
			errorMsg.add("定價必須是整數");
		} else {
			PGPrice = Integer.parseInt(PGPriceStr);
		}

		if (name == null || name.trim().length() == 0)
			errorMsg.add("產品名稱必須輸入");

		double avgCost = 0;
		if (avgCostStr == null || avgCostStr.trim().length() == 0) {
			errorMsg.add("成本必須輸入");
		} else if (!isDouble(avgCostStr)) {
			errorMsg.add("成本必須是小數");
		} else {
			avgCost = Double.parseDouble(avgCostStr);
		}

		if (oPlaceStr == null || oPlaceStr.trim().length() == 0)
			errorMsg.add("生產地必須輸入");

		int sLife = 0;
		if (sLifeStr == null || sLifeStr.trim().length() == 0) {
			errorMsg.add("保存期必須輸入");
		} else if (!isInteger(sLifeStr)) {
			errorMsg.add("保存期必須是整數");
		} else {
			sLife = Integer.parseInt(sLifeStr);
		}

		if (suppierIdStr == null || suppierIdStr.trim().length() == 0)
			errorMsg.add("供應商必須輸入");
		
		try (PrintWriter out = response.getWriter();) {
			String toJson = null;
			
			ProductBean pb = new ProductBean(productIdStr, PGPrice, name, avgCost
					, oPlaceStr, sLife, suppierIdStr,fileNameStr);
		
			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else{			
				String s = "資料 " + productIdStr + "新增成功";
//				pd.insert(pb, is, sizeInBytes);
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
	
	public static String adjustFileName(String fileName, int maxLength) {
		  int length = fileName.length();
		  if ( length <= maxLength ) {
			  return fileName ;
		  }
  	  int n      = fileName.lastIndexOf(".");
        int sub    = fileName.length() - n - 1;
        fileName = fileName.substring(0, maxLength-1-sub) + "." 
                     + fileName.substring(n+1); 
		return fileName;
	}
//	public static String getFileName( String fileName) {
//		for (String content : part.getHeader("content-disposition").split(";")) {
//			if (content.trim().startsWith("filename")) {
//				return content.substring(content.indexOf('=') + 1).trim()
//						.replace("\"", "");
//			}
//		}
//		return null;
//	}
//	
//	public void exploreParts(Collection<Part> parts, HttpServletRequest req){
//		try {
//			for (Part part: parts){
//				String name = part.getName();
//				String contentType = part.getContentType();
//				String value = "";
//				long size = part.getSize(); // 上傳資料的大小，即上傳資料的位元組數
//				InputStream is =part.getInputStream();
//				if (contentType != null) {	// 表示該part為檔案
//				   // 取出上傳檔案的檔名
////				   String filename = getFileName(part);
//				// 將上傳的檔案寫入到location屬性所指定的資料夾
//				   part.write(filename);		
//				} else {	// 表示該part為一般的欄位
//				   // 將上傳的欄位資料寫入到location屬性所指定的資料夾，檔名為"part_"+ name
//				   part.write("part_"+ name);	
//				   value = req.getParameter(name);    
//				}
//				System.out.printf("%-15s %-15s %8d  %-20s \n", name, contentType, size, value);
//				
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
}
