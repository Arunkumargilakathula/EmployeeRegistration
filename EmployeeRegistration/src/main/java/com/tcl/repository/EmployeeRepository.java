package com.tcl.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.entity.EmployeeDetails;


@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeDetails, Integer>{

	
	
    
}
