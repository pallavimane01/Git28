package com.csi.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public List<Employee> showEmployees() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();

	}

	@Override
	public void updateEmployee(int empId, String empName, double empSalary, long empContactNumber, long empUID,
			Date empDOB) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				e.setEmpName(empName);
				e.setEmpSalary(empSalary);
				e.setEmpContactNumber(empContactNumber);
				e.setEmpUID(empUID);
				e.setEmpDOB(empDOB);
				session.update(e);
				transaction.commit();
			}
		}

	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				
				session.delete(e);
				transaction.commit();
			}
		}

	}

}
