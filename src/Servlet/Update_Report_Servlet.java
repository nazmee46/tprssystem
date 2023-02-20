package Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import Model.Report;

import DAO.ReportDAO;

@WebServlet("/Update_Report_Servlet")
public class Update_Report_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	  private ReportDAO reportdao;    
	   
	    public Update_Report_Servlet() {
	        super();
	        reportdao = new ReportDAO();
	        // TODO Auto-generated constructor stub
	    }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String reportid = request.getParameter("reportid");
	    request.setAttribute("report", ReportDAO.viewreport(reportid));
	    RequestDispatcher view = request.getRequestDispatcher("updatereport.jsp");
	    view.forward(request, response);
	  }

	  /**
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    Report r = new Report();
	    r.setReportid(request.getParameter("reportid"));
	    r.setReportdesc(request.getParameter("reportdesc"));
	    r.setReporttype(request.getParameter("reporttype"));
	    r.setReportstatus(request.getParameter("reportstatus"));
	    r.setCommid(request.getParameter("commid"));
	    r.setReportdate(request.getParameter("reportdate"));
	    
	    
	    reportdao.updatereport(r); 
	    
	    request.setAttribute("report", ReportDAO.getreportlist());
	    RequestDispatcher view = request.getRequestDispatcher("Listreport.jsp");
	    view.forward(request, response);
	  }
	
	
	
}
