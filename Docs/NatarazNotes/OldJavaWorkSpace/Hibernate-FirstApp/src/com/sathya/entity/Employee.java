package com.sathya.entity;

public  class   Employee
{
	private    int         empNo;
	private    String   empName;
	private    int        empSal;
	private    int        deptNumber;
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	public int getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	
	public    String     toString()
	{
		return   "empNo="+empNo+" , empName="+empName+" , empSal="+empSal+" , deptNumber="+deptNumber;
	}
}
