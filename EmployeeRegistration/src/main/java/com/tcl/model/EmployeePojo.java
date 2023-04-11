package com.tcl.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePojo {
	
	private int empId;
	private String name;
	private int age;
	private String companyName;
	private int salary;
    private DepartmentPojo department;
	
	

}
