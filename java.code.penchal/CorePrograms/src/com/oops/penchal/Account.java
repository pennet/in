package com.oops.penchal;

class AccountInformation{
	
	int accno;
	String accName;
	float sal;
	void insert(int a,String n,float s){
		accno=a;
		accName=n;
		sal=s;
	}
	void deposite(float amt){
	sal=sal+amt;
	System.out.println("Deposite : "+sal);
	
		
	}
	void withdraw(float amt){
		if(sal<amt){
			System.out.println("Insufficient ammount");
		}else{
			sal=sal-amt;
			System.out.println("Withdraw ; " + sal);
		}
		
	}
	void checkBalance(){
		System.out.println("Balance :"+ sal);
	}
 void display() {
		System.out.println(accno+"    "+accName+"   "+sal);
		
	}
	
	
}
class Account{
	public static void main(String args[]){
			AccountInformation ai=new AccountInformation();
			ai.insert(101,"Rama", 15000);
			ai.display();
			ai.deposite(10000);
			ai.withdraw(12000);
			ai.checkBalance();
	}
}
