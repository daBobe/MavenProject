package tn.iit.glid23.auth.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Test {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection ctx = DriverManager.getConnection("jdbc:mysql://"
					+ "localhost:3306/gestauth", "root", "");
			PreparedStatement pstmt = ctx.prepareStatement(""
					+ "insert into utilisateur values (0,?,?,?,?,?)");
			pstmt.setString(1, "Jemal");
			pstmt.setString(2, "Ahmed");
			pstmt.setString(3, "Ahmad@emqil.com");
			pstmt.setString(4, "ADMINISTRQTEUR");
			pstmt.setString(5, "123");
			pstmt.executeUpdate();
			pstmt.close();
			ctx.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
