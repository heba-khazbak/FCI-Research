package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupDao;

/**
 * Servlet implementation class deleteGroup
 */
@WebServlet("/deleteGroup")
public class deleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGroup() {
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
		String adminMail=request.getSession().getAttribute("email").toString();
		String gName=request.getSession().getAttribute("groupName").toString();
		GroupDao gD=new GroupDao();
		
		int x=gD.checkAdmin(adminMail, gName);
		if(x==0)out.println("Unauthorized Access");
		else if(x==2)out.println("Failed");
		else{
			if(gD.deleteGroup(gName))out.println("Success");
			else out.println("Failed");
		}
	}

}
