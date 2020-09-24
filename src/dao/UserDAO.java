package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import utility.ConnectionManager;
public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) {
		int value;
		ConnectionManager con=new ConnectionManager();
		Connection conn;
		try {
			conn = con.getConnection();
			//use to store data in the database
			String sql="Insert into USER1 (EMAIL,USER_PASSWORD,LOGIN_DATE)values(?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			System.out.println("loading the data in the database");
			stmt.setString(1, user.getEmail());
			stmt.setString(2,user.getPassword());
			stmt.setString(3, user.getDate().toString());
			System.out.println("excuting the value");
			value=stmt.executeUpdate();
			System.out.println("value returning"+value);
			return value;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
}

	@Override
	public boolean loginUser(User user) {
		
		//checks whether user exist in database
		
		ConnectionManager conn=new ConnectionManager();
		Connection con;
		try {
			con = conn.getConnection();
			String sql="select email,user_password from USER1 WHERE EMAIL=? AND USER_PASSWORD=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,user.getEmail());
			stmt.setString(2, user.getPassword());
			ResultSet rst=stmt.executeQuery();
			System.out.println("Id\t\tEMAIL\t\tPASSWORD\n");
			while(rst.next()) {
	            if(user.getEmail().equals(rst.getString(1))){
	            	if(user.getPassword().equals(rst.getString(2))) {
	            		System.out.println(true);
	            		return true;
	            	}
	            }
	            else {
	            	System.out.println(false);
	            	return false;
	            }
	         }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}