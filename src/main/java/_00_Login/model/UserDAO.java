package _00_Login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Blob;

public class UserDAO {

	DataSource ds = null;

	public UserDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Java004NO1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_BY_ID = "Select * from User where userId = ?";

	public UserBean select(String id) {
		UserBean result = null;
		
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		){  
			stmt.setString(1, id);
			
			try(
					ResultSet rset = stmt.executeQuery();
			){
				if (rset.next()) {
					
					result = new UserBean();
					result.setUserId(rset.getString("userId"));
					result.setPassword(rset.getString("password"));
					result.setName(rset.getString("name"));
					result.setGrade(rset.getString("grade"));
				
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

}