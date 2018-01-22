package com.sakshi.assign.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sakshi.assign.Stype;

import antlr.collections.List;

public interface srepository extends JpaRepository<Stype,Integer>
{
	
}
