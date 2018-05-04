package Assignments.BankApp;
import java.util.Random;
import java.util.Scanner;

public class SavingsAccount implements Account{
	String str;
	long no;
    long acno,acno1;
    double amt,amt1;
	
	Scanner sc = new Scanner(System.in);
	Random rnd = new Random();
    Customer c = new Customer();
    int totRec = c.totRec;
    int max_limit = c.max_limit;
    double min_bal = c.getMin_bal();

    //Creating new account
	
	public void createAccount(){
		String str;
		long no;
        long acno;
        double amt;
        boolean permit;
        permit=true;
        
        if (totRec>max_limit)
        {
             System.out.println("\n\n\n Sorry we cannot admit you in our bank...\n The number of Customers in the bank is full..\n\n");
             permit=false;
        }

        if(permit = true){   //Allows to create new entry(creating new account)
                           
        System.out.println("\n\n\n=====RECORDING NEW ENTRY=====");
        try{
        	//Setting auto generated number as account number to new customer
            do{
            	acno = rnd.nextLong();
            }while(acno<=0);
            c.setAccountNo(totRec, acno);
            System.out.println("Account Number :  "+c.getAccountNo(totRec));
            
            //Setting the Customer's name while creating new account            
            System.out.print("Enter Customer's Name :  ");
            str= sc.next();
            c.setCustomerName(totRec, str);
            
            //Setting the Customer's account type
            str="Savings Account";   
            c.setAccType(totRec, str);
            System.out.println("Account Type : "+c.getAccType(totRec));
            
            //Setting the Customer's mobile number
            System.out.print("Enter Customer's mobile number :  ");
            no = sc.nextLong();
            c.setMobileNo(totRec, no);
            
          //Setting the Customer's email ID            
            System.out.print("Enter Customer's Email ID :  ");
            str= sc.next();
            c.setEmailID(totRec, str);
            
          //Setting the Customer's address            
            System.out.print("Enter Customer's address :  ");
            str= sc.next();
            c.setAddress(totRec, str);
            
          /*Setting the Customer's ID and username with auto-generated long number using random() method(here I'm setting the CX's ID and username
            is same)*/ 
            do{
            no = rnd.nextLong();
            }while(no<=0);
            c.setCustomerID(totRec, no);
            c.setUsername(totRec, no);
            
          //Setting the Customer's password            
            System.out.print("Enter Customer's Password :  ");
            str= sc.next();
            c.setPassword(totRec, str);
            
            do{
            	System.out.print("Enter Initial  Amount to be deposited : ");
                amt =sc.nextDouble();
                c.setBalance(totRec, amt);
              }while((amt = c.getBalance(totRec))<min_bal);//Validation that minimum amount must be 500

           System.out.println("\n\n\n");
           totRec++;         // Incrementing Total Record(account)    
          }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
     }
 }        
        
    //TO DISPLAY DETAILS OF Account
	
	@SuppressWarnings("unused")
	public void display(){
		
		System.out.println("\n\n=====DISPLAYING DETAILS OF CUSTOMER=====\n");
		try{
			System.out.print("Enter Account number : ");
			acno=sc.nextLong();
			
			//To check whether accNo is valid or Not
			for(int i=0; i<max_limit && acno==c.getAccountNo(i); i++){
				
				System.out.println("\n\nAccount Number : "+c.getAccountNo(i));
				System.out.println("Customer_Name : "+c.getCustomerName(i));
				System.out.println("Account Type : "+c.getAccType(i));
				System.out.println("Customer_ID : "+c.getCustomerID(i));
				System.out.println("Customer_Email_ID : "+c.getEmailID(i));
				System.out.println("Customer_Mobile_No : "+c.getMobileNo(i));
				System.out.println("Customer_Username : "+c.getUsername(i));
				System.out.println("Customer_Password : "+c.getPassword(i));				
				
				//Bank policy is to give 8% interest on Net balance amount
				amt = c.getBalance(i)+(c.getBalance(i)/8);
				c.setBalance(i, amt);
				System.out.println("Balance Amount : "+c.getBalance(i)+"\n\n\n");
				break;
			}
				System.out.println("The account number you entered is wrong..PLease try again");
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	//TO DEPOSIT AN AMOUNT
	
	public void deposit(){
		
		System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");
		
		try{
			
			//Reading deposit value
			System.out.print("Enter Account No : ");
			acno=sc.nextLong();
			
			//To check whether accNo is valid or Not
			for(int i=0; i<max_limit && acno==c.getAccountNo(i); i++){
				
				System.out.print("Enter Amount you want to Deposit  : ");
				amt=sc.nextDouble();
				amt=c.getBalance(i)+amt;
				c.setBalance(i, amt);
				
				//Displaying Deposit Details
				System.out.println("\nAfter Depositing the amount into your account, The update details are...");
				System.out.println("Account Number :  "+acno);
				System.out.println("Balance Amount :  "+c.getBalance(i)+"\n\n\n");
				break;
			}
			System.out.println("The account number you entered is wrong..PLease try again");
				
			}catch(Exception e){   	
				e.printStackTrace();
            }
       }
	
	//TO WITHDRAW BALANCE
	public void withdrawal(){
		double checkamt;
				
		System.out.println("\n\n\n=====WITHDRAW AMOUNT=====");
		
		try{
			//Reading deposit value
			System.out.print("Enter Account No : ");
			acno=sc.nextLong();
			
			//To check whether accNo is valid or Not
			for(int i=0; i<max_limit && acno==c.getAccountNo(i); i++){
				
				System.out.println("Balance is : "+c.getBalance(i));
				System.out.print("Enter Amount you want to withdraw  : ");
				amt=sc.nextDouble();
				checkamt=c.getBalance(i)-amt;
				
				if(checkamt >= min_bal){
					amt=checkamt;
					c.setBalance(i, amt);
					
					//Displaying Deposit Details
					System.out.println("\nAfter withdrawing the amount from your account..The updated detail is...");
					System.out.println("Account Number :  "+acno);
					System.out.println("Balance Amount :  "+c.getBalance(i)+"\n\n\n");
					}
				else{
					System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500\n\n\n");
					}
				break;
				}
			}
            catch(Exception e){
            	e.printStackTrace();
            }
		}
	
	//To transfer the amount from one account to another account
	
	public void transfer() {
		System.out.println("\n\n===========Transfer=================/n/n");
		System.out.println("Enter your account number: ");
		acno = sc.nextLong();
		for(int i=0; i<max_limit && acno==c.getAccountNo(i); i++){
			System.out.println("Enter the account number to which you want to transfer the amount : ");
			acno1 = sc.nextLong();
			for(int j=0; j<max_limit && acno==c.getAccountNo(j); j++){
				System.out.println("Enter the amount you want to transfer : ");
				amt1 = sc.nextDouble();
				
				//displaying the details to the customer
				System.out.println("You're transfering from "+c.getAccountNo(i)+" "+c.getAccountNo(j));
				
				System.out.println("If correct press 1 or  press any key if it is wrong");
				int check = sc.nextInt();
				
				if(check==1){
					
					//checking the account has balance to transfer the entered amount to another account
					
					if(amt1<=c.getBalance(i)){
						
						//taking amount from transferrer account
						amt=c.getBalance(i)-amt1;
						c.setBalance(i, amt);
						
						//depositing amount into receiver account
						amt=c.getBalance(i)+amt;
						c.setBalance(j, amt);
						
						System.out.println(amt1+" is successfully transferred to "+c.getCustomerName(j));
						}
					else{
						
						System.out.println("Your have insufficient balance in your account to transfer..");
					}
					
					}
				break;
			}
			break;
		}
	}
	}
