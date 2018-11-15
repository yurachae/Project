package WordQuiz;
//사용자에게 입력받아서 등록된 정보가 있는지 확인해서 맞다면 true, 아니면 false 전달
public class Member {
	// 변수
	String id;
	String pass;

	// 생성자
	public Member() {
	}

	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}	
}
