package _00_Util;

public class SystemConstant {
	public static final int    RECORDS_PER_PAGE = 13;
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String HOST = "1.34.195.4";
    public static final String DB = "Java004NO1";
    public static final String USER = "Java004NO1";
    public static final String PASSWORD = "Java004NO1";
    public static final String URL = "jdbc:mysql://" + HOST + ":3306/" + SystemConstant.DB
			+ "?user=" + SystemConstant.USER + "&password="
			+ SystemConstant.PASSWORD + "&useSSL=true&useUnicode=yes&characterEncoding=UTF-8";
}




