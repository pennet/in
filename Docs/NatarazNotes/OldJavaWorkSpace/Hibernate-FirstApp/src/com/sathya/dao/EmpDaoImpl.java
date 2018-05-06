package com.sathya.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.sathya.entity.Employee;
import com.sathya.util.HibernateUtil;
public class EmpDaoImpl implements EmpDao 
{
	private   SessionFactory    factory;
	public EmpDaoImpl() 
	{
		factory = HibernateUtil.getSessionFactory();
	}

	public List readEmps(int startIndex) 
	{
		Session     session = factory.openSession();
		Criteria    crit=session.createCriteria(Employee.class);
		crit.setFirstResult(startIndex);
		crit.setMaxResults(3);
		List    list = crit.list();
		session.close();
		return list;
	}

	public Long noOfRows() 
	{
		Session     session=factory.openSession();
		Criteria   crit= session.createCriteria(Employee.class);
		Projection   p1=Projections.rowCount();
		crit.setProjection(p1);
		List    list =  crit.list();
		Long   l =(Long)list.get(0);
		session.close();
		return  l;
	}
}
