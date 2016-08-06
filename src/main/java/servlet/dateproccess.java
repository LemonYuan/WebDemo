package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class dateproccess
 */
public class dateproccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dateproccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name =request.getParameter("name");
	        String password =request.getParameter("password");
	        Configuration cfg=new Configuration();
	        cfg.setServletContextForTemplateLoading(getServletContext(), "templates");
	        cfg.setDefaultEncoding("UTF-8");
	        cfg.setOutputEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        System.out.println(getServletContext());
	        Template t=cfg.getTemplate("first_template.ftl");
	        Map root=new HashMap();
	        root.put("name", name);
	        root.put("password", password);
	        
	        try {
				t.process(root,response.getWriter());
			} catch (TemplateException e) {
				e.printStackTrace();
			}
	}

}
