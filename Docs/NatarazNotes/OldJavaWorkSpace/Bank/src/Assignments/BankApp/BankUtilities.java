package Assignments.BankApp;

public class BankUtilities {
	
	private int max_limit=20;
    final  int min_limit=1;
    private double min_bal=500;
    
	private String []branchName = new String[max_limit];
	private String []fsciCode = new String[max_limit];
	private String []bmUserName = new String[max_limit];
	private String []bmPassword = new String[max_limit];
	
	public int getMax_limit() {
		return max_limit;
	}
	public void setMax_limit(int max_limit) {
		this.max_limit = max_limit;
	}
	public double getMin_bal() {
		return min_bal;
	}
	public void setMin_bal(double min_bal){
		this.min_bal = min_bal;
	}
	
	public String getBranchName(int index) {
		return branchName[index];
	}
	public void setBranchName(int index, String branchName) {
		this.branchName[index] = branchName;
	}
	public String getFsciCode(int index) {
		return fsciCode[index];
	}
	public void setFsciCode(int index, String fsciCode) {
		this.fsciCode[index] = fsciCode;
	}
	public String getBmUserName(int index) {
		return bmUserName[index];
	}
	public void setBmUserName(int index, String bmUserName) {
		this.bmUserName[index] = bmUserName;
	}
	public String getBmPassword(int index) {
		return bmPassword[index];
	}
	public void setBmPassword(int index, String bmPassword) {
		this.bmPassword[index] = bmPassword;
	}
}