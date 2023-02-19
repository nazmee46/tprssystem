package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Resident;

public class ResidentDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	
	static String resid, resname, resphoneno, resaddress, respass, validLogin;
	
	//login resident
	public static Resident loginresident(Resident login_resident) {
		resid = login_resident.getResid();
		respass = login_resident.getRespass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM resident WHERE resid = ?");
			ps.setString(1, resid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = connect.prepareStatement("SELECT * FROM resident WHERE resid = ? AND respass = ?");
				ps.setString(1, resid);
				ps.setString(2, respass);
				
				ResultSet sec_rs = ps.executeQuery();
				
				if(sec_rs.next()) {
					login_resident.setResid(sec_rs.getString("resid"));
					login_resident.setResname(sec_rs.getString("resname"));
					login_resident.setResphoneno(sec_rs.getString("resphoneno"));
					login_resident.setValidLogin("Successfully login");
				}
				else {
					login_resident.setValidLogin("Wrong ID and password combination");
				}
			}
			else {
				login_resident.setValidLogin("ID number not exist");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return login_resident;
	}
	
	//add resident
	public String addresident(Resident new_resident) {
		String status = null;
		
		resid = new_resident.getResid();
		resname = new_resident.getResname();
		resphoneno = new_resident.getResphoneno();
		resaddress = new_resident.getResaddress();
		respass = new_resident.getRespass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM resident WHERE resid = ?");
			ps.setString(1, resid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				status = "ID number already exist";
			}
			else {
				ps = connect.prepareStatement("INSERT INTO resident (resid, resname, resphoneno, resaddress, respass) VALUES (?, ?, ?, ?, ?)");
				ps.setString(1, resid);
				ps.setString(2, resname);
				ps.setString(3, resphoneno);
				ps.setString(4, resaddress);
				ps.setString(5, respass);
				
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
	
	//update resident
	public String updateresident(Resident update_resident) {
		String status = null;
		
		resid = update_resident.getResid();
		resname = update_resident.getResname();
		resphoneno = update_resident.getResphoneno();
		resaddress = update_resident.getResaddress();
		respass = update_resident.getRespass();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("UPDATE resident SET respass = ?, resname = ?, resphoneno = ?, resaddress = ? WHERE resid = ?");
			ps.setString(1, respass);
			ps.setString(2, resname);
			ps.setString(3, resphoneno);
			ps.setString(4, resaddress);
			ps.setString(5, resid);
			
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
	
	
	//delete resident
	public String deleteresident(String delete_resid) {
		String status = null;
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("DELETE FROM resident WHERE resid = ?");
			ps.setString(1, delete_resid);
			
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
	
	//list resident
	public static List<Resident> viewresidentlist() {
		List<Resident> resident_list = new ArrayList<Resident>();
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM resident");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Resident resident_info = new Resident();
				
				resident_info.setResid(rs.getString("resid"));
				resident_info.setResname(rs.getString("resame"));
				resident_info.setResphoneno(rs.getString("resphoneno"));
				resident_info.setResaddress(rs.getString("resaddress"));
				resident_info.setRespass(rs.getString("respass"));
				
				resident_list.add(resident_info);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resident_list;
	}
	
	//view resident
	public static Resident viewresident(String view_resid) {
		Resident resident_info = new Resident();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM resident WHERE resid = ?");
			ps.setString(1, view_resid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				resident_info.setResid(rs.getString("resid"));
				resident_info.setResname(rs.getString("resname"));
				resident_info.setResphoneno(rs.getString("resphoneno"));
				resident_info.setResaddress(rs.getString("resaddress"));
				resident_info.setRespass(rs.getString("respass"));
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resident_info;
	}
}