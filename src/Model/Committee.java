package Model;

public class Committee {
	private String  commid;
	private String commname;
	private String commphoneno;
	private String commaddress;
	private String commpass;
	private String presidentid;
	private String validLogin;
	public String getCommid() {
		return commid;
	}
	public void setCommid(String commid) {
		this.commid = commid;
	}
	public String getCommname() {
		return commname;
	}
	public void setCommname(String commname) {
		this.commname = commname;
	}
	public String getCommphoneno() {
		return commphoneno;
	}
	public void setCommphoneno(String commphoneno) {
		this.commphoneno = commphoneno;
	}
	public String getCommaddress() {
		return commaddress;
	}
	public void setCommaddress(String commaddress) {
		this.commaddress = commaddress;
	}
	public String getCommpass() {
		return commpass;
	}
	public void setCommpass(String commpass) {
		this.commpass = commpass;
	}
	public String getPresidentid() {
		return presidentid;
	}
	public void setPresidentid(String presidentid) {
		this.presidentid = presidentid;
	}
	public String isValidLogin() {
		return validLogin;
	}
	public void setValidLogin(String validLogin) {
		this.validLogin = validLogin;
	}

}