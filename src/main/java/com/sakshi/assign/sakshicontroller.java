package com.sakshi.assign;

import org.apache.catalina.ssi.SSIExternalResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.example.easynotes.Noteclass;
import com.sakshi.assign.service.sservice;

import javax.validation.Valid;
import java.util.List;


@RestController

public class sakshicontroller 
{
	@Autowired
	private sservice sserv;
	
	//create a new user
	@PostMapping(value="/user")
	public Stype createUser(@RequestBody Stype usr) 
	{
	    return sserv.createUser(usr);
	}
	
	//Update a user
	@PutMapping("/user/{id}")
	public ResponseEntity<Stype> updateUser(@PathVariable(value = "id") Integer id1, 
	                                       @Valid @RequestBody Stype details) 
	{
	    return sserv.updateUser(id1, details);
	}
	
	@GetMapping("/employees/{mgrid}")
	public List<Stype> getAllEmployeesBymgrid(@PathVariable int mgrid)
	{
		System.out.println("cmc");
		return sserv.getAllEmployeesBymgrid(mgrid);
	}
	
	@GetMapping("/managers/{uid}")
	public List<Stype> getManagersbyid(@PathVariable Integer uid)
	{
		return sserv.getManagersbyid(uid);
	}
	
	@GetMapping("/email/{str}")
	public List<Stype> getemails(@PathVariable String str) 
	{
		return sserv.getemails(str);
	}
}