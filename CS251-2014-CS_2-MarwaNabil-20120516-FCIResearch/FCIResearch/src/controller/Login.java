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

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

	 	UserDao userD = new UserDao();
		
		 User myUser = userD.getUser(email , password);
		
		if (myUser != null)
		{
			HttpSession session = request.getSession();
			out.print("Sucess");
			session.setAttribute("email", myUser.getUserEmail());
			session.setAttribute("name", myUser.getUserName());
			session.setAttribute("ID", myUser.getUserID());
			response.sendRedirect("HomePage.jsp");
		}
		else
		{
			out.print("Failed");
		} 
		
	}

}
