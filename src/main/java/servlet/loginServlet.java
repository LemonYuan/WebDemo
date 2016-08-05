package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;

public class loginServlet extends HttpServlet {
	   private EmployeeService employeeService=new EmployeeService();
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
		String success_forward="welcome.jsp";
		String fail_forward="error.jsp";
		System.out.println("POST方法");
		String name = rq.getParameter("name");
		String password = rq.getParameter("password");
         if (name.equals("")||password.equals("")) {
			rq.setAttribute("msg", "用户或密码为空！");  
			
			RequestDispatcher rd=rq.getRequestDispatcher(fail_forward);
			rd.forward(rq, resp);
		}
         else{
        	Employee e=new Employee();
        	e.setName(name);
        	e.setPassword(Integer.parseInt(password));
        	boolean b=employeeService.check(e);
        	  if(b){
        		  RequestDispatcher rd=rq.getRequestDispatcher(success_forward);
      			  rd.forward(rq, resp);
      			}
        	  else{
        		  RequestDispatcher rd=rq.getRequestDispatcher(fail_forward);
      			  rd.forward(rq, resp);
      			  }
         }
	}

}
