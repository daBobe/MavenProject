package tn.iit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
public static Connection getConnection() {
	Connection ctx = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		ctx = DriverManager.getConnection("jdbc:mysql://"
				+ "localhost:3306/gestauth", "root", "");
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ctx;
}
}
