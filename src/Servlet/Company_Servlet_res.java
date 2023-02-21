package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Company;

import DAO.CompanyDAO;

@WebServlet("/Company_Servlet_res")
public class Company_Servlet_res extends HttpServlet {
	public String action = "", forward = "";
	private static String LIST = "Listcompanyres.jsp";
	private static String VIEW = "Viewcompanyres.jsp";
	private static final long serialVersionUID = 1L;
	private CompanyDAO companydao;
	private String compid;
	
	HttpSession session;
	
    public Company_Servlet_res() {
        super();
        companydao = new CompanyDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	    // TODO Auto-generated method stub
    	    action = request.getParameter("action");

    	    // Complete action for view 
    	    if (action.equalsIgnoreCase("view")) {
    	      forward = VIEW;
    	      compid = request.getParameter("compid");
    	      request.setAttribute("company", CompanyDAO.viewcompany(compid));

    	    }

    	    // Complete action for list 
    	    if (action.equalsIgnoreCase("list")) {
    	      forward = LIST;
    	      request.setAttribute("company", CompanyDAO.getcompanylist());

    	    }
    	    
    	    // forward the request
    	    RequestDispatcher view = request.getRequestDispatcher(forward);
    	    view.forward(request, response);

    	  }
}