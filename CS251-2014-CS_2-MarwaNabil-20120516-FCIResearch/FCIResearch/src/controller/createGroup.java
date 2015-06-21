package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupDao;
import entities.Group;

/**
 * Servlet implementation class createGroup
 */
@WebServlet("/createGroup")
public class createGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String meetingTimes=request.getParameter("meetingTimes");
		String adminMail=request.getSession().getAttribute("email").toString();
		
		GroupDao gD=new GroupDao();
		
		Group g=new Group(name,meetingTimes,description,adminMail);

	 	
		if(gD.saveGroup(g))out.println("Success");
		else out.println("Failed"); 
	}

}
