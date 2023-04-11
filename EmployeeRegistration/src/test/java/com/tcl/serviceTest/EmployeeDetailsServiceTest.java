package com.tcl.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tcl.entity.DepartmentDetails;
import com.tcl.entity.EmployeeDetails;
import com.tcl.model.DepartmentPojo;
import com.tcl.model.EmployeePojo;
import com.tcl.repository.EmployeeRepository;
import com.tcl.serviceImpl.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
public class EmployeeDetailsServiceTest {
	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	public EmployeeServiceImpl employeeService;

	@Test
	@Order(1)
	public void createRecord_success() {

		DepartmentPojo DepartmentRecordPojo = new DepartmentPojo(2, "TATA-DEP", 508239);
		EmployeePojo employeeRecordPojo = new EmployeePojo(1, "danush", 23, "TCL", 50000, DepartmentRecordPojo);

		DepartmentDetails DepartmentRecord = new DepartmentDetails(2, "TATA-DEP", 508239);

		EmployeeDetails employeeRecord = new EmployeeDetails(1, "danush", 23, "TCL", 50000, DepartmentRecord);

		Mockito.when(employeeRepository.save(Mockito.any(EmployeeDetails.class))).thenReturn(employeeRecord);

		EmployeePojo empPojo = employeeService.saveEmployeeDetails(employeeRecordPojo);
		assertEquals(employeeRecordPojo, empPojo);

	}

	@Test
	@Order(3)
	public void deletTest() {
		DepartmentDetails DepartmentRecord = new DepartmentDetails(2, "TATA-DEP", 508239);
		EmployeeDetails employeeRecord = new EmployeeDetails(1, "danush", 23, "TCL", 50000, DepartmentRecord);
		employeeService.deleteEmployee(employeeRecord);
		verify(employeeRepository, times(1)).delete(employeeRecord);
	}

	@Test
	@Order(2)
	public void testUpdateDetails() {
		
		DepartmentPojo DepartmentRecord = new DepartmentPojo(2, "TATA-DEP", 508239);
		
		EmployeePojo employeeRecord = new EmployeePojo(1, "danush", 23, "TCL", 50000, DepartmentRecord);
		
		
		
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(getEmployee());
	    
	    assertEquals(Mockito.any(EmployeeDetails.class), employeeService.updateDetails(1, employeeRecord));
	   
		

	}

	@Test
	private Optional<EmployeeDetails> getEmployee() {

		return Optional.ofNullable(new EmployeeDetails(1, "arun", 28, "pss", 20, new DepartmentDetails(2, "pss", 2)));
	}

}
