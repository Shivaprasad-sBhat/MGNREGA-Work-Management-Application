package com.bean;

public class GPM {

	 private int gpm_id;             //pk
	 private String gpm_name;
	 private String email;
	 private String password;
	 private String address;
	 private int pincode;
	
	 
public GPM() {
	// TODO Auto-generated constructor stub
}


public GPM(int gpm_id, String gpm_name, String email, String password, String address, int pincode) {
	super();
	this.gpm_id = gpm_id;
	this.gpm_name = gpm_name;
	this.email = email;
	this.password = password;
	this.address = address;
	this.pincode = pincode;
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


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public int getPincode() {
	return pincode;
}


public void setPincode(int pincode) {
	this.pincode = pincode;
}


@Override
public String toString() {
	return "GPM [gpm_id=" + gpm_id + ", gpm_name=" + gpm_name + ", email=" + email + ", password=" + password
			+ ", address=" + address + ", pincode=" + pincode + "]";
}


	 
}
