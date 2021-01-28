package com.csi.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    Employee employee=new Employee();
    EmployeeDao employeeDaoImpl=new EmployeeDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getParameter("addEmployee") != null) {
			String datePattern = "dd-MM-yyyy";

			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			Date dob = null;
			try {
				dob = sdf.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String empName = request.getParameter("empname");
			String empSalary = request.getParameter("empsalary");
			String empContactNumber=request.getParameter("empcontactnumber");
			String empUID=request.getParameter("empuid");
		
			employee.setEmpName(empName);
			employee.setEmpSalary(Double.parseDouble(empSalary));
			employee.setEmpContactNumber(Long.parseLong(empContactNumber));
			employee.setEmpUID(Long.parseLong(empUID));
			employee.setEmpDOB(dob);
			employeeDaoImpl.saveEmployee(employee);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if (request.getParameter("showEmployee") != null) {
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList = employeeDaoImpl.showEmployees();
			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAll.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("updateEmployee") != null) {
			String datePattern = "dd-MM-yyyy";

			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			Date dob = null;
			try {
				dob = sdf.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int empid1 = Integer.parseInt(request.getParameter("empId"));
			String empName = request.getParameter("empName");
			double empSalary = Double.parseDouble(request.getParameter("empSalary"));
			//long empContactNumber=Long.parseLong(request.getParameter("empContactNumber"));
			String cN= request.getParameter("empContactNumber");
			long empContactNumber=Long.valueOf(cN);
			//long empUID=Long.parseLong(request.getParameter("empUId"));
			String str=request.getParameter("empUID");
			long empUID=Long.valueOf(str);
			
			Date empDOB=dob;
			employeeDaoImpl.updateEmployee(empid1, empName, empSalary,empContactNumber,empUID,empDOB);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("deleteEmployee") != null) {
			int empId = Integer.parseInt(request.getParameter("empId"));

			employeeDaoImpl.deleteEmployee(empId);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
			rd.forward(request, response);
		}
	}

}
