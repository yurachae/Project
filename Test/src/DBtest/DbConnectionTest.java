package DBtest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class DbConnectionTest {
	// 오라클 접속 정보.
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// 오라클 계정 이름
	public static final String USER = "yr";
	// 오라클 계정 비밀번호
	public static final String PASSWORD = "1234";
	// 오라클 테이블 이름
	public static final String TABLE_NAME = "wordtable";
	// 첫번째 컬럼
	public static final String COL_ID = "id";
	// 두번째 컬럼
	public static final String COL_ENGLISHWORD = "englishword";
	// 세번째 컬럼
	public static final String COL_MEANING = "meaning";

	// 자바와 오라클DB 연동하기.
	public static void main(String[] args) {
		System.out.println("JDBC 연동하기!!!!");

		Connection conn = null;
		Statement stmt = null;

		try {
			// Oracle JDBC 드라이버를 메모리에 로드하기
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// DB와 Connection(연결) 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// Connection 객체를 사용해서 Statement 객체 생성.
			stmt = conn.createStatement();

			// SQL 문장 작성
			//String sql = "SELECT * FROM WORDTABLE";
			//System.out.println("sql문 : " + sql);
			
			
			// SQL 문장 실행
			//int result = stmt.executeUpdate(sql);

			//select문으로 가져온 결과 값을 출력하기.
			ResultSet rs = stmt.executeQuery("SELECT * FROM WORDTABLE");
			//결과를 가져와서 처음부터 끝까지.
		
			int id;
			String word;
			String meaning;
			while(rs.next()) {
				id = rs.getInt("id");
				word =rs.getString("englishword");
				meaning = rs.getString("meaning");
				
				System.out.println(id+" "+word+" "+meaning);
			}
			
			// 서버가 보낸 결과 처리
			//System.out.println(result + "행이 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 생성한 리로스 해제
			try {
				stmt.close();// Statement 객체 해제
				conn.close(); // Conncetion 객체 해제.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
