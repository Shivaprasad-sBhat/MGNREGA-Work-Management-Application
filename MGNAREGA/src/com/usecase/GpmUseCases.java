package com.usecase;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dao.GpmDaoImpl;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;
import com.model.Employee;
import com.model.EmployeeDto;
import com.model.GPM;
import com.model.GpmDto;
import com.model.Project;

public class GpmUseCases {
	
	Scanner sc = new Scanner(System.in);
	GpmDaoImpl gpmi = new GpmDaoImpl();
	
	  final String reset = "\u001B[0m";
      final String yellow = "\u001B[33m";
      final String yellowbg = "\u001B[43m";
	  final String purple = "\u001B[35m";
	  final String	redbg = "\u001B[41m";
	  final String	red =  "\u001B[31m";
	  final String	whitebg ="\u001B[47m";
	  final String	green = "\u001B[32m";
	  final String cyan	 = "\u001B[36m";
	  final String cyanbg = "\u001B[46m";
	  
	  
	  
	  public void gpmLogin() {
		
				System.out.println("Enter GPM email address:");
				String email = sc.nextLine();
				
				System.out.println("Enter password");
				String password = sc.nextLine();
				GPM gpm = new GPM();
				
				gpm.setEmail(email);
				gpm.setPassword(password);
				
					
			
				try {
					gpm = gpmi.loginGPM(gpm);
						if(gpm!=null) {
						
						System.out.println(green+"Wellcome GPM: "+gpm.getGpm_name()+reset+"\n");
						gpmUseCases();
						return;
					}
					else {
						System.out.println("Login failed..");
						return;
					}		
					
			}
			catch (GpmException e) {
				
				 System.out.println(redbg+""+e.getMessage()+reset);
			}
					
	 }
		  
	 
	     public void gpmUseCases() {
		
	    	 	System.out.println("1. Create employee"+"\n"+"2. Display project assigned to gpm "+"\n"+"3. Assign projects to employee "+"\n"+"4. Display Working employee details"+"\n"+"5. Exit");
				
				System.out.println(cyan+"Enter the choise :"+reset);
				
				boolean flag=true;
				
					
			  try {
				int n = sc.nextInt();
				
				switch(n) {
				 
				case 1:
					createEmployee();
					gpmUseCases();
					break;
					
				case 2:
					displayProjectAssiginedGPM();
					gpmUseCases();
					break;
				case 3:
					assignProject();
					gpmUseCases();
					break;
				
				case 4:
					workingEmployees();
					gpmUseCases();
					break;
				
				case 5:
					return;
					
				default:
					flag=false;
				 }
				
			}
			 catch (InputMismatchException e) {
					
				 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
					 flag=false;
					 sc.nextLine();
				
			}
			  if(!flag)
				  gpmUseCases();
	  
	  }




		public void createEmployee() {
			String name = null;
			String email = null;
			String password = null;
			
			boolean flag = true;
		
			try {
			sc.nextLine();
		
			System.out.println("Enter Employee name :");
			  name=sc.nextLine();
			
			System.out.println("Enter email");
			email=sc.nextLine();
			System.out.println("Enter password");
			 password=sc.nextLine();
			
			}
			 catch (InputMismatchException e) {
					
				 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
				flag=false;
				 sc.next();
			}
			if(flag) {
		
			
				Employee emp = new Employee();
				emp.setName(name);
				emp.setEmail(email);
				emp.setPassword(password);
				
				
				try {
					int n = gpmi.createEmploye(emp);
					
					if(n>0) {
				 		System.out.println(green+"1 Employee created.."+reset);
				 		System.out.println();
				 	}
				} 	
			 	 catch (EmployeeException e) {
			 		 System.out.println(redbg+""+e.getMessage()+reset);
			 		 createEmployee();
					
			 	}
				}
			else {
				createEmployee();
			}	
		}
		
		
		
		
		public void displayProjectAssiginedGPM() {
			
	
				
				try {
					List<GpmDto> li = gpmi.displayProjectAssignedToGpm();
				
				
				if(li.isEmpty()) {
					 System.out.println(redbg+"Project Details not found!"+reset);
				}
				
				else {
					li.forEach(p -> System.out.println(whitebg+red+""+p+""+reset+"\n"));	
				}
				
				} catch (ProjectException e1) {
					System.out.println(e1.getMessage());
				}
			
			
		}
		
		
		
		public void assignProject() {
			
			int projectid = 0;
			int employeeid = 0;
			int salary=0;
			int twd=0;
			boolean flag=true;

			try {
		
				System.out.println("Enter Project ID");
				projectid=sc.nextInt();
				System.out.println("Enter Employee ID");
				employeeid=sc.nextInt();
				System.out.println("Enter Employee wages");
				salary=sc.nextInt();
				System.out.println("Enter total working days");
				twd=sc.nextInt();
				
			}
			 catch (InputMismatchException e) {
					
				 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
				 flag=false;
				 sc.next();
			}
			if(flag) {
				Employee emp=new Employee();
				emp.setEmp_id(employeeid);
				emp.setSalary(salary);
				emp.setTotal_working_days(twd);
				
				Project p=new Project();
				p.setProject_id(projectid);
				
				try {
				int n =	gpmi.assignProjectToEmployee(p, emp);
				
				if(n>0) {
					System.out.println(green+"1 Project is assigned to emplyee."+reset);
			 		System.out.println();
				}
				} catch (EmployeeException e) {
					 System.out.println(redbg+""+e.getMessage()+reset);
						assignProject();
				} catch (ProjectException e) {
					 System.out.println(redbg+""+e.getMessage()+reset);
						assignProject();
				}	
				
			}
			
			else {
				assignProject();
			}
		
			
		}
		
		
		public void workingEmployees() {
			
			try {
				List<EmployeeDto> li=gpmi.displayEmployeeDetails();
				
				if(li.isEmpty()) {
					 System.out.println(redbg+"Employee Details not found!"+reset);
				}
				
				else {
					li.forEach(e -> System.out.println(whitebg+purple+""+e+""+reset+"\n"));	
				}
				
				
			} catch (EmployeeException e) {
				 System.out.println(redbg+""+e.getMessage()+reset);
			}
			
			
			
		}
		
		
}
