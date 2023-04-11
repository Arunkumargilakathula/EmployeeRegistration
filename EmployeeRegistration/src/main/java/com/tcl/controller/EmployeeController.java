package com.tcl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcl.entity.EmployeeDetails;
import com.tcl.model.EmployeePojo;
import com.tcl.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	// save method...

	@PostMapping("/saveDetails")
	public ResponseEntity<EmployeePojo> createEmployeeDetails(@Valid @RequestBody EmployeePojo emp) {

		EmployeePojo empdetails = employeeService.saveEmployeeDetails(emp);

		if (empdetails != null) {

			return new ResponseEntity<EmployeePojo>(empdetails, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	// update method...
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable("id") int empId,
			@Valid @RequestBody EmployeePojo emp) {

		EmployeeDetails update = employeeService.updateDetails(empId, emp);
		if (update != null) {

			return new ResponseEntity<EmployeeDetails>(update, HttpStatus.FOUND);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	// Delete method...

	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<EmployeePojo> deleteDetailsById(@PathVariable("id") int empId) {

		EmployeeDetails details = null;
		try {
			details = employeeService.getById(empId);

			employeeService.deleteEmployee(details);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

}
