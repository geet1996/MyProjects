package com.sakshi.assign.service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.event.ListDataEvent;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sakshi.assign.Stype;
import com.sakshi.assign.repository.srepository;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

	
@Service

public class sservice 
{
	@Autowired
	private srepository srepo;
	
	@PersistenceContext
	EntityManager entityManager;
	public Stype createUser(Stype usr) 
	{
	    return srepo.save(usr);
	}
	
	
	public ResponseEntity<Stype> updateUser(Integer id1,Stype details)
	{
		Stype usr = srepo.findOne(id1);
		if(usr == null) 
		{
			return ResponseEntity.notFound().build();
		}
	usr.setEmail(details.getEmail());
	usr.setName(details.getName());
	usr.setMgrid(details.getMgrid());
	Stype updateUser = srepo.save(usr);
	return ResponseEntity.ok(updateUser);
	}
	
	@Autowired
	sDao dao;
	public List<Stype>getAllEmployeesBymgrid(int mid)		//dao mein employeesbyid
	{
		int uid; //User u = new user();
		List<Stype> resultlist = new ArrayList<Stype>();
		List<Stype> employ = new ArrayList<Stype>();
		employ.addAll(dao.employeesbyid(mid));
		while(!employ.isEmpty())
		{
			uid=employ.get(0).getId();
			resultlist.add(employ.get(0));
			employ.remove(0);
			employ.addAll(dao.employeesbyid(uid));
		}
		return resultlist;
	}
	
	public List<Stype> getManagersbyid(int uid)
	{
		int mid;
		List<Stype> result = new ArrayList<Stype>();
		Stype str;
		str = dao.mgrbyid(uid);
		while(str.getMgrid() !=null)
		{
			str=dao.mgrbyid(str.getMgrid());
			result.add(str);
		}
		return result;
	}
	
	public List<Stype> getemails(String str) 
	{
		List<Stype> result = new ArrayList<Stype>();
		result=dao.prefix(str);		
		return result;
	}
}