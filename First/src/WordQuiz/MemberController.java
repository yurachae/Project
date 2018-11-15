package WordQuiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MemberController {

	public void MemberControl() {
		System.out.println("<<사용자 계정입니다.>>");
		while (true) {
			System.out.println("1.문제 풀기|2.틀린 문제|3.틀린문제 다시풀기 |4.종료");
			System.out.print("선택>> ");
			int select = Main.scan.nextInt();

			// 문제풀기.
			if (select == 1) {
				solveQuestion();
			}
			// 틀린문제 보여주기
			else if (select == 2) {
				wrongQeustion();
			}
			// 틀린문제 다시 풀기
			else if (select == 3) {
				retryWrongQuestion();
			}
			// 종료
			else if (select == 4) {
				System.out.println("사용자 모드를 종료합니다.");
				break;

			} else {
				System.out.println("다시 입력하세요.");
			}
		}
	}

	// 문제풀기 메소드
	public void solveQuestion() {
		int count = 0; // 정답 카운드

		if (Main.word.equals(null)) { // 단어장에 단어가 없음.
			System.out.println("단어가 없습니다.");
		} else {// 단어장에 단어가 있음.
			System.out.println("단어 퀴즈입니다.");
			System.out.println("저장된 단어는 " + Main.word.size() + "개 있습니다");
			
			for (int i = 0; i < Main.word.size(); i++) { // 문제 풀기
				String question = Main.word.get(i);// 랜덤한 수의 번호대로 단어 가져오기.(set은 저장 순서대로 나오지 않음)

				System.out.println("문제" + (i + 1) + ". " + question);
				System.out.print("입력 >> ");
				String answer = Main.scan.next(); // 사용자 입력값.

				String trimAnswer = answer.trim();
				String splitAnswer[] = trimAnswer.split(","); // 공백 제거된 단어를 ,로 넣었다면
				boolean state = false;

				// 정답 확인하기.
				for (int k = 0; k < splitAnswer.length; k++) {
					if (Main.meaningWord.get(question).contains(splitAnswer[k])) {
						state = true;
					} else {
						state = false;
					}
				}

				if (state) {
					System.out.println("정답입니다.");
					count++;
				} else {
					System.out.println("틀렸습니다.");
					System.out.println("정답은 " + Main.meaningWord.get(question) + "입니다.");
					
					//틀린걸 넣을 리스트가 비었거나 question과 같은 게 없으면 추가.
					Main.wrongWord.add(question);//hashset으로 저장.
				}
			} // 문제 풀기가 끝남.
			
			
			
			System.out.println("----------------------------");
			System.out.println("고생하셨습니다. ");
			System.out.println("맞힌 갯수는 " + count + "개 입니다.");

		}
	}

	// 틀린문제 출력 메소드
	public void wrongQeustion() {
		System.out.println("----------------------------");
		System.out.println("틀린 문제입니다.");
		System.out.println("총 " + Main.wrongWord.size() + "개입니다.");

		Iterator<String> itr = Main.wrongWord.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	// 틀린문제 다시풀기 메소드
	public void retryWrongQuestion() {
		ArrayList<String> testWord = new ArrayList<String>();
		int count=0;
		
		//틀린문제 set에 있는 값 출력.
		Iterator<String> itr = Main.wrongWord.iterator();
		while(itr.hasNext()) {
			testWord.add(itr.next());
		}


		if (Main.wrongWord.equals(null)) {
			System.out.println("단어가 없습니다.");
		} else {
			System.out.println("<틀린 단어입니다.>");
			for (int i = 0; i < testWord.size(); i++) { // 문제 풀기
				String question = testWord.get(i); // 틀린문제를 랜덤하게 가져와서 변수에 하나 저장.
				System.out.println("문제" + (i + 1) + ". " + question);
				System.out.print("입력 >> ");
				String answer = Main.scan.next(); // 사용자 입력값.

				String trimAnswer = answer.trim();
				String splitAnswer[] = trimAnswer.split(","); // 공백 제거된 단어를 ,로 넣었다면

				boolean state = false;
				// 영어 단어와 뜻이 있는 해쉬 맵에 문제와 같은 걸 찾아서 입력한 정답과 같은지 비교.
				// 정답 확인하기.
				for (int k = 0; k < splitAnswer.length; k++) {
					if (Main.meaningWord.get(question).contains(splitAnswer[k])) {
						state = true;
					} else {
						state = false;
					}
				}
				if (state) {
					System.out.println("정답입니다.");
					Main.wrongWord.remove(question);	//정답 맞추면 오답에서 제거하기.
					count++;
				} else {
					System.out.println("틀렸습니다.");
					System.out.println("정답은 " + Main.meaningWord.get(question) + "입니다.");
					
					//틀린걸 넣을 리스트가 비었거나 question과 같은 게 없으면 추가.
					Main.wrongWord.add(question);//중복저장 안 됨.
				}
			} // 문제 풀기가 끝남.
			System.out.println("고생하셨습니다. ");
			System.out.println("맞힌 갯수는 " + count + "개 입니다.");
		}

	}
}
