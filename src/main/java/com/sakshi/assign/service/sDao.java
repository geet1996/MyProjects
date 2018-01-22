package com.sakshi.assign.service;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.catalina.LifecycleListener;
import org.hibernate.action.internal.EntityIdentityInsertAction;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers.HSTS;
import org.springframework.stereotype.Repository;

import com.sakshi.assign.Stype;



@Repository
public class sDao
{
	@PersistenceContext
	EntityManager eManager;
	
	public List<Stype> employeesbyid(int mgid)
	{
		String hsString = "FROM Stype as u WHERE u.mgrid=?";
		List<Stype> employees = (List<Stype>)eManager.createQuery(hsString).setParameter(1, mgid).getResultList();
		return employees;
	}
	
	public Stype mgrbyid(int uid) 
	{
		String hString="FROM Stype as u WHERE u.id = ?";
		Stype str=(Stype)eManager.createQuery(hString).setParameter(1, uid).getSingleResult();
		return str;
	}
	
	public List<Stype> prefix(String str) 
	{
		String hString = "FROM Stype as u WHERE u.email LIKE ?";
		List<Stype> ste=(List<Stype>)eManager.createQuery(hString).setParameter(1, str+'%').getResultList();
		return ste;
	}
	
}
