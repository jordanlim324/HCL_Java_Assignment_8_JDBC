package com.jcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Day8_Q02_PreparedStatement {
	/*
	 * 1. Write a program for prepared statement for doing below operations Insert Select Update
	 */
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");

			// Insert
			pstmt = conn.prepareStatement("insert into employeedb.employee values (?,?)");

			pstmt.setInt(1, 6);
			pstmt.setString(2, "Jonathan");

			// Select
			pstmt = conn.prepareStatement("select * from employee");

			// Update
			int count = pstmt.executeUpdate();

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
