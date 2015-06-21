package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import entities.*;

/**
 * Servlet implementation class postResearch
 */
@WebServlet("/postResearch")
public class postResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postResearch() {
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
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		
		String myInterests[] = request.getParameterValues("interest_research"); 
		
		

		ResearchDAO rD=new ResearchDAO();
		
		Research r=new Research(title,url,description,Integer.parseInt(request.getSession().getAttribute("ID").toString()));
		r.interests=myInterests;
		
		if(!rD.saveResearch(r)){
			out.println("Failed");
			return;
		}
		out.println("Research posted successfully<br>");
		int senderID=r.getownerID();
		
		UserDao uD=new UserDao();
		
		boolean check=true;
		Map<String,String> m=uD.getUserInterests();
		for (Map.Entry<String, String> entry : m.entrySet())
		{
		    String email=entry.getKey(), tags=entry.getValue();
		    if(uD.getID(email)==senderID)continue;
		    boolean exists=false;
		    for(String tmp:tags.split(",")){
		    	for(int i=0;i<r.interests.length;++i){
		    		if(r.interests[i].equals(tmp)){exists=true;break;}
		    	}
		    	if(exists)break;
		    }
		    if(exists){
		    	int receiverID=uD.getID(email);
			    Notification N = new Notification (senderID,receiverID);

			    String senderName = request.getSession().getAttribute("name").toString();
			    N.composeNewResAdded (senderName ,r.getTitle() );
			    NotificationDAO nD = new NotificationDAO ();
			    boolean flag = nD.saveNotification(N);
			    
			    if (!flag)
				{
					out.print("Failed");
					check=false;
			 	}
		    }
		}
		if(check)out.println("Notifications sent successfully");
	}

}
