package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null | "".equals(username)) {
			response.sendRedirect("invalid.jsp?error=1");
		}
		else if(password == null | "".equals(password)) {
			response.sendRedirect("invalid.jsp?error=2");
		} else {
			if("LearnersAcademyAdmin".equals(username) && "admin@123".equals(password)){
				request.getSession().setAttribute("username", username);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);;
			} else {
				response.sendRedirect("invalid.jsp?error=3");
			}
			
		}
		
	}

}
