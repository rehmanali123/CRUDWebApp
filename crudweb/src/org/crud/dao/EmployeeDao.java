package org.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.crud.model.Employee;

public class EmployeeDao {

	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/medicalstore";

	private static PreparedStatement statement = null;

	// connection to database
	public static Connection getDatabaseConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// save employee
	public static int saveEmployee(Employee employee) throws SQLException {

		con = getDatabaseConnection();
		int status = 0;

		String sql = "insert into user905(name,pass,email,country) values(?,?,?,?)";
		statement = con.prepareStatement(sql);

		statement.setString(1, employee.getName());
		statement.setString(2, employee.getPassword());
		statement.setString(3, employee.getEmail());
		statement.setString(4, employee.getCountry());

		status = statement.executeUpdate();
		con.close();

		return status;
	}

	// Edit the employee
	public static int updateEmployee(Employee e){  
        int status=0;  
        try{  
            con= getDatabaseConnection();
            PreparedStatement ps=con.prepareStatement(  
                         "update user905 set name=?,pass=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  

	// Delete the employee
	public static int deleteEmployee(int id) throws SQLException {

		int status = 0;
		con = getDatabaseConnection();
		String sql = "delete from user905 where id=?";
		statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		status = statement.executeUpdate();
		con.close();

		return status;
	}

	// Get specific employee
	public static Employee getEmployeeById(int id) {
		Employee e = new Employee();

		try {
			con = getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	// View the list of the employees
	public static List<Employee> listOfEmployees() throws SQLException {

		List<Employee> list = new ArrayList<Employee>();

		con = getDatabaseConnection();
		statement = con.prepareStatement("SELECT * FROM user905");
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			Employee emp = new Employee();
			emp.setId(result.getInt(1));
			emp.setName(result.getString(2));
			emp.setPassword(result.getString(3));
			emp.setEmail(result.getString(4));
			emp.setCountry(result.getString(5));

			list.add(emp);

		}

		return list;
	}

}
