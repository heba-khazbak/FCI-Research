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

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String jobDescription = request.getParameter("jobDescription");
		String affiliation = request.getParameter("affiliation");
		String overview = request.getParameter("overview");
		
		String myInterests[] = request.getParameterValues("interest"); 
		
		User U = new User (email, password , name);
		U.setUserJobDescription(jobDescription);
		U.setUserAffiliation(affiliation);
		U.setUserOverview(overview);
		if (myInterests != null)
			U.setUserInterests (myInterests);
		
			
		UserDao userD = new UserDao();
		
		 boolean flag = userD.saveUser(U);
		
		if (flag)
		{
			out.print("Sucess");
			session.setAttribute("email", U.getUserEmail());
		    response.sendRedirect("Login_Page.html");	
	 	}
		else
		{
			out.print("Failed");
		}
		
		
	}

}
