package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Committee;

import DAO.CommitteeDAO;

@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitteeDAO committeedao;
	HttpSession session;
	
    public Login_Servlet() {
        super();
        committeedao = new CommitteeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Committee committee_info = new Committee();
		session = request.getSession(true);
		
		committee_info.setCommID(Integer.parseInt(request.getParameter("commID")));
		committee_info.setCommPass(request.getParameter("commPass"));
		
		Committee committee_login = committeedao.logincommittee(committee_info);
		
		if(committee_login.isValidLogin() == "Successfully login") {
			session.setAttribute("session_idnum", committee_login.getCommID());
			session.setAttribute("session_name", committee_login.getCommName());
			response.sendRedirect("Redirect_Servlet?action=location");
		}
		else {
			session.setAttribute("session_status", committee_login.isValidLogin());
			response.sendRedirect("index.jsp");
		}
	}
}