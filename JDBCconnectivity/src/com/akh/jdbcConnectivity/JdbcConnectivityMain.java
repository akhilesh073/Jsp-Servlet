package com.akh.jdbcConnectivity;

import java.sql.*;

public class JdbcConnectivityMain {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba", "akhilesh");
			Statement stmt = connection.createStatement();
			System.out.println("Connection created :)");
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
