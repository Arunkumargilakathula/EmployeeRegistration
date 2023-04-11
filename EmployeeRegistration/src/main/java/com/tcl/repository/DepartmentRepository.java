package com.tcl.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.entity.DepartmentDetails;

@Repository
public interface DepartmentRepository  extends JpaRepository<DepartmentDetails, Integer>{
     
}
