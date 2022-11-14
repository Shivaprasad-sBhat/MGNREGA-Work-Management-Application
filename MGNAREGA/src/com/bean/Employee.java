package com.bean;

public class Employee {

	private int emp_id;               //pk
	private String name;
	private String email;
	private String password;
	private int salary;
	private int total_working_days;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String name, String email, String password, int salary, int total_working_days) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.total_working_days = total_working_days;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Emp_id=" + emp_id + ", Name=" + name + ", Email=" + email + ", Password=" + password
				+ ", Salary=" + salary + ", Total_working_days=" + total_working_days ;
	}

	
	
}
