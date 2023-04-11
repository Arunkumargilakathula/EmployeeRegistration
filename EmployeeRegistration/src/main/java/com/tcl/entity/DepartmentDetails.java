package com.tcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deparmentId;
	@Column(nullable = false)
	private String departemtName;
	@Column(nullable = false)
	private int deparmentCode;
	

}
