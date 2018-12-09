package com.bootcamp.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.bootcamp.app.controller.AccountDao;
import com.bootcamp.app.controller.AccountDaoImpl;
import com.bootcamp.app.model.Account;

public class UIAccount {

	private static Scanner up;
	private static Scanner in;

	public static void menuAccount() throws Exception {
		Scanner sn = new Scanner(System.in);
		System.out.println("----------------------------------------");
		System.out.println("|           MENU ACCOUNT         |");
		System.out.println("========================================");
		System.out.println("|Option :                              |");
		System.out.println("|  1. Input Data Account               |");
		System.out.println("|  2. View Data Account                |");
		System.out.println("|  3. Update Data Account              |");
		System.out.println("|  4. Delete Data Account              |");
		System.out.println("|  5. Find Data Customer By ID         |");
		System.out.println("|  0. Back                             |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.print("Choose \t: ");
	    String choose = sn.next();
	        
	        if (choose.equals("1")) {
				formInput();
			}else if (choose.equals("2")) {
				showData();
			}else if (choose.equals("3")) {
				update();
			}else if (choose.equals("4")) {
				delete();
			}else if (choose.equals("5")) {
				
			}else if (choose.equals("0")) {
				UI ui = new UI() ;
				ui.showMenu();
			}else {
				System.out.println("The choice you entered is not registered (Please try again)..");
				menuAccount();
			}
	        
	   	}
	
	public static void formInput() throws Exception {
		Scanner an = new Scanner(System.in) ;
		Scanner in = new Scanner(System.in) ;
		System.out.println("=========== INPUT DATA ===========");
		System.out.print("Account Number :");
		int accountnumber = in.nextInt();
		System.out.print("Open Date :");
		String opendate = an.nextLine();
		System.out.print("Balance :");
		String balance = an.nextLine();
		System.out.print("CustomerNumber :");
		int customerNumber = in.nextInt();
		
		Account ac = new Account(accountnumber,opendate,balance,customerNumber);
		
		AccountDao acdao = new AccountDaoImpl();
		String notif = acdao.insert(ac);
		System.out.println(notif);
		showData();
				
	}
	
	public static void showData() throws Exception {
		Scanner sn = new Scanner(System.in);
		AccountDao acdao = new AccountDaoImpl();
		List<Account> list = acdao.getList();
		if(list!=null && !list.isEmpty()) {
			System.out.println("=========== DATA ACCOUNT ===========");
			for(Account item : list) {
				System.out.println("AccountNumber\t\t : "+item.getAcountNumber());
				System.out.println("OpenDate\t\t : "+item.getOpenDate());
				System.out.println("Balance\t\t\t : "+item.getBalance());
				System.out.println("CustomerNumber\t\t : "+item.getCustomerNumber());
				System.out.println("==================================");
			}
		}
		System.out.println("Back to main menu (y/Y) : ");
		String in = sn.nextLine();
		if (in.equals("y") || in.equals("Y")) {
			menuAccount();
		}else {
			System.err.println("wrong choice !");;
		}
	}
	
	public static void delete() throws Exception{
		Scanner dl = new Scanner(System.in);
		System.out.println("=========== DELETE DATA ===========");
		System.out.print("Enter account number deleted :");
		int id = dl.nextInt();
		Account ac = new Account();
		ac.setId(id);
		AccountDao acdao = new AccountDaoImpl();
		String notif = acdao.delete(ac);
		System.out.println(notif);
		showData();
	}
	
	public static void update() throws Exception {
		up = new Scanner(System.in);
		in = new Scanner(System.in);
		System.out.println("=========== UPDATE DATA ===========");
		System.out.print("Enter account number update :");
		int id = in.nextInt();System.out.print("Balance :");
		String balance = up.nextLine();
		
		
		Account ac = new Account(balance,id);
		
		AccountDao acdao = new AccountDaoImpl();
		String notif = acdao.update(ac);
		System.out.println(notif);
		showData();
	}
	
}
