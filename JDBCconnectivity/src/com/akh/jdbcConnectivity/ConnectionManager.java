package com.akh.jdbcConnectivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@SuppressWarnings("unused")
public class ConnectionManager {
	public static void main(String[] args) {
		/*
		 * String url="jdbc:oracle:thin:@localhost:1521:xe"; String
		 * user="sys as sysdba"; String pass="akhilesh"; try{
		 * Class.forName("oracle.jdbc.OracleDriver"); Connection
		 * con=DriverManager.getConnection(url,user,pass); Statement
		 * st=con.createStatement(); String query="select * from mem";
		 * System.out.println("connection successfully..."); DatabaseMetaData
		 * dm=con.getMetaData(); String
		 * dbversion=dm.getDatabaseProductVersion(); String
		 * dbname=dm.getDatabaseProductName();
		 * System.out.println("dbversion: "+dbversion);
		 * System.out.println("dbname: "+dbname); ResultSet
		 * rs=st.executeQuery(query); while(rs.next()){
		 * 
		 * System.out.println(); } st.close(); con.close();
		 * 
		 * 
		 * }catch(Exception e){e.printStackTrace();}
		 */
		try {
			Properties prop = new Properties();
			prop.load(new java.io.FileInputStream("db.properties"));
			//prop.loadFromXML(new java.io.FileInputStream("db.xml"));
			String driverClass = prop.getProperty("driverClass");
			String dbName = prop.getProperty("dbName");
			String dbUser = prop.getProperty("dbUser");
			String dbPass = prop.getProperty("dbPass");
			System.out.println("driverClass: " + driverClass + "\n"
					+ "dbName: " + dbName + "\n" + "dbUser: " + dbUser + "\n"
					+ "dbPass: " + dbPass);
			Class.forName(driverClass);
			Connection con = DriverManager
					.getConnection(dbName, dbUser, dbPass);
			Statement st = con.createStatement();
			System.out.println("connection successful........");
			DatabaseMetaData dm = con.getMetaData();
			String productVersion = dm.getDatabaseProductVersion();
			String productName = dm.getDatabaseProductName();
			System.out.println("productVersion: " + productVersion + "\n"
					+ "productName: " + productName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
