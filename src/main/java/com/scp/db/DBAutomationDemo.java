package com.scp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBAutomationDemo {
	
	public static void main(String[] args) throws Exception {
		
		//Download DB Drivers db jar and place that inside projects classpath
		
		
		//Load the drivers
		Class.forName("org.hsqldb.jdbcDriver");
		//Create the connection  -- Ack with DB
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		//create statement -- Communication Channel
		Statement statement = connection.createStatement();
		//execute the query
		
		statement.executeUpdate("update employeeinfo set empname='John' where empid=11");
		
		ResultSet resultSet = statement.executeQuery("select * from employeeinfo");
		//iterate the loop
		
		List<Emp> listOfEmps = new ArrayList<Emp>();
		Emp emp = null;
		while(resultSet.next()){
			emp = new Emp();
			emp.setEmpId(resultSet.getInt("EMPID"));
			emp.setEmpName(resultSet.getString("EMPNAME"));
			emp.setSalary(resultSet.getInt("EMPSAL"));
			listOfEmps.add(emp);
		}

		System.out.println("Employee Information -- "+listOfEmps);
		
		
	}

}


class Emp{
     int empId;
     String empName;
     int salary;
     
	@Override
	public String toString() {
		return "\nEmp [empId=" + empId + ", empName=" + empName + ", salary="
				+ salary + "]";
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
     
     
     
}












