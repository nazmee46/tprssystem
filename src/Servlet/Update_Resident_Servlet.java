package Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Resident;

import DAO.ResidentDAO;

@WebServlet("/Update_Committee_Servlet")
public class Update_Resident_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	  private ResidentDAO residentdao;    
	   
	    public Update_Resident_Servlet() {
	        super();
	        residentdao = new ResidentDAO();
	        // TODO Auto-generated constructor stub
	    }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String resid = request.getParameter("resid");
	    request.setAttribute("resident", ResidentDAO.viewresident(resid));
	    RequestDispatcher view = request.getRequestDispatcher("updateresident.jsp");
	    view.forward(request, response);
	  }

	  /**
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    Resident r = new Resident();
	    r.setResid(request.getParameter("resid"));
	    r.setResname(request.getParameter("resname"));
	    r.setResphoneno(request.getParameter("resphoneno"));
	    r.setResaddress(request.getParameter("resaddress"));
	    r.setRespass(request.getParameter("respass"));

	    
	    residentdao.updateresident(r); 
	    
	    request.setAttribute("resident", ResidentDAO.getresidentlist());
	    RequestDispatcher view = request.getRequestDispatcher("ListResidentres.jsp");
	    view.forward(request, response);
	  }
	
	
	
}
