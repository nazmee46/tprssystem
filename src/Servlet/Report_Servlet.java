package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Report;

import DAO.ReportDAO;

@WebServlet("/Report_Servlet")
public class Report_Servlet extends HttpServlet {
	public String action = "", forward = "";
	private static String LIST = "Listreport.jsp";
	private static String VIEW = "Viewreport.jsp";
	private static final long serialVersionUID = 1L;
	private ReportDAO reportdao;
	private String reportid,resid;
	
	HttpSession session;
	
    public Report_Servlet() {
        super();
        reportdao = new ReportDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	    // TODO Auto-generated method stub
    	    action = request.getParameter("action");

    	    // Complete action for view 
    	    if (action.equalsIgnoreCase("view")) {
    	      forward = VIEW;
    	      reportid = request.getParameter("reportid");
    	      request.setAttribute("report", ReportDAO.viewreport(reportid));

    	    }

    	    // Complete action for list 
    	    if (action.equalsIgnoreCase("list")) {
    	      forward = LIST;
    	      request.setAttribute("report", ReportDAO.getreportlist());

    	    }

    	    // Complete action for delete 
    	    if (action.equalsIgnoreCase("delete")) {
    	      forward = LIST;
    	      reportid = request.getParameter("reportid");
    	      reportdao.deletereport(reportid);
    	      request.setAttribute("report", ReportDAO.getreportlist());
    	    }

    	    // forward the request
    	    RequestDispatcher view = request.getRequestDispatcher(forward);
    	    view.forward(request, response);

    	  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Report r = new Report();
		session = request.getSession(true);
		
		r.setReportid(request.getParameter("reportid"));
		r.setReportdesc(request.getParameter("reportdesc"));
		r.setReporttype(request.getParameter("reporttype"));
		r.setReportstatus(request.getParameter("reportstatus"));
		r.setCommid(request.getParameter("commid"));
		r.setReportdate(request.getParameter("reportdate"));
		
		
		reportdao.addreport(r);
		
		response.sendRedirect("successcreatedreport.jsp");
		
		
	
	}
}