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


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			String status;
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			EmployeeDao empDao = new EmployeeDaoImp();
			
			Employee emp = empDao.search(eid);
			if(emp == null)
			{
				status = "Not Existed";
			}
			else
			{
				status = empDao.delete(eid);
			}
			
			if(status.equals("Not Existed"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/notexisted.html");
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
