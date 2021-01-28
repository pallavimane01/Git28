package com.csi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "empid")
	private int empId;

	@Column(name = "empname")
	private String empName;

	@Column(name = "empsalary")
	private double empSalary;

	@Column(name = "empcontactnumber", unique = true)
	private long empContactNumber;

	@Column(name = "empuid", unique = true)
	private long empUID;

	@Column(name = "empdob")
	private Date empDOB;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public long getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	public long getEmpUID() {
		return empUID;
	}

	public void setEmpUID(long empUID) {
		this.empUID = empUID;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

}
