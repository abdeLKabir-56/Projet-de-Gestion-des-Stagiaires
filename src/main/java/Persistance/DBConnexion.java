package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnexion {
	Connection conn=null;
	public Connection getconnexion()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_login", "root", "abc123abc");
            System.out.println("connected succefully");
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return conn;
		
	}
}
