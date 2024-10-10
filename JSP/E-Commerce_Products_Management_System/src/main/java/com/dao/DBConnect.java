package com.dao;

import java.sql.*;

public class DBConnect {
		
		public static Connection con;
		
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public static Connection connect() throws Exception {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS_Project","root","shantanu");
			System.out.println("con succes");
			return con;
		}
}

