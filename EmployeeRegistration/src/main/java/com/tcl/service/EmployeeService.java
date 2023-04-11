package com.tcl.service;


import com.tcl.entity.EmployeeDetails;

import com.tcl.model.EmployeePojo;

public interface EmployeeService {

	EmployeePojo saveEmployeeDetails(EmployeePojo emp);

	EmployeeDetails updateDetails(int empId, EmployeePojo emp);

	EmployeeDetails getById(int empId);

	void deleteEmployee(EmployeeDetails Details);
	

}
