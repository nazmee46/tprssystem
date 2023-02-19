package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Resident;

import DAO.ResidentDAO;

@WebServlet("/Add_Resident_Servlet")
public class Add_Resident_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO residentdao;
	HttpSession session;
	
    public Add_Resident_Servlet() {
        super();
        residentdao = new ResidentDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resident resident_info = new Resident();
		session = request.getSession(true);
		
		resident_info.setResid(request.getParameter("resid"));
		resident_info.setRespass(request.getParameter("respass"));
		resident_info.setResname(request.getParameter("resname"));
		
		if(request.getParameter("commphoneno") != "") {
			resident_info.setResphoneno(request.getParameter("resphoneno"));
		}
		if(request.getParameter("commaddress") != "") {
			resident_info.setResaddress(request.getParameter("resaddress"));
		}
		session.setAttribute("session_status", residentdao.addresident(resident_info));
		response.sendRedirect("Redirect_Servlet?action=resident");
	}
}