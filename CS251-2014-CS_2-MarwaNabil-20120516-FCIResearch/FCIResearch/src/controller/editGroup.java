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
 * Servlet implementation class editGroup
 */
@WebServlet("/editGroup")
public class editGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGroup() {
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
		String name=request.getParameter("editedName");
		String description=request.getParameter("editedDescription");
		String meetingTimes=request.getParameter("editedMeetingTimes");
		
		GroupDao gD=new GroupDao();
		
		Group g=new Group(name,meetingTimes,description,request.getSession().getAttribute("email").toString());
		
		String adminMail=request.getSession().getAttribute("email").toString();
		String gName=request.getSession().getAttribute("groupName").toString();
		int x=gD.checkAdmin(adminMail, gName);
		if(x==0)out.println("Unauthorized Access");
		else if(x==2)out.println("Failed");
		else{
			if(gD.editGroup(g,gName))out.println("Success");
			else out.println("Failed"); 
		}
	}

}
