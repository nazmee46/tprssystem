package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import Model.Committee;
import Model.Resident;

import DAO.CommitteeDAO;
import DAO.ResidentDAO;


@WebServlet("/Default_Servlet")
public class Default_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommitteeDAO committeedao;
	private ResidentDAO residentdao;
	
    public Default_Servlet() {
        super();
  
        committeedao = new CommitteeDAO();
        residentdao = new ResidentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Committee committee_info = new Committee();
		Resident resident_info = new Resident();
	}
}