package _20_WebShop;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	

		
	private String M_Username;
	private String M_Password;
	private String M_ID;
	private String M_Name;
	private String M_Nick;
	private String M_Sex;
	private String M_Birthday;
	private String M_EMail;
	private String M_Phone;
	private String M_Cellphone;
	private String M_Address;
	private String M_Line;
	private String M_FaceBook;
	private String M_IdentityCard;			
	private String M_Invoice;		
	private String M_UniformNumber;		
	private String M_Insertdate;
	private String M_Updatedate;
	private int M_Level;			
	private int M_BonusPoints;				
	private int M_Total;
	
	
	public MemberBean(){
		
	}

	

	public MemberBean( String m_Username, String m_Password,String m_ID, String m_Name, String m_Nick, String m_Sex,
			String m_Birthday, String m_EMail, String m_Phone, String m_Cellphone, String m_Address, String m_Line,
			String m_FaceBook, String m_IdentityCard, String m_Invoice, String m_UniformNumber, String m_Insertdate,
			String m_Updatedate, int m_Level, int m_BonusPoints, int m_Total) {
		super();
		M_ID = m_ID;
		M_Username = m_Username;
		M_Password = m_Password;
		M_Name = m_Name;
		M_Nick = m_Nick;
		M_Sex = m_Sex;
		M_Birthday = m_Birthday;
		M_EMail = m_EMail;
		M_Phone = m_Phone;
		M_Cellphone = m_Cellphone;
		M_Address = m_Address;
		M_Line = m_Line;
		M_FaceBook = m_FaceBook;
		M_IdentityCard = m_IdentityCard;
		M_Invoice = m_Invoice;
		M_UniformNumber = m_UniformNumber;
		M_Insertdate = m_Insertdate;
		M_Updatedate = m_Updatedate;
		M_Level = m_Level;
		M_BonusPoints = m_BonusPoints;
		M_Total = m_Total;
	}



	public String getM_ID() {
		return M_ID;
	}


	public void setM_ID(String m_ID) {
		M_ID = m_ID;
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


	public String getM_Nick() {
		return M_Nick;
	}


	public void setM_Nick(String m_Nick) {
		M_Nick = m_Nick;
	}


	public String getM_Sex() {
		return M_Sex;
	}


	public void setM_Sex(String m_Sex) {
		M_Sex = m_Sex;
	}


	public String getM_Birthday() {
		return M_Birthday;
	}


	public void setM_Birthday(String m_Birthday) {
		M_Birthday = m_Birthday;
	}


	public String getM_EMail() {
		return M_EMail;
	}


	public void setM_EMail(String m_EMail) {
		M_EMail = m_EMail;
	}


	public String getM_Phone() {
		return M_Phone;
	}


	public void setM_Phone(String m_Phone) {
		M_Phone = m_Phone;
	}


	public String getM_Cellphone() {
		return M_Cellphone;
	}


	public void setM_Cellphone(String m_Cellphone) {
		M_Cellphone = m_Cellphone;
	}


	public String getM_Address() {
		return M_Address;
	}


	public void setM_Address(String m_Address) {
		M_Address = m_Address;
	}


	public String getM_Line() {
		return M_Line;
	}


	public void setM_Line(String m_Line) {
		M_Line = m_Line;
	}


	public String getM_FaceBook() {
		return M_FaceBook;
	}


	public void setM_FaceBook(String m_FaceBook) {
		M_FaceBook = m_FaceBook;
	}


	public String getM_IdentityCard() {
		return M_IdentityCard;
	}


	public void setM_IdentityCard(String m_IdentityCard) {
		M_IdentityCard = m_IdentityCard;
	}


	public String getM_Invoice() {
		return M_Invoice;
	}


	public void setM_Invoice(String m_Invoice) {
		M_Invoice = m_Invoice;
	}


	public String getM_UniformNumber() {
		return M_UniformNumber;
	}


	public void setM_UniformNumber(String m_UniformNumber) {
		M_UniformNumber = m_UniformNumber;
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
