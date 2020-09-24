package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
	//load the driver class
		Class.forName("oracle.jdbc.OracleDriver");
	//establishing the connection
		Connection conn=null;
	    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1129ku");
		
	    if(conn!=null) {
	    	System.out.println("connection established");
	    }
	    return conn;
	}
}


