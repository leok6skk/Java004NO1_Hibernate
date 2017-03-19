package _01_ProductTest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_01_ProductTest/SelectProduct.do")
public class SelectProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		return pattern.matcher(value).matches();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String productIdStr = request.getParameter("productId");

		ProductDAO pd= new ProductDAO();
		//list輸出純文字資料
		List<ProductBean> list = null;
		response.setContentType("application/json; charset=UTF-8");
		//輸出圖片資料
//		String mimeType = getServletContext().getMimeType(fileNameStr);
//		response.setContentType(mimeType);
//		String idStr = request.getParameter("id");
//		System.out.println(idStr);
//		byte[] bytes = null ;
		
		try (
			//PrintWriter pw = response.getWriter();
			OutputStream os = response.getOutputStream();	
			) {
			
			if (productIdStr == null || productIdStr.trim().length() == 0) {
				System.out.println("判定為null");
				list = pd.findAll();
//				bytes = pd.getAllImage();
			} else if (!isInteger(productIdStr)) {
//				 errorMsg.add("必須是整數");
				System.out.println("必須是整數");
			}else {
				list = pd.findByPrimaryKey(productIdStr);
//				bytes = pd.getImage(idStr);
			}	
			
			
			//listToJson寫出純文字資料
			String listToJson = new Gson().toJson(list);
			os.write(listToJson.getBytes("UTF-8"));	
			System.out.println(listToJson);
			//輸出圖片資料
//			Base64.Encoder be = Base64.getEncoder();
//			os.write(be.encode(bytes));	
//			System.out.println(be.encode(bytes));
		}
	}
}

// request.setAttribute("productColl", coll);
// RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
// rd.forward(request, response);
