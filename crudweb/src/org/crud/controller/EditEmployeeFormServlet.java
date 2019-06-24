package org.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crud.dao.EmployeeDao;
import org.crud.model.Employee;

@WebServlet("/EditEmployeeFormServlet")
public class EditEmployeeFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);

		Employee emp = EmployeeDao.getEmployeeById(id);

		out.println("Edit Employee Form");
		
		out.println("<form method='post' action='EditEmployeeServlet' >");
		out.println("<input type='hidden' name='id' value='" + emp.getId() + "' />");
		out.println("<input type='text' name='name' value='" + emp.getName() + "' />");
		out.println("<input type='text' name='password' value='" + emp.getPassword() + "' />");
		out.println("<input type='text' name='email' value='" + emp.getEmail() + "' />");

		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		
		out.println("<input type='submit' value='Edit & Save'/>");
		
		out.println("</form>");

		
		out.close();
	}

}
