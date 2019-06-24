package org.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crud.dao.EmployeeDao;
import org.crud.model.Employee;

@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("Employee List");
        List<Employee> list = new ArrayList<Employee>();
        
        try {
			list = EmployeeDao.listOfEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("showing the table");
		
		for(Employee emp: list) {
			System.out.println(emp);
		}
		
		
        out.println("<table>");
        out.println("<tr><th>Name</th><th>Password</th><th>Email</th>"
	        		+ "<th>Country</th><th>Edit</th><th>Delete</th><tr>");
		     
        for(Employee emp: list) {
        	
        	out.println("<tr><td>"+emp.getName()+"</td><td>"+emp.getPassword()+"</td>"
        			+ "<td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td>"
        			+ "<td><a href='EditEmployeeFormServlet?id="+emp.getId()+"'>Edit</a></td><td><a href='DeleteEmployeeServlet?id="+emp.getId()+"'>Delete</a></td></tr>");
        	
        }
        
        
        out.println("</table>");
        
        
        out.close();
        
        
		
	}


}
