package com.sathya.dao;

import java.util.List;

public interface EmpDao
{
	List      readEmps(int    startIndex);
	Long    noOfRows();
}

