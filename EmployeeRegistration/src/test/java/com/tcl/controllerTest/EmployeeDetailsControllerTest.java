package com.tcl.controllerTest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tcl.controller.EmployeeController;
import com.tcl.entity.DepartmentDetails;
import com.tcl.entity.EmployeeDetails;
import com.tcl.model.DepartmentPojo;
import com.tcl.model.EmployeePojo;
import com.tcl.service.EmployeeService;



@ExtendWith(SpringExtension.class)
public class EmployeeDetailsControllerTest {

	
	
	
	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	EmployeeController employeeContoller;
	
	
	@Test
	public void create_test() {
		DepartmentPojo DepartmentRecord=new  DepartmentPojo(2,"TATA-DEP",508239);
		EmployeePojo employeeRecord = new EmployeePojo(1,"danush",23,"TCL",50000,DepartmentRecord);
		Mockito.when(employeeService.saveEmployeeDetails(employeeRecord)).thenReturn(employeeRecord);
		assertEquals(new ResponseEntity<>(employeeRecord, HttpStatus.CREATED), employeeContoller.createEmployeeDetails(employeeRecord));
	}

	
	@Test
	public void update_Test() {
		DepartmentPojo DepartmentRecord=new  DepartmentPojo(2,"TATA-DEP",508239);
		EmployeePojo employeeRecord = new EmployeePojo(1,"danush",23,"TCL",50000,DepartmentRecord);
		
		Mockito.when(employeeService.updateDetails(1,employeeRecord)).thenReturn(getEmployee());
				
		employeeContoller.updateEmployee(2, new EmployeePojo(1,"Arun",23,"capgemini",28000,new DepartmentPojo(2, "CAP_DEP", 20554)));
	}


	@Test
	private EmployeeDetails getEmployee() {

		return new EmployeeDetails(1, "arun", 28, "pss", 20, new DepartmentDetails(2, "pss", 2));
	}
	
	@Test
	public void deleteEmployeDetailsByIdTest() {
		
		DepartmentDetails DepartmentRecord=new  DepartmentDetails(3,"TATA-DEP",608239);
		EmployeeDetails employeeRecord = new EmployeeDetails(1,"varun",23,"CAPGemini",60000,DepartmentRecord);
		
		when(employeeService.getById(1)).thenReturn(employeeRecord);
		ResponseEntity<EmployeePojo> res = employeeContoller.deleteDetailsById(1);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		
		
		
		
	}


	
	

	
	
	
	
}
