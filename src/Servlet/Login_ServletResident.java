package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Resident;

import DAO.ResidentDAO;

@WebServlet("/Login_ServletResident")
public class Login_ServletResident extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO residentdao;
	HttpSession session;
	
    public Login_ServletResident() {
        super();
        residentdao = new ResidentDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resident resident_info = new Resident();
		session = request.getSession(true);
		
		resident_info .setResid(request.getParameter("resid"));
		resident_info .setRespass(request.getParameter("respass"));
		
		Resident resident_login = residentdao.loginresident(resident_info);
		
		if(resident_login.isValidLogin() == "Successfully login") {
			session.setAttribute("session_resid", resident_login.getResid());
			session.setAttribute("session_name", resident_login.getResname());
			response.sendRedirect("Resident_account.jsp");
		}
		else {
			session.setAttribute("session_status", resident_login.isValidLogin());
			response.sendRedirect("index.jsp");
		}
	}
}