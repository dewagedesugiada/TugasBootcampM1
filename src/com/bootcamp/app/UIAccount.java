package com.bootcamp.app;

import java.util.Scanner;

import com.bootcamp.app.model.Account;

public class UIAccount {

	public static void menuAccount() {
		Scanner sn = new Scanner(System.in);
		System.out.println("\n||| MENU ACCOUNT |||");
		 System.out.println("1. Input data");
	        System.out.println("2. View data");
	        System.out.println("3. Update data");
	        System.out.println("4. Delete data");
	        System.out.println("5. Find data");
	        System.out.println("0. Back");
	        System.out.print("Choose \t: ");
	        String choose = sn.next();
	        
	        if (choose.equals("1")) {
				
			}else if (choose.equals("2")) {
				
			}else if (choose.equals("3")) {
				
			}else if (choose.equals("4")) {
				
			}else if (choose.equals("5")) {
				
			}else if (choose.equals("6")) {
				
			}else {
				System.out.println("The choice you entered is not registered (Please try again)..");
				menuAccount();
			}
	        
	   	}
	
	public static void formInput() {
		Scanner an = new Scanner(System.in) ;
		Scanner in = new Scanner(System.in) ;
		System.out.print("Account Number :");
		int accountnumber = in.nextInt();
		System.out.print("Open Date :");
		String opendate = an.nextLine();
		System.out.print("Balance :");
		String balance = an.nextLine();
		System.out.print("CustomerNumber :");
		int customerNumber = an.nextInt();
		
		Account ac = new Account(accountnumber,opendate,balance,customerNumber);
		
		
		
	}
}
