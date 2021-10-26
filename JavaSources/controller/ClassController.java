package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Classes;
import service.ClassesService;

/**
 * Servlet implementation class ClassController
 */
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClassesService classesService = new ClassesService();

		List<Classes> classes = classesService.retrieveListOfClasses();
		request.getSession().setAttribute("classes", classes);
		
		String classType = request.getParameter("type");
		
		System.out.println("classes inside controller "+classType);

		RequestDispatcher rd = null;
		if(classType.equals("classes")) {
			rd = request.getRequestDispatcher("viewClasses.jsp");
		}
		else if(classType.equals("viewReport")) {
			rd = request.getRequestDispatcher("viewClassReports.jsp");
		}

		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
