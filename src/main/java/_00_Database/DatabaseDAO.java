package _00_Database;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import _00_Util.SystemConstant;

public class DatabaseDAO {
	String dbURL = SystemConstant.URL;

	public DatabaseDAO() {
	}
	
	public DatabaseDAO(String url) {
	}
	
	public void setResetTables() {
		String[] dropStr = readSQLFile("dropPlace.sql");
		String[] createStr = readSQLFile("CreateTables.sql");	
		
		try (Connection con = DriverManager.getConnection(dbURL); 
			Statement stmt = con.createStatement();) {
			
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
				//強制刪除FK
			
			
			for(int n =0; n < createStr.length;n++){
			stmt.executeUpdate(dropStr[n]);
			System.out.println("第"+(n+1)+"個Table Drop OK");
			stmt.executeUpdate(createStr[n]);
			System.out.println("第"+(n+1)+"個Table Create OK");
			}
			
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void setCreateTables() {
		
		String[] createStr = readSQLFile("CreateTables.sql");	
		
		try (Connection con = DriverManager.getConnection(dbURL); 
			Statement stmt = con.createStatement();) {
			
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
				
			
			for(int n =0; n < createStr.length;n++){
			stmt.executeUpdate(createStr[n]);
			System.out.println("第"+(n+1)+"個Table Create OK");
			}
			
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private String[] readSQLFile(String filename) {

		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader in = new InputStreamReader(fis, "BIG5");
				BufferedReader br = new BufferedReader(in);) {
			String line = "";
			StringBuffer sb = new StringBuffer();
			// 將放在檔案內的字串合併為一個長字串
			while ((line = br.readLine()) != null) {
				sb.append(line);
			
			}
			String[] CreateStatement = sb.toString().trim().split(";");
			
			for(int n=0;n<CreateStatement.length;n++){
				CreateStatement[n] +=";";
			}
			
			return CreateStatement;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void setInsertUser() {

		String[] insertStr = readSQLFile("InsertUser.sql");

		try (Connection con = DriverManager.getConnection(dbURL); Statement stmt = con.createStatement();) {

		
			for (int n = 0; n < insertStr.length; n++) {

				stmt.executeUpdate(insertStr[n]);
				System.out.println("第" + (n + 1) + "個User Insert OK");

			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
