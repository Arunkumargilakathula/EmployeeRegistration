package com.tcl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EmployeeDetailsTable")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private int age;
	@Column(nullable = false)
    private String companyName;
	@Column(nullable = false)
    private int salary;
	
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_emp_Id")
    private DepartmentDetails department;

	

	

	

	

	
    
}
