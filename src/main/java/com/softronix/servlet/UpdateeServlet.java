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


@WebServlet("/update")
public class UpdateeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try 
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			int eid = Integer.parseInt(request.getParameter("eid"));
			
			EmployeeDao empDao = new EmployeeDaoImp();
			Employee emp = empDao.search(eid);
			if(emp == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/notexisted.html");
				rd.forward(request, response);
			}
			else
			{
//				out.println("<html>");
//				out.println("<body>");
//				out.println("<form method = 'post' action='./edit'>");
//				out.println("<center>");
//				out.println("<tr><td><h2>Employee Deatils</h2></td></tr>");
//				out.println("<hr>");
//				out.println("<table align='center'>");
//				out.print("<tr>");
//				out.print("<td><b>Employee Id   : </b></td>");
//				out.print("<td><b><font color='red'>"+emp.getEid()+"</font></b></td>");
//				out.print("</tr>");
//				
//				
//				out.print("<tr>");
//				out.print("<td><b>Employee Name  : </b></td><td> Old Name: <td><td><font color='red'>"+emp.getEname()+"</td>");
//				out.print("<td>New Name: </td>");
//				out.print("<td><input type='text' name='ename' placeholder='Enter New Name'></td>");
//				out.print("</tr>");
//				
//				out.println("<br>");
//				out.print("<tr>");
//				out.print("<td><b>Employee Salary  : </b></td><td>Old Salary: <td><td><font color='red'>"+emp.getEsal()+"</font></td>");
//				out.print("<td>New Salary: </td>");
//				out.print("<td><input type='text' name='esal' placeholder='Enter New Salary'></td>");
//				out.print("</tr>");
//				out.println("<br>");
//				
//				out.print("<tr>");
//				out.print("<td><b>Employee Address: </b></td><td>Old Name: <td><td><font color='red'>"+emp.getEaddr()+"</font></td>");
//				out.print("<td>New Address: </td>");
//				out.print("<td><input type='text' name='eaddr' placeholder='Enter New Address'></td>");
//				out.print("</tr>");
//				
//				out.println("<tr>");
//				out.println("<td><input type ='Submit' Value='Submit'></td>");
//				out.println("</tr>");
//				out.println("</table>");
//				out.println("</form>");
//				out.println("</body>");
//				out.println("</html>");
				
				
				out.println("<html>");
				out.println("<body style='color :red:' align='center'>");
				out.println("<center>");
				out.println("<form method='post' action='./edit'>");
				out.println("<table align='center'>");
				out.println("<tr><tr><h2>Employee Update Form</h2></td></tr>");
				out.println("<hr>");
				out.println("<tr><td> Employee ID      :</td><td><input type='hidden' name='eid' value='"+emp.getEid()+"'></td></tr>");
				out.println("<tr><td> Employee Name    :</td><td><input type='text' name='ename' value='"+emp.getEname()+"'></td></tr>");
				out.println("<tr><td> Employee Salary  :</td><td><input type='text' name='esal' value='"+emp.getEsal()+"'></td></tr>");
				out.println("<tr><td> Employee Address :</td><td><input type='text' name='eaddr' value='"+emp.getEaddr()+"'></td></tr>");
				out.println("<tr><td><input type='submit' name='eaddr' value='Update'></td></tr>");
				out.println("</hr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				
				} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	}


