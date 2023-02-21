package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Company;

public class CompanyDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	
	static String compid,compname, compphoneno, compaddress;
	
	//list committee
	public static List<Company> getcompanylist() {
		List<Company> company = new ArrayList<Company>();
		
		try {
			connect = Database_Connection.getConnection();
			
			ps = connect.prepareStatement("SELECT * FROM company order by compid asc");
			
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Company c = new Company();
				
				c.setCompid(rs.getString("compid"));
				c.setCompname(rs.getString("compname"));
				c.setCompphoneno(rs.getString("compphoneno"));
				c.setCompaddress(rs.getString("compaddress"));
				
				company.add(c);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return company;
	}
	
	//view committee
	public static Company viewcompany(String compid) {
		Company company = new Company();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM company WHERE compid = ?");
			ps.setString(1, compid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				company.setCompid(rs.getString("compid"));
				company.setCompname(rs.getString("compname"));
				company.setCompphoneno(rs.getString("compphoneno"));
				company.setCompaddress(rs.getString("compaddress"));
			
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return company;
	}
}