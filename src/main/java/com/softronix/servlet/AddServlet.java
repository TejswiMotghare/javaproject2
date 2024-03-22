package com.softronix.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronix.bean.Employee;
import com.softronix.dao.EmployeeDao;
import com.softronix.dao.EmployeeDaoImp;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try 
		{
			int eid =Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			float esal =Float.parseFloat(request.getParameter("esal"));
			String eaddr = request.getParameter("eaddr");
			
			Employee emp = new Employee();
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setEsal(esal);
			emp.setEaddr(eaddr);
			
			EmployeeDao empDao = new EmployeeDaoImp();
			String status= empDao.add(emp);
			if(status.equals("Existed"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/existed.html");
				rd.forward(request, response);
			}
			if(status.equals("Success"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/success.html");
				rd.forward(request, response);
			}
			if(status.equals("Failure"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

}
}
