package DBtest;

import java.util.Scanner;

public class MemberCheck {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		JoinMember member = new JoinMember();
		DBselectclass bringMember = new DBselectclass();
		
		System.out.println("1. 회원 등록 | 2. 로그인 ");
		System.out.print("선택>> ");
		int select = scan.nextInt();
		
		if(select == 1) {
			System.out.print("id : ");
			String id= scan.next();
			System.out.print("password : ");
			String pass = scan.next();
			
			member.DBConnect(id,pass);
		}else if(select ==2) {
			bringMember.Bring();
		}
		
	}
}
