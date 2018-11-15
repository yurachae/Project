package WordQuiz;

import java.util.Iterator;
import java.util.Set;

public class ManagerController {
	public void managerControl() {

		System.out.println("<<관리자 계정입니다.>>");
		while (Main.run) {
			System.out.println("1.단어 추가|2.단어 수정|3.단어 삭제|4.단어장 확인|5.종료");
			System.out.print("선택>>");
			int select = Main.scan.nextInt();

			// 단어 추가
			if (select == 1) {
				insertWord();
			}
			// 단어 수정
			else if (select == 2) {
				updateWord();
			}
			// 단어 삭제
			else if (select == 3) {
				deleteWord();
			}
			// 단어장 확인
			else if (select == 4) {
				checkWord();
			}
			// 종료
			else if (select == 5) {
				System.out.println("관리자 모드를 종료합니다.");

				break;
			}
			// 잘 못 입력시
			else {
				System.out.println("다시 입력하세요.(1~4번)");
			}
		}
	}

	public static void insertWord() {

		System.out.println("<입력 종료 시 'q'를 입력하세요>");
		while (true) {
			System.out.println("========================");
			System.out.print("영어 단어를 입력하세요:");
			String english = Main.scan.next();
			if (!english.equals("q")) {
				Main.scan.nextLine();
				System.out.print("단어의 뜻을 입력하세요:");
				String meaning = Main.scan.next();

				// 입력한 영어 단어와 뜻을 공백 없이 저장.
				String trimEnglish = english.trim();
				String trimMeaning = meaning.trim();

				// 영어단어, 단어 의미를 hashMap에 저장.
				Main.word.add(trimEnglish); // 번호를 키로, 영어를 값으로 입력(LinckedList)
				Main.meaningWord.put(trimEnglish, trimMeaning); // 영어를 키로, 의미를 값으로 입력(Hashmap)
				System.out.println("단어가 저장되었습니다.");
				System.out.println("<입력 종료 시 'q'를 입력하세요>");
			} else {
				System.out.println("단어 입력을 종료합니다.");
				break;
			}
		}
	}

	public static void updateWord() {
		boolean run = true; // 수정하는 창을 종료하기 위한 플래그

		while (run) {
			System.out.println("1.단어 수정 |2.뜻 수정 |3.종료");
			System.out.print("선택>");
			int select1 = Main.scan.nextInt();

			// 영어단어 수정하기
			if (select1 == 1) {
				// 저장되어 있는 단어 전부 출력해주기.
				checkWord();

				if (Main.word.size() != 0) { // 저장된 단어가 있으면
					System.out.print("수정할 단어의 번호를 입력하세요 :");
					int replaceNum = Main.scan.nextInt();
					System.out.print("수정 단어를 입력하세요 :");
					String updateWord = Main.scan.next();
					Main.word.set(replaceNum, updateWord);	//입력한 번호의 영어단어를 변경하는 코드.					
					System.out.println("수정되었습니다.");
				} else { // 단어가 없으면
					System.out.println("입력된 단어가 없습니다.");
				}
				
			// 뜻 수정하기
			} else if (select1 == 2) {
				// 저장되어 있는 단어 전부 출력해주기.
				checkWord();

				if (Main.meaningWord.size() != 0) { // 저장된 단어가 있으면
					System.out.print("수정할 단어의 번호를 입력하세요 :");
					int replaceNum = Main.scan.nextInt();
					System.out.print("수정 단어를 입력하세요 :");
					String updateWord = Main.scan.next();
					
					String replaceWord = Main.word.get(replaceNum);
					Main.meaningWord.replace(replaceWord, updateWord);
					System.out.println("수정되었습니다.");
				} else { // 단어가 없으면
					System.out.println("입력된 단어가 없습니다.");
				}
			} else if (select1 == 3) {
				System.out.println("수정을 종료합니다.");
				run = false;
			} else {
				System.out.println("다시 입력하세요 (1~3번)");
			}
		}
	}

	// 삭제 메소드
	public static void deleteWord() {
		// 저장되어 있는 단어 전부 출력해주기.
		checkWord();

		if (Main.meaningWord.size() != 0) { // 저장된 단어가 있으면
			System.out.print("삭제할 단어의 번호를 입력하세요 :");
			int deleteNum = Main.scan.nextInt();
			String deleteWord = Main.word.get(deleteNum);
			Main.word.remove(deleteNum);
			Main.meaningWord.remove(deleteWord);
			System.out.println("삭제되었습니다.");
		}

	}

	public static void checkWord() {
		// 숫자, 영어단어 출력
		
		for(int i =0; i<Main.word.size(); i++) {
			String englishWord = Main.word.get(i);
			String meaningWord1 = Main.meaningWord.get(englishWord);
			System.out.print(i + "\t");
			System.out.print(englishWord + "\t");
			System.out.print(meaningWord1);
			System.out.println();
		}
		
		
	}

}
