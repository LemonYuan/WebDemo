package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8929205543694145331L;

//	@Override
//	protected void service(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
//		String name = rq.getParameter("name").toString();
//		String password = rq.getParameter("password").toString();
//         if (name.equals("lemon")&&password.equals("123456")) {
//			System.out.println("user validated");
//		}	
//	}

	@Override
	protected void doGet(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
		doPost(rq,resp);
	}

	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST方法");
		String name = rq.getParameter("name").toString();
		String password = rq.getParameter("password").toString();
         if (name.equals("lemon")&&password.equals("123456")) {
			System.out.println("user validated");
			String forward="welcome.jsp";
			RequestDispatcher rd=rq.getRequestDispatcher(forward);
			rd.forward(rq, resp);
		}
         else{
        	 resp.sendRedirect("error.jsp");
         }
	}

}
