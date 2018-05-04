package Assignments.BankApp;

public class Customer extends BankUtilities{
	
	BankUtilities bu = new BankUtilities();
	int max_limit = bu.getMax_limit();
	static int totRec=0;
	
	private long []accountNo = new long[max_limit];
	private long []customerID = new long[max_limit];
	private String []customerName = new String[max_limit];
	private String []address = new String[max_limit];
	private double []balance = new double[max_limit];
	private long []mobileNo = new long[max_limit];
	private String []emailID = new String[max_limit];
	private long []username = new long[max_limit];
	private String []password = new String[max_limit];
	private  String []accType = new String[max_limit];
	
	public String getAccType(int index) {
		return accType[index];
	}
	public void setAccType(int index, String accType) {
		this.accType[index] = accType;
	}
	public long getAccountNo(int index) {
		return accountNo[index];
	}
	public void setAccountNo(int index, long accountNo) {
		this.accountNo[index] = accountNo;
	}
	public long getCustomerID(int index) {
		return customerID[index];
	}
	public void setCustomerID(int index, long customerID) {
		this.customerID[index] = customerID;
	}
	public String getCustomerName(int index) {
		return customerName[index];
	}
	public void setCustomerName(int index, String customerName) {
		this.customerName[index] = customerName;
	}
	public String getAddress(int index) {
		return address[index];
	}
	public void setAddress(int index, String address) {
		this.address[index] = address;
	}
	public double getBalance(int index) {
		return balance[index];
	}
	public void setBalance(int index, double balance) {
		this.balance[index] = balance;
	}
	public long getMobileNo(int index) {
		return mobileNo[index];
	}
	public void setMobileNo(int index, long mobileNo) {
		this.mobileNo[index] = mobileNo;
	}
	public String getEmailID(int index) {
		return emailID[index];
	}
	public void setEmailID(int index, String emailID) {
		this.emailID[index] = emailID;
	}
	public long getUsername(int index) {
		return username[index];
	}
	public void setUsername(int index, long username) {
		this.username[index] = username;
	}
	public String getPassword(int index) {
		return password[index];
	}
	public void setPassword(int index, String password) {
		this.password[index] = password;
	}
	
}
