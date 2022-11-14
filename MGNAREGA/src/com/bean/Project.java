package com.bean;

public class Project {
	
	private int project_id;				//pk
	private String p_name;
	private int proj_amount;
	private int total_workers;
	
public Project() {
	// TODO Auto-generated constructor stub
}

public Project(int project_id, String p_name, int proj_amount, int total_workers) {
	super();
	this.project_id = project_id;
	this.p_name = p_name;
	this.proj_amount = proj_amount;
	this.total_workers = total_workers;
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
	return "Project ID=" + project_id + ", Project=" + p_name + ", Project Amount=" + proj_amount
			+ ", Total Workers=" + total_workers + "]";
}


}
