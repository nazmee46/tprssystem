package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Resident;

import DAO.ResidentDAO;

@WebServlet("/Resident_Servlet")
public class Resident_Servlet extends HttpServlet {
	public String action = "", forward = "";
	private static String LIST = "Listresident.jsp";
	private static String VIEW = "Viewresident.jsp";
	private static final long serialVersionUID = 1L;
	private ResidentDAO residentdao;
	private String resid;
	
	HttpSession session;
	
    public Resident_Servlet() {
        super();
        residentdao = new ResidentDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	    // TODO Auto-generated method stub
    	    action = request.getParameter("action");

    	    // Complete action for view 
    	    if (action.equalsIgnoreCase("view")) {
    	      forward = VIEW;
    	      resid = request.getParameter("resid");
    	      request.setAttribute("resident", ResidentDAO.viewresident(resid));

    	    }

    	    // Complete action for list 
    	    if (action.equalsIgnoreCase("list")) {
    	      forward = LIST;
    	      request.setAttribute("resident", ResidentDAO.getresidentlist());

    	    }

    	   

    	    // forward the request
    	    RequestDispatcher view = request.getRequestDispatcher(forward);
    	    view.forward(request, response);

    	  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resident r = new Resident();
		session = request.getSession(true);
		
		r.setResid(request.getParameter("resid"));
		r.setResname(request.getParameter("resname"));
		r.setResphoneno(request.getParameter("resphoneno"));
		r.setResaddress(request.getParameter("resaddress"));
		r.setRespass(request.getParameter("respass"));
		
		
		residentdao.addresident(r);
		
		request.setAttribute( "committee" , ResidentDAO.getresidentlist());
		forward=LIST;
		RequestDispatcher view =request.getRequestDispatcher(forward);
		view.forward(request, response);
		
		
	
	}
}