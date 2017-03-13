package _00_Login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Login.model.UserBean;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter
//(urlPatterns = { "/*" }, initParams = {
//		@WebInitParam(name = "url_1", value = "/_14_Member/*"),
//		@WebInitParam(name = "url_2", value = "/_01_ProductTest/*"),
//		@WebInitParam(name = "url_3", value = "/_00_Util/*")
//		})
public class LoginFilter implements Filter {
	Collection<String> url = new ArrayList<String>();

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			// Notifies cache to obtain a new copy of the page from the
			// origin server
			resp.setHeader("Cache-Control", "no-cache");

			// informs cache not to store the content it receives under any
			// circumstance
			resp.setHeader("Cache-Control", "no-store");

			// Causes the proxy cache to see the page as "stale",
			// 0 means the expiry date is 1970/01/01 00:00:00 GMT
			resp.setDateHeader("Expires", 0);

			// HTTP 1.0 backward compatibility
			resp.setHeader("Pragma", "no-cache");
			
			
			String servletPath = req.getServletPath();
			System.out.println("servletPath " + servletPath);
			if (mustLogin(servletPath)) {
				if (checkLogin(req)) {
					//System.out.println("需要Login, 已經Login");
					chain.doFilter(request, response);
				} else {
					HttpSession session = req.getSession();
					session.setAttribute("target", req.getServletPath());
					//System.out.println("需要Login, 尚未Login , ServletPath="
							//+ req.getServletPath());
					RequestDispatcher rd = request
							.getRequestDispatcher("/_00_Login/login.jsp");
					rd.forward(req, resp);
				}
			} else {
				//System.out.println("不需要Login ");
				chain.doFilter(request, response);
			}
			
			
			
		} else {
			throw new ServletException("Request/Response Type Error");
		}
	}

	private boolean mustLogin(String servletPath) {
		boolean login = false;
		for (String sURL : url) {
			if (sURL.endsWith("*")) {
				sURL = sURL.substring(0, sURL.length() - 1);
				if (servletPath.startsWith(sURL)) {
					login = true;
					break;
				}
			} else {
				if (servletPath.equals(sURL)) {
					login = true;
					break;
				}
			}
		}
		return login;
	}

	private boolean checkLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean loginToken = (UserBean) session.getAttribute("LoginOK");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			url.add(fConfig.getInitParameter(name));
		}
	}
}
