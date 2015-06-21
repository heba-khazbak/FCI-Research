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
 * Servlet implementation class AcceptReject
 */
@WebServlet("/AcceptReject")
public class AcceptReject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptReject() {
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
		
		String acceptORreject = request.getParameter("Acc/Rej");
		String oldSourceID = request.getParameter("oldSource");
		
		 int senderID = (int) session.getAttribute("ID");
		 int receiverID = Integer.parseInt(oldSourceID);

		 Notification N = new Notification (senderID,receiverID);

		 String senderName = (String)session.getAttribute("name");

		if (acceptORreject.equals("Accept"))
		{
			N.composeSendMailReply (senderName ,"" );
		}
		else
		{
			N.composeRejectReply (senderName ,"" );
		}
		
		NotificationDAO nD = new NotificationDAO ();
	    boolean flag = nD.saveNotification(N);
	    
	    if (flag)
		{
			out.print("Sucess");
			
	 	}
		else
		{
			out.print("Failed");
		}
	}

}
