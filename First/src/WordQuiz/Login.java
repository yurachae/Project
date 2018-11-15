package WordQuiz;

public class Login {
	Member admin = new Member("admin", "admin"); // 관리자 계정
	Member mem = new Member("mem", "mem"); // 사용자 계정
	
	// 메소드
		public String CheckIn() {
			// 사용자로부터 입력 받은 값 저장할 변수.
			String inputId;
			String inputPass;

			// 단어를 저장할 Map<번호, 단어> : 영어 단어
			// 영어 단어와 번호로 연결된 Map<번호, 뜻> : 영어 뜻

			System.out.println("<<계정 확인하기>>");
			System.out.print("아이디 : ");
			inputId = Main.scan.next();
			System.out.print("비밀번호 : ");
			inputPass = Main.scan.next();

			// 띄어쓰기인 공백을 제거하기 위해서 사용.
			String trimId = inputId.trim();
			String trimPass = inputPass.trim();
			
			if(admin.id.equals(trimId) && admin.pass.equals(trimPass)) {
				return "admin";
			}else if(mem.id.equals(trimId) && mem.pass.equals(trimPass)){
				return "mem";
			}else {
				return "notuser";
			}

		}
	
}
