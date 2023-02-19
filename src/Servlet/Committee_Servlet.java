package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Committee;

import DAO.CommitteeDAO;

@WebServlet("/Committee_Servlet")
public class Committee_Servlet extends HttpServlet {
	public String action = "", forward = "";
	private static String LIST = "Listcommittee.jsp";
	private static String VIEW = "Viewcommittee.jsp";
	private static final long serialVersionUID = 1L;
	private CommitteeDAO committeedao;
	private String commid;
	
	HttpSession session;
	
    public Committee_Servlet() {
        super();
        committeedao = new CommitteeDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	    // TODO Auto-generated method stub
    	    action = request.getParameter("action");

    	    // Complete action for view 
    	    if (action.equalsIgnoreCase("view")) {
    	      forward = VIEW;
    	      commid = request.getParameter("commid");
    	      request.setAttribute("committee", CommitteeDAO.viewcommittee(commid));

    	    }

    	    // Complete action for list 
    	    if (action.equalsIgnoreCase("list")) {
    	      forward = LIST;
    	      request.setAttribute("committee", CommitteeDAO.getcommitteelist());

    	    }

    	    // Complete action for delete 
    	    if (action.equalsIgnoreCase("delete")) {
    	      forward = LIST;
    	      commid = request.getParameter("commid");
    	      committeedao.deletecommittee(commid);
    	      request.setAttribute("committee", CommitteeDAO.getcommitteelist());
    	    }

    	    // forward the request
    	    RequestDispatcher view = request.getRequestDispatcher(forward);
    	    view.forward(request, response);

    	  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Committee c = new Committee();
		session = request.getSession(true);
		
		c.setCommid(request.getParameter("commid"));
		c.setCommname(request.getParameter("commname"));
		c.setCommphoneno(request.getParameter("commphoneno"));
		c.setCommaddress(request.getParameter("commaddress"));
		c.setCommpass(request.getParameter("commpass"));
		c.setPresidentid(request.getParameter("presidentid"));
		
		committeedao.addcommittee(c);
		
		request.setAttribute( "committee" , CommitteeDAO.getcommitteelist());
		forward=LIST;
		RequestDispatcher view =request.getRequestDispatcher(forward);
		view.forward(request, response);
		
		
	
	}
}