package com.bean;

public class EmployeeDto {
	
	private int emp_id;               
	private String name;
	private String email;
	private String project;
	private int salary;
	private int total_working_days;
	private int total_salary;
	
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int emp_id, String name, String email, String project, int salary,
			int total_working_days, int total_salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.project = project;
		this.salary = salary;
		this.total_working_days = total_working_days;
		this.total_salary = total_salary;
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

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}



	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTotal_working_days() {
		return total_working_days;
	}

	public void setTotal_working_days(int total_working_days) {
		this.total_working_days = total_working_days;
	}

	public int getTotal_salary() {
		return total_salary;
	}

	public void setTotal_salary(int total_salary) {
		this.total_salary = total_salary;
	}

	@Override
	public String toString() {
		return "Emp_id=" + emp_id + ", Name=" + name + ", Email=" + email + ", Project=" + project
				+  ", Salary=" + salary + ", Total working days=" + total_working_days
				+ ", Total salary=" + total_salary ;
	}
	
	
	
}
