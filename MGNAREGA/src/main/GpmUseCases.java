package main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.bean.BDO;
import com.bean.Employee;
import com.bean.EmployeeDto;
import com.bean.GPM;
import com.bean.Project;
import com.dao.EmployeeDaoImpl;
import com.dao.GpmDaoImpl;
import com.exception.BdoException;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;

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
		
				System.out.println("Enter email address:");
				String email = sc.nextLine();
				
				System.out.println("Enter password");
				String password = sc.nextLine();
				GPM gpm = new GPM();
				
				gpm.setEmail(email);
				gpm.setPassword(password);
				
					
			
				try {
					gpm = gpmi.loginGPM(gpm);
						if(gpm!=null) {
						
						System.out.println(yellowbg+"Wellcome BDO: "+gpm.getGpm_name()+reset+"\n");
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
		
	    	 	System.out.println("1. Create employee"+"\n"+"2. Display Employee details "+"\n"+"3. Assign projects to employee "+"\n"+"4. Display Working employee details"+"\n"+"5. Exit");
				
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
					displayAllEmployee();
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
				 		System.out.println(green+"GPM created.."+reset);
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
		
		
		
		
		public void displayAllEmployee() {
			
			
		}
		
		
		
		public void assignProject() {
			String name = null;
			String email = null;
			String password = null;
			int salary = 0;
			int total_working_days = 0;
			System.out.println("Enter  salary");
			salary=sc.nextInt();
			System.out.println("Enter total_working_days");
			total_working_days=sc.nextInt();
		}
		
		
		public void workingEmployees() {
			
		}
		
		
}
