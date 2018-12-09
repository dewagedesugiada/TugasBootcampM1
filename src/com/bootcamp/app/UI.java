package com.bootcamp.app;

import java.util.ArrayList;

import java.util.Scanner;

public class UI {
	
		public static void showMenu() throws Exception {
			
		Scanner sn = new Scanner(System.in);	
		System.out.println("----------------------------------------");
		System.out.println("+           MENU BANKING               +");
		System.out.println("========================================");
		System.out.println("|Option :                              |");
		System.out.println("|  1. Menu Customer                    |");
		System.out.println("|  2. Menu Account                     |");
		System.out.println("|  3. Menu Transaction                 |");
		System.out.println("|  0. Exit                             |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.print("Choose \t: ");
        String no = sn.next();
        
        if(no.equals("1")){
        	UICustomer uic = new UICustomer();
        	uic.showMenuCustomer();
        }else if (no.equals("2")) {
        	UIAccount uia = new UIAccount();
        	uia.menuAccount();
        	
		}else if (no.equals("3")) {
        	UITransaction uit = new UITransaction();
        	uit.menuTransaction();
        	
		}
        else if(no.equals("0")){
            System.exit(0);
        }else{
        	System.out.println("The choice you entered is not registered (Please try again)..");
        	showMenu();
         
        }
		
	}
}
