package com.oops.penchal;

class Bank{
	int interestRate(){
		return 0;
		
	}
}
class SBI extends Bank{
	int interestRate(){
		return 5;
		
	}
}
class ICICI extends Bank{
	int interestRate(){
		return 50;
		
	}
}

class HDFC extends Bank{
	int interestRate(){
		return 59;
		
	}
}

public class OverridetTest {
public static void main(String[] args) {
	SBI s=new SBI();
	ICICI i=new ICICI();
	HDFC h=new HDFC();
	System.out.println(s.interestRate());
	System.out.println(i.interestRate());
	System.out.println(h.interestRate());
}
}
