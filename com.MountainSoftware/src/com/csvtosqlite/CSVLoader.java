
package com.csvtosqlite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.util.StringUtils;

public class CSVLoader {

	private static String JDBC_CONNECTION_URL =
			"jdbc:sqlite:test.db";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String csvFile = "/CSVToDatabase/Employee.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        boolean HeadRowExists = true;
	        int AcceptedNumberofColumns = 8;
	        int IncorrectRecords = 0;
	        String[] employee = null;
	      //Create List for holding Employee objects
            List<Employee> EmpList = new ArrayList<Employee>();

	        try {
				br = new BufferedReader(new FileReader(csvFile));


	            if(HeadRowExists) {
	            	String HeadRow = br.readLine();

	            	if(HeadRow==null || HeadRow.isEmpty()) {
	            		throw new FileNotFoundException(
	        					"No columns defined in given CSV file." +
	        					"Please check the CSV file format.");
	            	}
	            }

				 while ((line = br.readLine()) != null) {

		                // use comma as separator
		                employee = line.split(cvsSplitBy);

		                if(employee.length > 0 && employee.length == AcceptedNumberofColumns)
		                {
		                    //Save the employee details in Employee object
		                    Employee emp = new Employee(Integer.parseInt(employee[0]),
		                    		employee[1],employee[2],employee[3],
		                            Integer.parseInt(employee[4]),Integer.parseInt(employee[5]),employee[6],employee[7]);
		                    EmpList.add(emp);
		                }
		                else {

		                	IncorrectRecords++;
		                }
				 }

	                LoadCSVintoDatabase(StuList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



	        System.out.println("Following are the statistics :\n#"+
	        		employee.length+" of records received.\n#"+
	        		EmpList.size()+" of records processed.\n#"+
	        		IncorrectRecords+" of records failed.");
	}

	private static void LoadCSVintoDatabase(List<Employee> empList) {
		// TODO Auto-generated method stub

		Connection connection = null;
		boolean tableExists = true;
		boolean truncateTable = true;

		try {
			//Class.forName("org.sqlite.JDBC");

			connection = DriverManager.getConnection(JDBC_CONNECTION_URL);

			if(tableExists != true) {
				connection.createStatement().execute("create table employee(employeeId, firstname, lastname, address, age, salary, phone, country)");
			}

			if(truncateTable == true) {
				connection.createStatement().execute("delete from employee");
			}


			PreparedStatement stmt =
					connection.prepareStatement("insert into employee (employeeId, firstname, lastname, address, age, salary, phone, country) values (?, ?, ?, ?, ?, ?, ?, ?)");

			for(Employee e : empList)
            {

				stmt.setInt(1, e.getEmployeeId());
				stmt.setString(2, e.getFirstname());
				stmt.setString(3, e.getLastname());
				stmt.setString(4, e.getAddress());
				stmt.setInt(5, e.getAge());
				stmt.setInt(6, e.getSalary());
				stmt.setString(7, e.getPhone());
				stmt.setString(8, e.getCountry());

				stmt.executeUpdate();
            }

			System.out.println("Result of SELECT\n");

			ResultSet rs = connection.createStatement().executeQuery("select * from employee");

			while(rs.next()) {
				int employeeId = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String address = rs.getString(4);
				int age = rs.getInt(5);
				int salary = rs.getInt(6);
				String phone = rs.getString(7);
				String country = rs.getString(8);

				System.out.println(employeeId+"\t"+firstname+"\t"+lastname+"\t"+address+"\t"+age+"\t"
				+salary+"\t"+phone+"\t"+country);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

}
