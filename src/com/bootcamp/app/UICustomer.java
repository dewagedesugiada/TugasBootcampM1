package com.bootcamp.app;

import java.util.List; 
import java.util.Scanner;
import java.util.ArrayList;
import com.bootcamp.app.controller.CustomerDao;
import com.bootcamp.app.controller.CustomerDaoImpl;
import com.bootcamp.app.model.Customer;

public class UICustomer {
	
private static Scanner an;
private static Scanner in;

public static void showMenuCustomer() throws Exception {
		
		Scanner sn = new Scanner(System.in);
		System.out.println("\n### Menu Customer ###");
        System.out.println("1. Input data");
        System.out.println("2. View data");
        System.out.println("3. Update data");
        System.out.println("4. Delete data");
        System.out.println("5. Find data");
        System.out.println("0. Back");
        System.out.print("Choose \t: ");
        String no = sn.next();
        
        if(no.equals("1")){
         showFormInput();
        }else if(no.equals("2")){
        	ShowData();
        }else if(no.equals("3")){
        	update();
        }else if(no.equals("4")){
          deleteData();
        }else if(no.equals("0")){
          
        }else{
            System.out.println("Not found");
          
        }
	}

	public static void showFormInput() throws Exception {
		
		Scanner an = new Scanner(System.in) ;
		Scanner in = new Scanner(System.in) ;
		System.out.print("Account Number :");
		int accountnumber = in.nextInt();
		System.out.print("First Name :");
		String firstname = an.nextLine();
		System.out.print("Last Name :");
		String lastname = an.nextLine();
		System.out.print("Date Of Birth :");
		String datebirth = an.nextLine();
		System.out.print("Username :");
		String username = an.nextLine();
		System.out.print("Password :");
		String password = an.nextLine();
		System.out.print("Phone Type :");
		String phonetype = an.nextLine();
		System.out.print("Phone Number :");
		String phonenumber = an.nextLine();
		
		Customer cs = new Customer(accountnumber,firstname,lastname,datebirth,username,password,phonetype,phonenumber);
		
		CustomerDao cusdao = new CustomerDaoImpl();
		String notif = cusdao.insert(cs);
		System.out.println(notif);
		ShowData();
		  
	}
	
	public static void ShowData() throws Exception {
		Scanner sc = new Scanner(System.in);
		CustomerDao csdao = new CustomerDaoImpl();
		List<Customer> list = csdao.getList();
		if(list!=null && !list.isEmpty()) {
			for (Customer customer : list) {
				System.out.println("customer\t\t : "+customer.getCustomerNumber());
				System.out.println("firstName\t\t : "+customer.getFirstName());
				System.out.println("lastName\t\t : "+customer.getLastName());
				System.out.println("BirthDate\t\t : "+customer.getBirthDate());
				System.out.println("Username\t\t : "+customer.getUsername());
				System.out.println("Password\t\t : "+customer.getPassword());
				System.out.println("PhoneType\t\t : "+customer.getPhonetype());
				System.out.println("PhoneNumber\t\t : "+customer.getPhoneNumber());
				System.out.println("==================================");
				
				}
			System.out.print("Back to main menu (yes) :");
			String choose =  sc.nextLine();
			if (choose.equals("yes")) {
				showMenuCustomer();
			}else {
				System.exit(0);
			}
		}else {
			System.out.println("empty data");
		}

	}
	
	public static void deleteData() throws Exception {
		Scanner an = new Scanner(System.in) ;
		System.out.print("Masukan id yang ingin di hapus :");
		int id = an.nextInt();	
		Customer cs = new Customer();
		cs.setId(id);		
		CustomerDao csdao = new CustomerDaoImpl();
		String notif = csdao.delete(cs);
		System.out.println(notif);
		ShowData();
		
		
	}
	
	public static void update() throws Exception {
		an = new Scanner(System.in);
		in = new Scanner(System.in);
		System.out.print("choose the customer number you want to change :");
		int id = in.nextInt();
		System.out.print("First Name :");
		String firstname = an.nextLine();
		System.out.print("Last Name :");
		String lastname = an.nextLine();
		System.out.print("Date Of Birth :");
		String datebirth = an.nextLine();
		System.out.print("Username :");
		String username = an.nextLine();
		System.out.print("Password :");
		String password = an.nextLine();
		System.out.print("Phone Type :");
		String phonetype = an.nextLine();
		System.out.print("Phone Number :");
		String phonenumber = an.nextLine();
	
		
		Customer cs = new Customer(firstname, lastname, datebirth, username, password, phonetype,phonenumber,id);
		
		CustomerDao csdao = new CustomerDaoImpl();
		String notif = csdao.update(cs);
		System.out.println(notif);
		ShowData();
	}
	
	

}
