package main.java.enrollmentParser.model;

public class User implements Comparable{

	private String userID;
	private String fName;
	private String lName;
	private int Version;
	private String insuranceCompany;
	
	public User(String userID, String fName, String lName, int version, String insuranceCompany) {
		super();
		this.userID = userID;
		this.fName = fName;
		this.lName = lName;
		Version = version;
		this.insuranceCompany = insuranceCompany;
	}

	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int version) {
		Version = version;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}



	@Override
	public String toString() {
		return userID + ", " + fName + ", " + lName + ", " + Version
				+ ", " + insuranceCompany;
	}

//Allow users to be compared using their last and first name
	@Override
	public int compareTo(Object o) {
		int result = this.getlName().compareToIgnoreCase(((User) o).getlName());
		if(result !=0) {
			return result;
		}
		return this.getfName().compareToIgnoreCase(((User)o).getfName());
	}
	
	
	
}
