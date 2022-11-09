package com.bean;

public class Employee {

	private int emp_id;               //pk
	private String name;
	private String email;
	private String project_id;        //fk  
	private int working_days;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String name, String email, String project_id, int working_days, int salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.project_id = project_id;
		this.working_days = working_days;
		this.salary = salary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public int getWorking_days() {
		return working_days;
	}

	public void setWorking_days(int working_days) {
		this.working_days = working_days;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", email=" + email + ", project_id=" + project_id
				+ ", working_days=" + working_days + ", salary=" + salary + "]";
	}
	
	
}
