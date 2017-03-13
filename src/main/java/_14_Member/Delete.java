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

@WebServlet("/_14_Member/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		String M_Username = request.getParameter("Username");

		Collection<String> coll = new ArrayList<>();
		if (M_Username == null || M_Username.trim().length() == 0) {
			coll.add("null");//You must input username !
		}
		else if (!rs.ifExist(M_Username)) {
			coll.add("miss");//M_Username+" couldn't find."

		} else {
			int Result = rs.delete(M_Username);
			System.out.println("刪除帳號: " + M_Username);

			if (Result == 1) {
				coll.add("true");//"Delete "+M_Username+" success."
			} else {
				coll.add("false");//"Delete "+M_Username+" error!!!"

			}
		}
		try (PrintWriter out = response.getWriter();) {

			String toJson = new Gson().toJson(coll);
			System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}