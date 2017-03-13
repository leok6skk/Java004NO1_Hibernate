package _14_Member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _00_Util.SystemConstant;




@WebServlet("/_14_Member/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		String M_Username = request.getParameter("Username");		
		System.out.println("收到Username = "+M_Username);

		
		Collection<MemberBean> coll = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String toJson = null;
		
		try (PrintWriter out = response.getWriter();) {
			if (M_Username == null || M_Username.trim().length() == 0) {
				
				int pageNo;

				String pageNoStr = request.getParameter("pageNo");
				if (pageNoStr == null) {
					pageNo = 1;
				} else {
					try {
						pageNo = Integer.parseInt(pageNoStr.trim());
					} catch (NumberFormatException e) {
						pageNo = 1;
					}
				}
				rs.setPageNo(pageNo);
				rs.setRecordsPerPage(SystemConstant.RECORDS_PER_PAGE);
				coll = rs.getPageMembers();
				
			} else if(rs.ifExist(M_Username)){ 
				
				coll = rs.select(M_Username);
			}
			else {
				
				//找不到 會傳null
				System.out.println(M_Username+" couldn't find.");

			}
			
			toJson = new Gson().toJson(coll);
			//System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}