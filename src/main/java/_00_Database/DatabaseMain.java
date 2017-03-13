package _00_Database;

import java.util.Scanner;

public class DatabaseMain {

	public static void main(String[] args) {
		
		System.out.println("請輸入a或b選擇");
		System.out.println("a  第一次新增tables");
		System.out.println("b  刪除並新增tables");
		System.out.println("e  離開此程式");
		String ans = null;
		Scanner input =null;
		while(true){
		    input = new Scanner(System.in);
			ans = input.next();
			if(ans.equals("a") || ans.equals("b")){				
				break;
			}else if(ans.equals("e")){
				input.close();
				System.out.println("程式已結束");
				return;			
			}
			System.out.println("輸入錯誤，請重新輸入");
			
		}
		input.close();
		
		System.out.println("----------------------------");	
		DatabaseDAO pDao = new DatabaseDAO();
		if(ans.equals("a")){
			pDao.setCreateTables();
			pDao.setInsertUser();
		}else if(ans.equals("b")){
			pDao.setResetTables();
			pDao.setInsertUser();
		}else{
			System.out.println("error");
			return;
		}
		
		System.out.println("--------------------");
		System.out.println("tables新建完成");
	}
}
