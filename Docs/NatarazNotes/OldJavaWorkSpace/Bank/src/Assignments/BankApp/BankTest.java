package Assignments.BankApp;
import java.util.Scanner;

public class BankTest {
	
	public static void main(String args[]){
		
		String str;
		int choice,accountType=1,quit=0;
		choice=0;
		Scanner sc = new Scanner(System.in);
		//creation of objects to Savings and Current Accounts
		CurrentAccount curr_obj = new CurrentAccount();
		SavingsAccount sav_obj = new SavingsAccount();
		
		System.out.println("\n=====WELLCOME TO BANK DEMO PROJECT=====\n");
		while( quit!=1){
			//requesting the Customer to select either Savings or Current account 
			System.out.print("Type 1 for Current Account and Any no for Saving Account : ");
			str=sc.next();
			accountType=Integer.parseInt(str);
			//if accountType is 1 then it is a current account else savings account
			if(accountType==1){
				
				do{   //For Current Account
					//requesting the Customer to select the function he wants to do 
					System.out.println("\n\nChoose Your Choices ...");
					System.out.println("1) New Record Entry ");
					System.out.println("2) Display Record Details ");
					System.out.println("3) Deposit...");
					System.out.println("4) Withdraw...");
					System.out.println("5) Transfer...");
					System.out.println("6) Quit");
					System.out.print("Enter your choice :  ");
					str=sc.next();
					choice=Integer.parseInt(str);
					
					switch(choice){
					
					case 1 :  //Creating the new account
						curr_obj.createAccount();
						break;
					case 2 :  //Displaying account Details
						curr_obj.display();
						break;
					case 3 : //Deposit...
						curr_obj.deposit();
						break;
					case 4 : //Withdraw...
						curr_obj.withdrawal();
						break;
					case 5 : //Transfer...
						curr_obj.transfer();
						break;
					case 6  :
						System.out.println("\n\n.....Closing Current Account.....");
						break;
					default : System.out.println("\nInvalid Choice \n\n");
					}
				}while(choice!=6);
			}
			else{
				do{//For Saving Account
					System.out.println("Choose Your Choices ...");
					System.out.println("1) New Record Entry ");
					System.out.println("2) Display Record Details ");
					System.out.println("3) Deposit...");
					System.out.println("4) Withdraw...");
					System.out.println("5) Transfer...");
					System.out.println("6) Quit");
					System.out.print("Enter your choice :  ");
					str=sc.next();
					choice=Integer.parseInt(str);
					
					switch(choice){
					case 1 :  //Creating the new account
						sav_obj.createAccount();
						break;
					case 2 :  //Displaying account Details
						sav_obj.display();
						break;
					case 3 : //Deposit...
						sav_obj.deposit();
						break;
					case 4 : //Withdraw...
						sav_obj.withdrawal();
						break;
					case 5 : //Transfer...
						sav_obj.transfer();
						break;
					case 6  :
						System.out.println("\n\n.....Closing Current Account.....");
						break;
					default : System.out.println("\nInvalid Choice \n\n");
					}
				}while(choice!=6);
				}
			}
		System.out.print("\nEnter 1 for Exit : ");
		str=sc.next();
		quit=Integer.parseInt(str);
		}
	}