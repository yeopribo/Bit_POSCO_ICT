package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/Web01/HelloServlet

// 1. @WebServlet("/HelloServlet") -- �ڹٿ��� ����

// 2. <servlet-name>tiger</servlet-name> -- xml���� �⺻ ����
// 	  <servlet-class>Pack.HelloServlet</servlet-class>

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }
    
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Call");
		
		// out�� �̿��ؼ� html�� �����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println("<html>");
//			out.println("<head>");
//			out.println("</head>");
//			
//			out.println("<body>");
//				out.println("<h1>��ŰD����</h1>");				
//			out.println("</body>");
//		out.println("</html>");
		
		out.println(
				"<html>" + 
					"<head>" + 
					"</head>" + 
					"<body>" + 
						"<h1>�׸��ϸ��ϸ�5</h1>" + 
					"</body>" + 
				"</html>"
				);
		
		out.close();	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
}
