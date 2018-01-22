package com.sakshi.assign;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stable")


public class Stype 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	public Stype() 
	{
		
	}
	public Stype(int id, String name, String email, Integer mgrid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mgrid = mgrid;
	}

	private String email;

	private Integer mgrid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMgrid() {
		return mgrid;
	}

	public void setMgrid(Integer mgrid) {
		this.mgrid = mgrid;
	}

}
