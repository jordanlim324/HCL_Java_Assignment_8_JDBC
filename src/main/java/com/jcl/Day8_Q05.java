package com.jcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Day8_Q05 {
	/*
	 * 5. Write a program for transaction management.
	 */
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");

			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("insert into employeedb.employee values (?, ?)");

			pstmt.setInt(1, 7);
			pstmt.setString(2, "Jimmy");

			System.out.println(pstmt.executeUpdate());

			pstmt = conn.prepareStatement("insert into employeedb.file_table values (?, ?)");

			pstmt.setInt(1, 8);
			pstmt.setString(2, "Angel");

			System.out.println(pstmt.executeUpdate());

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
