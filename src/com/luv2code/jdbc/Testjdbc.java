package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl ="jdbc:mysql://localhost:3306/hb-project-emp-relation?useSSL=false&serverTimeZone=UTC";
		String user ="hbemp";
		String password ="hbemp";
		
		try {
			
			System.out.println("Connecting to database : "+jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Succesfull for "+myConnection);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
