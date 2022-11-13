package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	  final String reset = "\u001B[0m";
	  final String	redbg = "\u001B[41m";
	public static void main(String[] args) {
	
		System.out.println("Wellcome TO MGNAREGA management system");
		System.out.println("---------------------------------------");
		System.out.println();
		Main m=new Main();
		m.usecase();
		
		System.out.println("Thank you...");

	}
	
	
	
	public void usecase() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1. Login BDO"+"\n"+"2. Login GPM"+"\n"+"3. Login Employee"+"\n"+"4. Exit");
		System.out.println("Enter your choise :");
		
		boolean flag=true;
		try {
		int n = sc.nextInt();
		switch(n) {
		
		case 1:
			BdoUseCases bdouc = new BdoUseCases();
			bdouc.loginBDO();
			usecase();
			break;
			

		case 2:
			GpmUseCases gpmu = new GpmUseCases();
			gpmu.gpmLogin();
			usecase();
			break;
			

		case 3:
			usecase();
			break;
			
		case 4:
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
	  if(!flag) {
		  usecase();
		
		}		
		
	}

}
