package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Committee;

public class CommitteeDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	
	static String commid,commname, commphoneno, commaddress, commpass, presidentid, validLogin;
	
	//login committee
	public static Committee logincommittee(Committee login_committee) {
		commid = login_committee.getCommid();
		commpass = login_committee.getCommpass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ?");
			ps.setString(1, commid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ? AND commpass = ?");
				ps.setString(1, commid);
				ps.setString(2, commpass);
				
				ResultSet sec_rs = ps.executeQuery();
				
				if(sec_rs.next()) {
					login_committee.setCommid(sec_rs.getString("commid"));
					login_committee.setCommname(sec_rs.getString("commname"));
					login_committee.setCommphoneno(sec_rs.getString("commphoneno"));
					login_committee.setValidLogin("Successfully login");
				}
				else {
					login_committee.setValidLogin("Wrong ID and password combination");
				}
			}
			else {
				login_committee.setValidLogin("ID number not exist");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return login_committee;
	}
	
	//add committee
	public String addcommittee(Committee bean) {
		String status = null;
		
		commid = bean.getCommid();
		commname = bean.getCommname();
		commphoneno = bean.getCommphoneno();
		commaddress = bean.getCommaddress();
		commpass = bean.getCommpass();
		presidentid = bean.getPresidentid();
		
		try {
			connect = Database_Connection.getConnection();
			
				ps = connect.prepareStatement("INSERT INTO committee(commid,commname,commphoneno,commaddress,commpass,presidentid)VALUES(?,?,?,?,?,?)");
				ps.setString(1, commid);
				ps.setString(2, commname);
				ps.setString(3, commphoneno);
				ps.setString(4, commaddress);
				ps.setString(5, commpass);
				ps.setString(6, presidentid);
				
				ps.executeUpdate();
				status = "Successfully added";
			
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//update committee
	public String updatecommittee(Committee update_committee) {
		String status = null;
		
		commid = update_committee.getCommid();
		commname = update_committee.getCommname();
		commphoneno = update_committee.getCommphoneno();
		commaddress = update_committee.getCommaddress();
		commpass = update_committee.getCommpass();
		presidentid = update_committee.getPresidentid();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("UPDATE committee SET commpass = ?, commname = ?, commphoneno = ?, commaddress = ?, presidentid = ? WHERE commid = ?");
			ps.setString(1, commpass);
			ps.setString(2, commname);
			ps.setString(3, commphoneno);
			ps.setString(4, commaddress);
			ps.setString(5, presidentid);
			ps.setString(6, commid);
			
			ps.execute();
			status = "Successfully updated";
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			status = "Unsuccessfully updated";
		}
		return status;
	}
	
	
	//delete committee
	public String deletecommittee(String commid) {
		String status = null;
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("DELETE FROM committee WHERE commid = ?");
			ps.setString(1, commid);
			
			ps.execute();
			status = "Successfully deleted";
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			status = "Unsuccessfully deleted";
		}
		return status;
	}
	
	//list committee
	public static List<Committee> getcommitteelist() {
		List<Committee> committee = new ArrayList<Committee>();
		
		try {
			connect = Database_Connection.getConnection();
			
			ps = connect.prepareStatement("SELECT * FROM committee order by commid asc");
			
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Committee ci = new Committee();
				
				ci.setCommid(rs.getString("commid"));
				ci.setCommname(rs.getString("commname"));
				ci.setCommphoneno(rs.getString("commphoneno"));
				ci.setCommaddress(rs.getString("commaddress"));
				ci.setCommpass(rs.getString("commpass"));
				ci.setPresidentid(rs.getString("presidentid"));
				
				committee.add(ci);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee;
	}
	
	//view committee
	public static Committee viewcommittee(String commid) {
		Committee committee = new Committee();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ?");
			ps.setString(1, commid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				committee.setCommid(rs.getString("commid"));
				committee.setCommname(rs.getString("commname"));
				committee.setCommphoneno(rs.getString("commphoneno"));
				committee.setCommaddress(rs.getString("commaddress"));
				committee.setCommpass(rs.getString("commpass"));
				committee.setPresidentid(rs.getString("presidentid"));
			
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee;
	}
}