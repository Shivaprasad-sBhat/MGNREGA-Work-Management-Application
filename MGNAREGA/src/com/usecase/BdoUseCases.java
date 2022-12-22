package com.usecase;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dao.BdoDaoImpl;
import com.exception.BdoException;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;
import com.model.BDO;
import com.model.EmployeeDto;
import com.model.GPM;
import com.model.Project;



public class BdoUseCases {
	
	Scanner sc = new Scanner(System.in);
	BdoDaoImpl bdoi = new BdoDaoImpl();
	
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
	    
	public void loginBDO() {
		try {
		System.out.println("Enter email address:");
		String email = sc.nextLine();
		
		System.out.println("Enter password");
		String password = sc.nextLine();
		BDO bdo = new BDO();
		
		bdo.setEmail(email);
		bdo.setPassword(password);
		
			
		BDO bdo1 =bdoi.loginBDO(bdo);
			
			if(bdo1!=null) {
				
				System.out.println(yellowbg+"Wellcome BDO: "+bdo1.getB_name()+reset);
				bdoUseCases();
				return;
			}
			else {
				System.out.println("Login failed..");
				return;
			}
			
		}
		catch (BdoException e) {
			
			 System.out.println(redbg+""+e.getMessage()+reset);
		}
		
	}
	

	
	
	
	public void bdoUseCases() {
		
		System.out.println("1. Create project"+"\n"+"2. Display Projects"+"\n"+"3. Create GPM "+"\n"+"4. Disply GPM details"+"\n"+"5. Allocate Project to GPM"+"\n"+"6. Display Employee Details"+"\n"+"7. Exit");
		
		System.out.println(cyan+"Enter the choise :"+reset);
		
		boolean flag=true;
		
			
	  try {
		int n = sc.nextInt();
		
		switch(n) {
		 
		case 1:
			createProject();
			bdoUseCases();
			break;
			
		case 2:
			displayProject();
			bdoUseCases();
			break;
		case 3:
			createGPM();
			bdoUseCases();
			break;
		
		case 4:
			displyGPM();
			bdoUseCases();
			break;
		
		case 5:
			allocateProject();
			bdoUseCases();
			break;
		case 6:
			displyEmployeDetails();
			bdoUseCases();
			break;
		case 7:
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
		  bdoUseCases() ;
		
}


	
	
	
	public void createProject() {
		String name =null;
		int amount = 0;
		int day =0;
		boolean flag=true;
	 try {
			
		sc.nextLine();
		System.out.println("Enter project name");
		 name = sc.nextLine();
		
		System.out.println("Enter project cost");
		amount = sc.nextInt();
		
		System.out.println("Enter estimated working days");
		day = sc.nextInt();
	 }
		 catch (InputMismatchException e) {
		
			 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
			flag=false;
			sc.next();
			
		}
	 	if(flag) {
		 try {
			 Project p = new Project();
			 p.setP_name(name);
			 p.setProj_amount(amount);
			 p.setTotal_workers(day);
		
		
			int n = bdoi.createProject(p);
			
			if(n>0) {
				System.out.println(green+"Project created.."+reset);
			}
		
		} catch (ProjectException e) {
			 System.out.println(redbg+""+e.getMessage()+reset);
			
			
		}
	 }
	 else {
		 createProject();
	 }
		
		
	}
	
	
	public void displayProject() {
		
		try {
		
		List<Project>	li = bdoi.displayProject();
		
		if(li.isEmpty()) {
			System.out.println(redbg+"Projects not found!");
		}
		else {
			
			li.forEach(p -> System.out.println(whitebg+green+""+p+""+reset+"\n"));	
		}
		}
		catch (ProjectException e) {
			 System.out.println(cyanbg+""+e.getMessage()+reset);
			 bdoUseCases();
				
		}
		
	}
	
	
	public void createGPM() {
		String name = null;
		String email = null;
		String password = null;
		String address = null;
		int pincode = 0;
		boolean flag = true;
		
		try {
		sc.nextLine();
	
		System.out.println("Enter GPM name :");
		  name=sc.nextLine();
		
		System.out.println("Enter email");
		email=sc.nextLine();
		System.out.println("Enter password");
		 password=sc.nextLine();
		System.out.println("Enter  address");
		 address=sc.nextLine();
		System.out.println("Enter pincode");
		 pincode=sc.nextInt();
		}
		 catch (InputMismatchException e) {
				
			 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
			flag=false;
			 sc.next();
		}
		if(flag) {
		try {
		GPM gpm = new GPM(0,name,email,password,address,pincode);
		
		
		 	int n= bdoi.createGPM(gpm);
		 	
		 	if(n>0) {
		 		System.out.println(green+"GPM created.."+reset);
		 		System.out.println();
		 	}
			}
			
		 catch (GpmException e) {
			 System.out.println(redbg+""+e.getMessage()+reset);
			 createGPM();
				
		 	}
			}
		else {
			createGPM() ;
		}	
	}
	
	public void displyGPM() {
		
		try {
		List<GPM> li = bdoi.displayGPM();
		

		li.forEach(g ->System.out.println(whitebg+purple+""+g+""+reset+"\n"));
			
			
		} 
		catch (GpmException e) {
			System.out.println(e.getMessage());
		
		}
	}
	
	public void allocateProject() {
		int pid=0;
		int gid=0;
		boolean flag=true;
		try {
		System.out.println("Enter project ID :");
		 pid=sc.nextInt();
		
		System.out.println("Enter GPM ID :");
		 gid=sc.nextInt();
		}
		catch (InputMismatchException e) {
			
		 System.out.println(redbg+""+"java.util.InputMismatchException"+reset);
		 flag=false;
		 sc.next();
		
		}
		if(flag) {
			try {
			
		GPM g=new GPM();
		g.setGpm_id(gid);

		Project p = new Project();
		p.setProject_id(pid);
		
		
		
			String m = bdoi.allocateProjectTOGPM(p, g);
			
			System.out.println(green+""+m+""+reset);
		
			
		}
		
		catch (ProjectException e) {
			 System.out.println(redbg+""+e.getMessage()+reset);
		 }
		}
		else {
			allocateProject();	
		}
			
		
		
	}
	
	
	
	
	public void displyEmployeDetails() {
		  
		    
		    try {
		List<EmployeeDto> li =	bdoi.displayProjectEmployeDetails();
		
		System.out.println();
		if(li.isEmpty()) 
			System.out.println(red+"Employee not found.."+reset);
		else
		  li.forEach(e -> System.out.println(whitebg+red+""+e+""+reset+"\n"));
			
		} catch (EmployeeException e) {
			 System.out.println(redbg+""+e.getMessage()+reset);
			
		}
	}

	
	
	
	
	
	

}
