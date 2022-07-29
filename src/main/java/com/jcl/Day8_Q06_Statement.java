package com.jcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Day8_Q06_Statement {
	/*
	 * 6. Write a program for batch processing using statement and prepared statement.
	 */
	public static void main(String[] args) {
		Connection connS = null;
		Statement stmt = null;
		try {
			connS = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");
			stmt = connS.createStatement();

			stmt.addBatch("insert into training.employee values (9, 'Alexis')");
			stmt.addBatch("insert into training.employee values (10, 'Nihad')");
			stmt.addBatch("insert into training.employee values (11, 'Charlie')");

			stmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connS.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
