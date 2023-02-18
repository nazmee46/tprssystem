package Model;

public class Committee {
	private int commID;
	private String commName;
	private String commPhoneNo;
	private String commAddress;
	private String commPass;
	private String presidentID;
	private String validLogin;

	public int getCommID() {
		return commID;
	}

	public void setCommID(int commID) {
		this.commID = commID;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getCommPhoneNo() {
		return commPhoneNo;
	}

	public void setCommPhoneNo(String commPhoneNo) {
		this.commPhoneNo = commPhoneNo;
	}

	public String getCommAddress() {
		return commAddress;
	}

	public void setCommAddress(String commAddress) {
		this.commAddress = commAddress;
	}

	public String getCommPass() {
		return commPass;
	}

	public void setCommPass(String commPass) {
		this.commPass = commPass;
	}

	public String getPresidentID() {
		return presidentID;
	}

	public void setPresidentID(String presidentID) {
		this.presidentID = presidentID;
	}

	public String isValidLogin() {
		return validLogin;
	}

	public void setValidLogin(String validLogin) {
		this.validLogin = validLogin;
	}
}