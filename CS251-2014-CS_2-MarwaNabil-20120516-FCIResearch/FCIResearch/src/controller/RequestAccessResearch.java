package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entities.*;

/**
 * Servlet implementation class RequestAccessResearch
 */
@WebServlet("/RequestAccessResearch")
public class RequestAccessResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAccessResearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    
	    String ResearchName = request.getParameter("ResearchName");
	    String ownerID = request.getParameter(ResearchName) ;
	  
	    int senderID = (int) session.getAttribute("ID");
	    int receiverID = Integer.parseInt(ownerID);

	    Notification N = new Notification (senderID,receiverID);

	    String senderName = (String)session.getAttribute("name");
	    N.composeNewResReq (senderName ,ResearchName ); 
	    NotificationDAO nD = new NotificationDAO ();
	    boolean flag = nD.saveNotification(N);
	    
	    if (flag)
		{
			out.print("Sucess");
			UserDao uD=new UserDao();
			String receiverMail=uD.getMail(receiverID);
			session.setAttribute("receiver", receiverMail);
			session.setAttribute("message", N.getMsg());
			response.sendRedirect("sendEmail.jsp");
			
	 	}
		else
		{
			out.print("Failed");
		}
	}

}
