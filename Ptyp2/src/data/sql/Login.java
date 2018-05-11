package data.sql;
import java.sql.*;

public class Login {
	
	public static boolean checkID(String id) {
		try {
			Connection con = DataBaseController.getConnection();
			String sql = "SELECT 1 FROM time_input.employee WHERE ID = " + id;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
			
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		return false;
	}
	public static String userLogin(String id, String password) {
		if(Login.checkID(id)) {
			try {
			String sql = "SELECT * FROM time_input.employee WHERE Passwort = '"+ password +"' AND ID = " + id;
			Connection con = DataBaseController.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			System.out.println("Login_erfolgreich");
			return id;
			}
			
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		System.out.println("Login_fehgeschlagen");
		return null;
	}
}
