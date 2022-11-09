package com.bean;

public class Project {
	
	private int project_id;				//pk
	private String p_name;
	private int cost_estimate;
	private int total_workers;
	
public Project() {
	// TODO Auto-generated constructor stub
}

public Project(int project_id, String p_name, int cost_estimate, int total_workers) {
	super();
	this.project_id = project_id;
	this.p_name = p_name;
	this.cost_estimate = cost_estimate;
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

public int getCost_estimate() {
	return cost_estimate;
}

public void setCost_estimate(int cost_estimate) {
	this.cost_estimate = cost_estimate;
}

public int getTotal_workers() {
	return total_workers;
}

public void setTotal_workers(int total_workers) {
	this.total_workers = total_workers;
}

@Override
public String toString() {
	return "Project [project_id=" + project_id + ", p_name=" + p_name + ", cost_estimate=" + cost_estimate
			+ ", total_workers=" + total_workers + "]";
}


}
