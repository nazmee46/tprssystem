package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Committee;

public class CommitteeDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	static int commID;
	static String commName, commPhoneNo, commAddress, commPass, presidentID, validLogin;
	
	public static Committee logincommittee(Committee login_committee) {
		commID = login_committee.getCommID();
		commPass = login_committee.getCommPass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commID = ?");
			ps.setInt(1, commID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = connect.prepareStatement("SELECT * FROM committee WHERE commID = ? AND commPass = ?");
				ps.setInt(1, commID);
				ps.setString(2, commPass);
				
				ResultSet sec_rs = ps.executeQuery();
				
				if(sec_rs.next()) {
					login_committee.setCommID(sec_rs.getInt("commID"));
					login_committee.setCommName(sec_rs.getString("commName"));
					login_committee.setCommPhoneNo(sec_rs.getString("commPhone"));
					login_committee.setCommAddress(sec_rs.getString("commAddress"));
					login_committee.setCommPass(sec_rs.getString("commPass"));					
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
		
		commID = new_committee.getCommID();
		commName = new_committee.getCommName();
		commPhoneNo = new_committee.getCommPhoneNo();
		commAddress = new_committee.getCommAddress();
		commPass = new_committee.getCommPass();
		presidentID = new_committee.getPresidentID();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commID = ?");
			ps.setInt(1, commID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				status = "ID number already exist";
			}
			else {
				ps = connect.prepareStatement("INSERT INTO committee (commID, commName, commPhoneNo, commAddress, commPass, presidentID) VALUES (?, ?, ?, ?, ?, ?)");
				ps.setInt(1, commID);
				ps.setString(2, commName);
				ps.setString(3, commPhoneNo);
				ps.setString(4, commAddress);
				ps.setString(5, commPass);
				ps.setString(6, presidentID);
				
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
		
		commID = update_committee.getCommID();
		commName = update_committee.getCommName();
		commPhoneNo = update_committee.getCommPhoneNo();
		commAddress = update_committee.getCommAddress();
		commPass = update_committee.getCommPass();
		presidentID = update_committee.getPresidentID();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("UPDATE committee SET commPass = ?, commName = ?, commPhoneNo = ?, commAddress = ?, presidentID = ? WHERE commID = ?");
			ps.setString(1, commPass);
			ps.setString(2, commName);
			ps.setString(3, commPhoneNo);
			ps.setString(4, commAddress);
			ps.setString(5, presidentID);
			ps.setInt(6, commID);
			
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
	
	public String deletecommittee(String delete_idnum) {
		String status = null;
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("DELETE FROM committee WHERE commID = ?");
			ps.setString(1, delete_idnum);
			
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
				
				committee_info.setCommID(rs.getInt("commID"));
				committee_info.setCommName(rs.getString("commName"));
				committee_info.setCommPhoneNo(rs.getString("commPhoneNo"));
				committee_info.setCommAddress(rs.getString("commAddress"));
				committee_info.setCommPass(rs.getString("commPass"));
				committee_info.setPresidentID(rs.getString("presidentID"));
				
				committee_list.add(committee_info);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee_list;
	}
	
	public static Committee viewcommittee(String view_idnum) {
		Committee committee_info = new Committee();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM committee WHERE commID = ?");
			ps.setString(1, view_idnum);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				committee_info.setCommID(rs.getInt("commID"));
				committee_info.setCommName(rs.getString("commName"));
				committee_info.setCommPhoneNo(rs.getString("commPhoneNO"));
				committee_info.setCommAddress(rs.getString("commAddress"));
				committee_info.setCommPass(rs.getString("commPass"));
				committee_info.setPresidentID(rs.getString("presidentID"));
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return committee_info;
	}
}