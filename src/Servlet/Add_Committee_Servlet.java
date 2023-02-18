package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Committee;

import DAO.CommitteeDAO;

@WebServlet("/Add_Committee_Servlet")
public class Add_Committee_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitteeDAO committeedao;
	HttpSession session;
	
    public Add_Committee_Servlet() {
        super();
        committeedao = new CommitteeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Committee committee_info = new Committee();
		session = request.getSession(true);
		
		committee_info.setCommid(Integer.parseInt(request.getParameter("commid")));
		committee_info.setCommpass(request.getParameter("commpass"));
		committee_info.setCommname(request.getParameter("commname"));
		
		if(request.getParameter("commphoneno") != "") {
			committee_info.setCommphoneno(request.getParameter("commphoneno"));
		}
		if(request.getParameter("commaddress") != "") {
			committee_info.setCommaddress(request.getParameter("commaddress"));
		}
		if(request.getParameter("presidentid") != "") {
			committee_info.setPresidentid(request.getParameter("presidentid"));
		}
		
		session.setAttribute("session_status", committeedao.addcommittee(committee_info));
		response.sendRedirect("Redirect_Servlet?action=committee");
	}
}