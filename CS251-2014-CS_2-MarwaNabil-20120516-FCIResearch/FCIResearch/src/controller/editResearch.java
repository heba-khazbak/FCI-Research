package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResearchDAO;
import entities.Research;

/**
 * Servlet implementation class editResearch
 */
@WebServlet("/editResearch")
public class editResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editResearch() {
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
	    
	    ResearchDAO rD=new ResearchDAO();
	    
	    Research r=new Research(request.getParameter("editedTitle"),request.getParameter("editedurl"),request.getParameter("editedDescription_r"),Integer.parseInt(request.getSession().getAttribute("ID").toString()));
	    r.interests=request.getParameterValues("interest_research_edit");
	    
	    if(rD.editResearch(r,request.getParameter("oldURL")))out.println("Success");
	    else out.println("Failed");
	}

}
