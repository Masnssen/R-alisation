package modele;

import java.sql.DriverManager;

import javax.swing.*;
import java.sql.*;

public class ConnexionMySQL {
	
	Connection cnx = null ;
	static String url ="jdbc:mysql://localhost:3306/projet?useTimezone=true&serverTimezone=UTC";
	//static String url ="jdbc:mysql://localhost:3306/projet";
	static String usename ="root";
	static String password = "syphax";
	
	public static Connection connectDB() {
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cnx =DriverManager.getConnection(url,usename,password);
		
				return cnx;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showConfirmDialog(null, e);
		
				return null;
				
			}
			
	}

}
