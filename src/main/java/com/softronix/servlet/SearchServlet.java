package com.softronix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronix.bean.Employee;
import com.softronix.dao.EmployeeDao;
import com.softronix.dao.EmployeeDaoImp;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			EmployeeDao empDao = new EmployeeDaoImp();
			Employee emp = empDao.search(eid);
			String status = "";
			if(emp == null)
			{
				status = "Not Existed";
			}
			else
			{
//				out.println("<html>");
//				out.println("<body>");
//				out.println("<center>");
//				out.println("<font color='red' size='2'>");
//				
//				
//				
//				out.println("<h1>****Employee Details****</h1>");
//				out.println("<h2>Employee ID       : "+emp.getEid()  +"</h2>");
//				out.println("<h2>Employee Name     : "+emp.getEname()+"</h2>");
//				out.println("<h2>Employee Salary   : "+emp.getEsal() +"</h2>");
//				out.println("<h2>Employee Address  : "+emp.getEaddr()+"</h2>");
//				
				
				
				//2nd method
				out.println("<html>");
				out.println("<body>");
				out.println("<center>");
				out.println("<table align ='center'>");
				out.println("<tr><td><h2>Employee Deatils</h2></td></tr>");
				out.println("<hr>");
				out.println("<tr><td>Employee ID      :</td><td>"+emp.getEid()+"</td></tr>");
				out.println("<tr><td>Employee Name    :</td><td>"+emp.getEname()+"</td></tr>");
				out.println("<tr><td>Employee Salary  :</td><td>"+emp.getEsal()+"</td></tr>");
				out.println("<tr><td>Employee Address :</td><td>"+emp.getEaddr()+"</td></tr>");
				out.println("<hr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
			if(status.equals("Not Existed"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/notexisted.html");
				rd.forward(request, response);
			}
			
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}


