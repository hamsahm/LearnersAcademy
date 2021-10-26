package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Subjects;
import service.SubjectsService;

public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectsService subjectService = new SubjectsService();

		List<Subjects> subjects = subjectService.retrieveListOfSubjects();
		request.getSession().setAttribute("subjects", subjects);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewSubjects.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
