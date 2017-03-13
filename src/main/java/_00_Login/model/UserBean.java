package _00_Login.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;   			// 帳號
	private String password;   			// 密碼
	private String name;       			// 姓名
	private String grade;
	
	public UserBean(String userId, String password, String name, String grade) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.grade = grade;
	}
	
	public UserBean(){
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}