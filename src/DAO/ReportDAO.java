package DAO;

import java.sql.*;
import java.util.*;

import Database.Database_Connection;
import Model.Report;

public class ReportDAO {
	private static Connection connect = null;
	private static PreparedStatement ps = null;
	
	static String reportid, reportdesc, reporttype, reportstatus, commid, reportdate, resid;
	
	//add committee
	public String addreport(Report bean) {
		String status = null;
		
		reportid = bean.getReportid();
		reportdesc = bean.getReportdesc();
		reporttype = bean.getReporttype();
		reportstatus = bean.getReportstatus();
		commid = bean.getCommid();
		reportdate = bean.getReportdate();
		resid = bean.getResid();
		
		try {
			connect = Database_Connection.getConnection();
			
				ps = connect.prepareStatement("INSERT INTO reporttest(reportid,reportdesc,reporttype,reportstatus,commid,reportdate,resid)VALUES(?,?,?,?,?,?,?)");
				ps.setString(1, reportid);
				ps.setString(2, reportdesc);
				ps.setString(3, reporttype);
				ps.setString(4, reportstatus);
				ps.setString(5, commid);
				ps.setString(6, reportdate);
				ps.setString(7, resid);
				
				
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
	public String updatereport(Report bean) {
		String status = null;
		
		reportid = bean.getReportid();
		reportdesc = bean.getReportdesc();
		reporttype = bean.getReporttype();
		reportstatus = bean.getReportstatus();
		commid = bean.getCommid();
		reportdate=bean.getReportdate();
		
		
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("UPDATE reporttest SET reportstatus = ? WHERE reportid = ?");
			ps.setString(1, reportstatus);
			ps.setString(2, reportid);
			
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
	public String deletereport(String reportid) {
		String status = "1";
		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("DELETE FROM reporttest WHERE reportid = ?");
			ps.setString(1, reportid);
			
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
	public static List<Report> getreportlist() {
		List<Report> report = new ArrayList<Report>();
		
		try {
			connect = Database_Connection.getConnection();
			
			ps = connect.prepareStatement("SELECT * FROM reporttest order by reportid asc");
			
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Report r = new Report();
				
				r.setReportid(rs.getString("reportid"));
				r.setReportdesc(rs.getString("reportdesc"));
				r.setReporttype(rs.getString("reporttype"));
				r.setReportstatus(rs.getString("reportstatus"));
				r.setCommid(rs.getString("commid"));
				r.setResid(rs.getString("resid"));
				
				report.add(r);
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	
	//view committee
	public static Report viewreport(String reportid) {
		Report report = new Report();

		try {
			connect = Database_Connection.getConnection();
			ps = connect.prepareStatement("SELECT * FROM reporttest WHERE reportid = ?");
			ps.setString(1, reportid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				report.setReportid(rs.getString("reportid"));
				report.setReportdesc(rs.getString("reportdesc"));
				report.setReporttype(rs.getString("reporttype"));
				report.setReportstatus(rs.getString("reportstatus"));
				report.setCommid(rs.getString("commid"));
				report.setReportdate(rs.getString("reportdate"));
				report.setResid(rs.getString("resid"));
				
			
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return report;
	}
}