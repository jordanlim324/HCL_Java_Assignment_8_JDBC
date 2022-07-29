package com.jcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day8_Q06_PrepStatement {
	/*
	 * 6. Write a program for batch processing using statement and prepared
	 * statement.
	 */
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");

			pstmt = con.prepareCall("insert into employeedb.employee values (?, ?)");

			pstmt.setInt(1, 12);
			pstmt.setString(2, "Cynthia");
			pstmt.addBatch();

			pstmt.setInt(1, 13);
			pstmt.setString(2, "Lance");
			pstmt.addBatch();

			pstmt.setInt(1, 14);
			pstmt.setString(2, "Volkner");
			pstmt.addBatch();

			pstmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
