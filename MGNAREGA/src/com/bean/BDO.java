package com.bean;

public class BDO {

	private int b_id;                   //pk
	private String b_name;
	private String email;
	private String State;
	private String District;
	private String pincode;
	private String password;
	
	public BDO() {
		// TODO Auto-generated constructor stub
	}

	public BDO(int b_id, String b_name, String email, String state, String district, String pincode, String password) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.email = email;
		State = state;
		District = district;
		this.pincode = pincode;
		this.password = password;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BDO [b_id=" + b_id + ", b_name=" + b_name + ", email=" + email + ", State=" + State + ", District="
				+ District + ", pincode=" + pincode + ", password=" + password + "]";
	}
	
	
}
