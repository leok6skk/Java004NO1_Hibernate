package _14_Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/_14_Member/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String password2 = request.getParameter("Password2");
		String id = request.getParameter("ID");
		String name = request.getParameter("Name");
		String nick = request.getParameter("Nick");
		String sex = request.getParameter("Sex");
		String birthday = request.getParameter("Birthday");
		String eMail = request.getParameter("EMail");
		String phone = request.getParameter("Phone");
		String cellPhone = request.getParameter("Cellphone");
		String address = request.getParameter("Address");
		String line = request.getParameter("Line");
		String faceBook = request.getParameter("FaceBook");
		String identityCard = request.getParameter("IdentityCard");
		String invoice = request.getParameter("Invoice");
		String uniformNumber = request.getParameter("UniformNumber");

		// 取得現在時間
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String insertDate = sdFormat.format(date);

		// 3. 檢查使用者輸入資料
		
		MemberBeanString errorMember = new MemberBeanString();
		Boolean hasError = false;
		
		if (id == null || id.trim().length() == 0) {
			errorMember.setM_ID("卡號必須輸入");
			hasError = true;
		}
		if (username == null || username.trim().length() == 0) {
			errorMember.setM_Username("帳號必須輸入");
			hasError = true;
		}
		if (password == null || password.trim().length() == 0) {
			errorMember.setM_Password("密碼必須輸入");
			hasError = true;
		}
		if (password2 == null || password2.trim().length() == 0) {
			errorMember.setM_password2("確認密碼必須輸入");
			hasError = true;
		}
//		if(password.equals(password2)==false){
//			errorMember.setM_Password("密碼必須和確認密碼相同");
//			errorMember.setM_password2("確認密碼必須和密碼相同");
//			hasError = true;
//		}
		if (name == null || name.trim().length() == 0) {
			errorMember.setM_Name("名稱必須輸入");
			hasError = true;
		}

		Collection<MemberBeanString> collError = new ArrayList<>();
		
		try (PrintWriter out = response.getWriter();) {

			if (hasError) {//輸入格式錯誤
				errorMember.setDML_Result("輸入格式錯誤");
				//stringResult="輸入格式錯誤";
				collError.add(errorMember);

				String toJson = new Gson().toJson(collError);
				System.out.println(toJson);
				out.println(toJson);
				return;

			} else {  //輸入格式正確
				try{
//                    for(int i=0;i<100;i++){
//					MemberBean mem = new MemberBean( String.valueOf(Integer.parseInt(username)+i), password,String.valueOf(Integer.parseInt(id)+i), name, nick, sex, birthday, eMail, phone,
//							cellPhone, address, line, faceBook, String.valueOf(Integer.parseInt(identityCard)+i), invoice, uniformNumber, insertDate,
//							insertDate, 0, 0, 0);
//                    
//					errorMember.setDML_Result(new MemberDAO().insert(mem)); }
				
                    
    					MemberBean mem = new MemberBean( username, password,id, name, nick, sex, birthday, eMail, phone,
    							cellPhone, address, line, faceBook, identityCard, invoice, uniformNumber, insertDate,
    							insertDate, 0, 0, 0);
                        
    					errorMember.setDML_Result(new MemberDAO().insert(mem));
    				
					String toJson = null;
					if (errorMember.getDML_Result() == null) {
						//新增成功
						
						String stringResult = null;
						stringResult="Success";
						toJson = new Gson().toJson(stringResult);

					} else {
						

						collError.add(errorMember);
						toJson = new Gson().toJson(collError);
					}

					System.out.println(toJson);
					out.println(toJson);

				} catch (Exception e) {
					// errorMsg.put("exception","資料庫存取錯誤");
					System.out.println("資料庫存取錯誤");
					e.printStackTrace();
				}

			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}

}