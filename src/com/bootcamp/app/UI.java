package com.bootcamp.app;

import java.util.ArrayList;

import java.util.Scanner;

public class UI {
	
		public static void showMenu() throws Exception {
			
		Scanner sn = new Scanner(System.in);	
		System.out.println("\n### Menu home ###");
        System.out.println("1. Menu Customer");
        System.out.println("2. Menu Account");
        System.out.println("3. Menu Transaction");
        System.out.println("0. Exit");
        System.out.print("Choose \t: ");
        String no = sn.next();
        
        if(no.equals("1")){
        	UICustomer uic = new UICustomer();
        	uic.showMenuCustomer();
        }else if(no.equals("0")){
            System.exit(0);
        }else{
            System.out.println("Not found");
         
        }
		
	}
}
