package com.tcl.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.customeException.ExceptionalHandler;
import com.tcl.entity.DepartmentDetails;
import com.tcl.entity.EmployeeDetails;
import com.tcl.model.DepartmentPojo;
import com.tcl.model.EmployeePojo;
import com.tcl.repository.EmployeeRepository;
import com.tcl.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	// save EmployeeDetails Method

	@Override
	public EmployeePojo saveEmployeeDetails(EmployeePojo emp) {
		log.info("Adding Employee Details.....");

		DepartmentDetails departmentDetails = new DepartmentDetails(emp.getDepartment().getDeparmentId(),
				emp.getDepartment().getDepartemtName(), emp.getDepartment().getDeparmentCode());
		EmployeeDetails employeeDetails = new EmployeeDetails(emp.getEmpId(), emp.getName(), emp.getAge(),
				emp.getCompanyName(), emp.getSalary(), departmentDetails);
		EmployeeDetails empDetails = employeeRepository.save(employeeDetails);

		DepartmentPojo departmentPojo = new DepartmentPojo();
		BeanUtils.copyProperties(departmentDetails, departmentPojo);

		EmployeePojo empPojo = new EmployeePojo();
		BeanUtils.copyProperties(empDetails, empPojo);
		empPojo.setDepartment(departmentPojo);

		log.info("EmployeeDetails ADDED_SUCESSFULLY.......");
		return empPojo;

	}

	// update EmployeeDetails

	@Override
	public EmployeeDetails updateDetails(int empId, EmployeePojo emp) {
		log.info("update the Details based on  empId:{}", empId);
		EmployeeDetails employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ExceptionalHandler(empId + " ID is Not Available", "404_ERROR :ID_NOT_FOUND"));
		if (employee != null) {
			employee.setEmpId(empId);
			employee.setCompanyName(emp.getCompanyName());
			employee.setAge(emp.getAge());
			employee.setName(emp.getName());
			employee.setSalary(emp.getSalary());
			employee.getDepartment().setDeparmentCode(emp.getDepartment().getDeparmentCode());
			employee.getDepartment().setDepartemtName(emp.getDepartment().getDepartemtName());
		}

		log.info("EmployeeDEtails UPDATED_SUCESSFULLY..........");

		return employeeRepository.save(employee);

	}

	// fetching EmployeeDetails

	@Override
	public EmployeeDetails getById(int empId) {
		log.info("Getting EmployeeDetails based on  empId:{}", empId);
		return employeeRepository.findById(empId).get();

	}

	// Delete EmployeeDetails

	@Override
	public void deleteEmployee(EmployeeDetails Details) {
		log.info("DELETING EmployeeDetails .........");
		employeeRepository.delete(Details);
		log.info("deleting EmployeeDetails DELETED_SUCESSFULLY.......");

	}

}
