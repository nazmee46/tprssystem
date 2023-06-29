package Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Committee;

import DAO.CommitteeDAO;

@WebServlet("/Update_Committee_Servlet")
public class Update_Committee_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	  private CommitteeDAO committeedao;    
	   
	    public Update_Committee_Servlet() {
	        super();
	        committeedao = new CommitteeDAO();
	        // TODO Auto-generated constructor stub
	    }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String commid = request.getParameter("commid");
	    request.setAttribute("committee", CommitteeDAO.viewcommittee(commid));
	    RequestDispatcher view = request.getRequestDispatcher("updatecommittee.jsp");
	    view.forward(request, response);
	  }

	  /**
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    Committee c = new Committee();
	    c.setCommid(request.getParameter("commid"));
	    c.setCommname(request.getParameter("commname"));
	    c.setCommphoneno(request.getParameter("commphoneno"));
	    c.setCommaddress(request.getParameter("commaddress"));
	    c.setCommpass(request.getParameter("commpass"));
	    c.setPresidentid(request.getParameter("presidentid"));
	    
	    committeedao.updatecommittee(c); 
	    
	    request.setAttribute("committee", CommitteeDAO.getcommitteelist());
	    RequestDispatcher view = request.getRequestDispatcher("successupdatecom.jsp");
	    view.forward(request, response);
	  }
	
	
	
}
