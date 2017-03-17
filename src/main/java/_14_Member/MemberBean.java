package _14_Member;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String M_Username;
	private String M_Password;
	private String M_Name;
	private String M_Cellphone;	
	private String M_Birthday;
	private String M_Insertdate;
	private String M_Updatedate;
	private int M_Level;			
	private int M_BonusPoints;				
	private int M_Total;
	
	
	public MemberBean(){
		
	}


	public MemberBean(String m_Username, String m_Password, String m_Name, String m_Cellphone, String m_Birthday,
			String m_Insertdate, String m_Updatedate, int m_Level, int m_BonusPoints, int m_Total) {
		super();
		M_Username = m_Username;
		M_Password = m_Password;
		M_Name = m_Name;
		M_Cellphone = m_Cellphone;
		M_Birthday = m_Birthday;
		M_Insertdate = m_Insertdate;
		M_Updatedate = m_Updatedate;
		M_Level = m_Level;
		M_BonusPoints = m_BonusPoints;
		M_Total = m_Total;
	}

	public String getM_Username() {
		return M_Username;
	}


	public void setM_Username(String m_Username) {
		M_Username = m_Username;
	}


	public String getM_Password() {
		return M_Password;
	}


	public void setM_Password(String m_Password) {
		M_Password = m_Password;
	}


	public String getM_Name() {
		return M_Name;
	}


	public void setM_Name(String m_Name) {
		M_Name = m_Name;
	}


	public String getM_Cellphone() {
		return M_Cellphone;
	}


	public void setM_Cellphone(String m_Cellphone) {
		M_Cellphone = m_Cellphone;
	}


	public String getM_Birthday() {
		return M_Birthday;
	}


	public void setM_Birthday(String m_Birthday) {
		M_Birthday = m_Birthday;
	}


	public String getM_Insertdate() {
		return M_Insertdate;
	}


	public void setM_Insertdate(String m_Insertdate) {
		M_Insertdate = m_Insertdate;
	}


	public String getM_Updatedate() {
		return M_Updatedate;
	}


	public void setM_Updatedate(String m_Updatedate) {
		M_Updatedate = m_Updatedate;
	}


	public int getM_Level() {
		return M_Level;
	}


	public void setM_Level(int m_Level) {
		M_Level = m_Level;
	}


	public int getM_BonusPoints() {
		return M_BonusPoints;
	}


	public void setM_BonusPoints(int m_BonusPoints) {
		M_BonusPoints = m_BonusPoints;
	}


	public int getM_Total() {
		return M_Total;
	}


	public void setM_Total(int m_Total) {
		M_Total = m_Total;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
	
}
