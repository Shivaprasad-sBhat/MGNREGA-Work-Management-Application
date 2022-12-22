package com.model;

public class GpmDto {
	 private int gpm_id;             
	 private String gpm_name;
	 private String email;
	 private String address;
	 private int pincode;
	 private int project_id;				//pk
	 private String p_name;
   	 private int proj_amount;
	 private int total_workers;	 
	 
	 
	 public GpmDto() {
		// TODO Auto-generated constructor stub
	}


	public GpmDto(int gpm_id, String gpm_name, String email, String address, int pincode, int project_id, String p_name,
			int proj_amount, int total_workers) {
		super();
		this.gpm_id = gpm_id;
		this.gpm_name = gpm_name;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
		this.project_id = project_id;
		this.p_name = p_name;
		this.proj_amount = proj_amount;
		this.total_workers = total_workers;
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


	public int getProject_id() {
		return project_id;
	}


	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public int getProj_amount() {
		return proj_amount;
	}


	public void setProj_amount(int proj_amount) {
		this.proj_amount = proj_amount;
	}


	public int getTotal_workers() {
		return total_workers;
	}


	public void setTotal_workers(int total_workers) {
		this.total_workers = total_workers;
	}


	@Override
	public String toString() {
		return "GPM_id=" + gpm_id + ", Name=" + gpm_name + ", Email=" + email + ", Address=" + address
				+ ", Pincode=" + pincode + ", Project_id=" + project_id + ", Project=" + p_name + ", Project Amount="
				+ proj_amount + ", Total Working Days=" + total_workers ;
	}
	 
	 
	 
}
