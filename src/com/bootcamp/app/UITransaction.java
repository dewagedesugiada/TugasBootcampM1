package com.bootcamp.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.bootcamp.app.controller.TransactionDao;
import com.bootcamp.app.controller.TransactionDaoImpl;
import com.bootcamp.app.model.Transaction;

public class UITransaction {

	private static Scanner up;
	private static Scanner in;

	
	
	public static void menuTransaction() throws Exception {
		Scanner sn = new Scanner(System.in);
		System.out.println("----------------------------------------");
		System.out.println("#           MENU TRANSACTION           #");
		System.out.println("========================================");
		System.out.println("|Option :                              |");
		System.out.println("|  1. Input Data Transaction           |");
		System.out.println("|  2. View Data Transaction            |");
		System.out.println("|  3. Update Data Transaction          |");
		System.out.println("|  4. Delete Data Transaction          |");
		System.out.println("|  5. Find Data Customer By ID         |");
		System.out.println("|  0. Back                             |");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.print("");
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
				menuTransaction();
			}
	        
	   	}
	
		public static void formInput() throws Exception {
			Scanner an = new Scanner(System.in) ;
			Scanner in = new Scanner(System.in) ;
			System.out.println("=========== INPUT DATA ===========");
			System.out.print("ID Transaction :");
			int id_trans = in.nextInt();
			System.out.print("Type :");
			String type = an.nextLine();
			System.out.print("Amount :");
			String amount = an.nextLine();
			System.out.print("Amount Sign :");
			String amountsign = an.nextLine();
			System.out.print("Account Number :");
			int accountnumber = an.nextInt();
			
			Transaction tr = new Transaction(id_trans, type, amount, amountsign, accountnumber);
			
			TransactionDao tradao = new TransactionDaoImpl();
			String notif = tradao.insert(tr);
			System.out.println(notif);
			showData();
					
		}
		
		public static void showData() throws Exception {
			Scanner sn = new Scanner(System.in);
			TransactionDao tradao = new TransactionDaoImpl();
			List<Transaction> list = tradao.getList();
			if(list!=null && !list.isEmpty()) {
				System.out.println("=========== DATA TRANSACTION ===========");
				for(Transaction item : list) {
					System.out.println("ID Transaction\t\t : "+item.getIdTransaction());
					System.out.println("Type\t\t\t : "+item.getType());
					System.out.println("Amount\t\t\t : "+item.getAmount());
					System.out.println("Amount Sign\t\t : "+item.getAmountSign());
					System.out.println("Account Number\t\t : "+item.getAccountNumber());
					System.out.println("==================================");
				}
			}
			System.out.println("Back to main menu (y/Y) : ");
			String in = sn.nextLine();
			if (in.equals("y") || in.equals("Y")) {
				menuTransaction();
			}else {
				System.err.println("wrong choice !");;
			}
		}
		
		public static void update() throws Exception {
			up = new Scanner(System.in);
			in = new Scanner(System.in);
			System.out.println("=========== UPDATE DATA ===========");
			System.out.print("Enter account number update :");
			int id = in.nextInt();
			System.out.print("Type :");
			String type = up.nextLine();
			System.out.print("Amount :");
			String amount = up.nextLine();
			System.out.print("Amount Sign :");
			String amountsign = up.nextLine();
			
			Transaction tr = new Transaction(type, amount, amountsign, id);
			TransactionDao tradao = new TransactionDaoImpl();
			String notif = tradao.update(tr);
			System.out.println(notif);
			showData();
			
		}
		
		public static void delete() throws Exception{
			Scanner dl = new Scanner(System.in);
			System.out.println("=========== DELETE DATA ===========");
			System.out.print("Enter account number deleted :");
			int id = dl.nextInt();
			Transaction tr = new Transaction();
			tr.setId(id);
			TransactionDao tradao = new TransactionDaoImpl();
			String notif = tradao.delete(tr);
			System.out.println(notif);
			showData();
		}
}
