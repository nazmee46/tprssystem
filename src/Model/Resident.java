package Model;

public class Resident {
	private String resid;
	private String resname;
	private String resphoneno;
	private String resaddress;
	private String respass;
	private String validLogin;

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	public String getResphoneno() {
		return resphoneno;
	}

	public void setResphoneno(String resphoneno) {
		this.resphoneno = resphoneno;
	}

	public String getResaddress() {
		return resaddress;
	}

	public void setResaddress(String resaddress) {
		this.resaddress = resaddress;
	}

	public String getRespass() {
		return respass;
	}

	public void setRespass(String respass) {
		this.respass = respass;
	}

	public String isValidLogin() {
		return validLogin;
	}

	public void setValidLogin(String validLogin) {
		this.validLogin = validLogin;
	}
}
