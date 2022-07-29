package com.jcl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Day8_Q03 {
	/*
	 * 3. Write a program for calling a procedure.
	 */
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");

			CallableStatement cstmt = conn.prepareCall("{call empprocedure(?,?)}");
			cstmt.setInt(1, 7);
			cstmt.setString(2, "Kaity");

			cstmt.execute();

			System.out.println("Success...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
