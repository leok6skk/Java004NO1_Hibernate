package _01_ProductTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _01_ProductTest.ProductDAO;

@WebServlet("/_01_ProductTest/UpdateProduct.do")

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
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
		
		if (productIdStr == null || productIdStr.trim().length() == 0) {
			errorMsg.add("序號必須輸入");
		} else if (!isInteger(productIdStr)) {
			errorMsg.add("序號必須是整數");
		}

		int PGPrice = 0;
		if (PGPriceStr == null || PGPriceStr.trim().length() == 0) {
			errorMsg.add("定價必須輸入");
		} else if (!isInteger(PGPriceStr)) {
			errorMsg.add("定價必須是整數");
		} else {
			PGPrice = Integer.parseInt(PGPriceStr);
		}
	
		if (name == null || name.trim().length() == 0){
			errorMsg.add("產品名稱必須輸入");
		}
			

		double avgCost = 0;
		if (avgCostStr == null || avgCostStr.trim().length() == 0) {
			errorMsg.add("成本必須輸入");
		} else if (!isDouble(avgCostStr)) {
			errorMsg.add("成本必須是小數");
		} else {
			avgCost = Double.parseDouble(avgCostStr);
		}
	
		if (oPlaceStr == null || oPlaceStr.trim().length() == 0){
			errorMsg.add("生產地必須輸入");
		}
			

		int sLife = 0;
		if (sLifeStr == null || sLifeStr.trim().length() == 0) {
			errorMsg.add("保存期必須輸入");
		} else if (!isInteger(sLifeStr)) {
			errorMsg.add("保存期必須是整數");
		} else {
			sLife = Integer.parseInt(sLifeStr);
		}

		if (suppierIdStr == null || suppierIdStr.trim().length() == 0){
			errorMsg.add("供應商必須輸入");
		}
			
		
		try (PrintWriter out = response.getWriter();) {
			String toJson = null;
			
			ProductBean pb = new ProductBean(productIdStr, PGPrice, name, avgCost, oPlaceStr, sLife, suppierIdStr);
	
			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else{			
				String s = "資料 " + productIdStr + "修改成功";
				pd.update(pb);
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
