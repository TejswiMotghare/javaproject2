package com.softronix.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.softronix.bean.Employee;


public class EmployeeDaoImp implements EmployeeDao {

	Connection con = null;
	Statement st;
	ResultSet rs;
	String status="";
	Employee emp=null;
	
	@Override
	public String add(Employee emp) {
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st = con.createStatement();
			
			rs = st.executeQuery("select * from employee where eid = "+emp.getEid()+"");
			boolean b = rs.next();
			if(b == true)
			{
				status = "Existed";
			}
			else
			{
				int rowCount = st.executeUpdate("insert into employee values("+emp.getEid()+",'"+emp.getEname()+"',"+emp.getEsal()+",'"+emp.getEaddr()+"')");
				if(rowCount == 1)
				{
					status = "Success";
				}
				else
				{
					status = "Failure";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

	@Override
	public Employee search(int eid) {
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st = con.createStatement();
			
			rs = st.executeQuery("select * from employee where eid = "+eid+"");
			boolean b = rs.next();
			if(b == true)
			{
				emp = new Employee();
				emp.setEid(rs.getInt("EID"));
				emp.setEname(rs.getString("ENAME"));
				emp.setEsal(rs.getFloat("ESAL"));
				emp.setEaddr(rs.getString("EADDR"));
			}
			else
			{
				emp = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

		

	@Override
	public String update(Employee emp) {
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st = con.createStatement();
			
			int rowCount = st.executeUpdate("update employee set ename = '"+emp.getEname()+"', esal="+emp.getEsal()+", eaddr = '"+emp.getEaddr()+"' where eid = "+emp.getEid()+"");
			if(rowCount == 1)
			{
				status = "Success";
			}
			else
			{
				status = "Failure";
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
		
	@Override
	public String delete(int eid) {
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			st = con.createStatement();
			
			int rowCount = st.executeUpdate("delete from employee where eid = "+eid+"");
			if(rowCount == 1)
			{
				status = "Success";
			}
			else
			{
				status = "Failure";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
