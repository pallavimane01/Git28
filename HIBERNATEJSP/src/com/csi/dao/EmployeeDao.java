package com.csi.dao;

import java.util.Date;
import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {

	public List<Employee> showEmployees();

	public void saveEmployee(Employee employee);

	public void updateEmployee(int empId, String empName, double empSlary,long empContactNumber,long empUID,Date empDOB);

	public void deleteEmployee(int empId);
}
