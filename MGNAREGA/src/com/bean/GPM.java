package com.bean;

public class GPM {

	 private int gpm_id;             //pk
	 private String gpm_name;
	 private String email;
	 private String state;
	 private String district;
	 private String panchayat;
	 private String pincode;
	 private String project_id;     //fk
	 
public GPM() {
	// TODO Auto-generated constructor stub
}

public GPM(int gpm_id, String gpm_name, String email, String state, String district, String panchayat, String pincode,
		String project_id) {
	super();
	this.gpm_id = gpm_id;
	this.gpm_name = gpm_name;
	this.email = email;
	this.state = state;
	this.district = district;
	this.panchayat = panchayat;
	this.pincode = pincode;
	this.project_id = project_id;
}

public int getGpm_id() {
	return gpm_id;
}

public void setGpm_id(int gpm_id) {
	this.gpm_id = gpm_id;
}

public String getGpm_name() {
	return gpm_name;
}

public void setGpm_name(String gpm_name) {
	this.gpm_name = gpm_name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getDistrict() {
	return district;
}

public void setDistrict(String district) {
	this.district = district;
}

public String getPanchayat() {
	return panchayat;
}

public void setPanchayat(String panchayat) {
	this.panchayat = panchayat;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

public String getProject_id() {
	return project_id;
}

public void setProject_id(String project_id) {
	this.project_id = project_id;
}

@Override
public String toString() {
	return "GPM [gpm_id=" + gpm_id + ", gpm_name=" + gpm_name + ", email=" + email + ", state=" + state + ", district="
			+ district + ", panchayat=" + panchayat + ", pincode=" + pincode + ", project_id=" + project_id + "]";
}	 
	 
	 

	 
}
