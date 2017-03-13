package _14_Member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/_14_Member/SeleteToUpdate")
public class SeleteToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		String M_Username = request.getParameter("Username");
		System.out.println("收到Username = "+M_Username);
		
		Collection<MemberBean> coll = null;
		Collection<String> error = new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String toJson = null;
		
		try (PrintWriter out = response.getWriter();) {
			if (M_Username == null || M_Username.trim().length() == 0) {
				
				error.add("null");
				toJson = new Gson().toJson(error);
				
			} else if(rs.ifExist(M_Username)){ 
				
				coll = rs.select(M_Username);
				toJson = new Gson().toJson(coll);
			}
			else {//找不到
	
				error.add("miss");
				toJson = new Gson().toJson(error);

			}
			
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}