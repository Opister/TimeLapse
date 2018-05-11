package data.sql;
import java.sql.*;

public class DataBaseController {
	
	public static void DBTest() {
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_input?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
