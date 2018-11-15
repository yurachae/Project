package WordQuiz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	static List<String> word = new LinkedList<>();//번호와 영어 단어 저장할  linkedList
	static Map<String, String> meaningWord = new HashMap<String, String>(); //영어단어와 뜻 저장 hashmap
	static Set<String> wrongWord = new HashSet<>();//중복되지 않고, 순서 유지 되지 않게 넣기. HashSet
	static int num = 1;
	static boolean run = true;
	
	public static void main(String[] args) {
		ManagerController manager = new ManagerController(); // 관리자의 객체 생성
		MemberController member = new MemberController(); // 사용자의 객체 생성
		Login login = new Login();	

		String result;
		
		while (run) {		
			result = login.CheckIn();
			// 관리자 계정이라면,
			if (result.equals("admin")) {
				manager.managerControl();
				continue;
			} // 사용자 계정이라면
			else if (result.equals("mem")) {
				member.MemberControl();
				continue;
			} // 계정이 없다면 (추후에 회원등록하기 추가)
			else if(result.equals("notuser")) {
				System.out.println("등록되지 않은 계정입니다.");
				System.out.println("다시 시도해주세요.");
				
			}
		}

	}

}
