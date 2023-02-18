package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Committee;

public class CommitteeDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	static int commid;
	static String commname, commphoneno, commaddress, commpass, presidentid, validLogin;
	
	public static Committee logincommittee(Committee login_committee) {
		commid = login_committee.getCommid();
		commpass = login_committee.getCommpass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ?");
			ps.setInt(1, commid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ? AND commpass = ?");
				ps.setInt(1, commid);
				ps.setString(2, commpass);
				
				ResultSet sec_rs = ps.executeQuery();
				
				if(sec_rs.next()) {
					login_committee.setCommid(sec_rs.getInt("commid"));
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
	
	//add 
	public String addcommittee(Committee new_committee) {
		String status = null;
		
		commid = new_committee.getCommid();
		commname = new_committee.getCommname();
		commphoneno = new_committee.getCommphoneno();
		commaddress = new_committee.getCommaddress();
		commpass = new_committee.getCommpass();
		presidentid = new_committee.getPresidentid();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ?");
			ps.setInt(1, commid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				status = "ID number already exist";
			}
			else {
				ps = connect.prepareStatement("INSERT INTO committee (commid, commname, commphoneno, commaddress, commpass, presidentid) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, commid);
				ps.setString(2, commname);
				ps.setString(3, commphoneno);
				ps.setString(4, commaddress);
				ps.setString(5, commpass);
				ps.setString(6, presidentid);
				
				ps.execute();
				status = "Successfully added";
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			status = "Unsuccessfully added";
		}
		return status;
	}
	
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
			ps.setInt(6, commid);
			
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
	
	public String deletecommittee(String delete_commid) {
		String status = null;
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("DELETE FROM committee WHERE commid = ?");
			ps.setString(1, delete_commid);
			
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
	
	public static List<Committee> viewcommitteelist() {
		List<Committee> committee_list = new ArrayList<Committee>();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Committee committee_info = new Committee();
				
				committee_info.setCommid(rs.getInt("commid"));
				committee_info.setCommname(rs.getString("commname"));
				committee_info.setCommphoneno(rs.getString("commphoneno"));
				committee_info.setCommaddress(rs.getString("commaddress"));
				committee_info.setCommpass(rs.getString("commpass"));
				committee_info.setPresidentid(rs.getString("presidentid"));
				
				committee_list.add(committee_info);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee_list;
	}
	
	public static Committee viewcommittee(String view_commid) {
		Committee committee_info = new Committee();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commid = ?");
			ps.setString(1, view_commid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				committee_info.setCommid(rs.getInt("commid"));
				committee_info.setCommname(rs.getString("commname"));
				committee_info.setCommphoneno(rs.getString("commphoneno"));
				committee_info.setCommaddress(rs.getString("commaddress"));
				committee_info.setCommpass(rs.getString("commpass"));
				committee_info.setPresidentid(rs.getString("presidentid"));
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee_info;
	}
}