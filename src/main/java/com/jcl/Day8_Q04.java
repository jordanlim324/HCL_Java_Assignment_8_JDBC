package com.jcl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Day8_Q04 {
	/*
	 * 4. Write a program for ResultSet metadata and Database metadata.
	 */
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "HCLSQL04*");
			
			DatabaseMetaData dbMData = conn.getMetaData();
			
			System.out.println(dbMData.getDatabaseProductName());
			System.out.println(dbMData.getDatabaseMajorVersion());
			System.out.println(dbMData.getDriverName());
			System.out.println(dbMData.getSchemas());
			

			pstmt = conn.prepareStatement("select * from employee where id = 4");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ResultSetMetaData rsData = rs.getMetaData();
				System.out.println(rsData.getColumnCount());
				System.out.println(rsData.getColumnName(1) + " " + rsData.getColumnTypeName(1));
				System.out.println(rsData.getColumnName(2) + " " + rsData.getColumnTypeName(2));
			}

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
