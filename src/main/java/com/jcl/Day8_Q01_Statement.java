package com.jcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day8_Q01_Statement {
	/*
	 * 1. Write a program for statement for doing below operations Insert Select Update
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");

			// Insert

			int count = stmt.executeUpdate("insert into employeedb.employee values (" + 5 + ", " + "Jane" + ")");
			System.out.println(count);

			// Select
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println(rs.getInt("empID") + " " + rs.getString("empFName"));
			}

			// Update
			int count1 = stmt.executeUpdate("update employeedb.employee set employeeFname = 'Jacob' where id = 1");
			System.out.println(count1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
