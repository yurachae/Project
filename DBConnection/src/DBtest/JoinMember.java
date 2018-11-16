//디비 연결해서 회원가입하기

package DBtest;
//http://jhmocu.tistory.com/54 참고
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;
//데이터베이스에 입력한 아이디랑 비밀번호 저장.
public class JoinMember {
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";// 오라클 접속 정보
	
	private static final String USER = "yr";
	private static final String PASSWORD = "1234";
	private static final String TABLE_NAME = "MEMBER";
	private static final String COL_ID = "id";
	private static final String COL_PASSWORD = "password";

	public void DBConnect(String id, String pass) {
		System.out.println("JDBC 연동");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// Oracle JDBC 드라이버를 메모리에 적재.
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 연동 성공");

			// connection 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			

			String sql = "INSERT INTO "+TABLE_NAME+" VALUES (?,?)";
			System.out.println("sql 문 :" +sql);
			// connection 객체로 statement 객체 생성하기
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2, pass);
			
			int result = pstmt.executeUpdate();			
			System.out.println(result +"행이 삽입되었습니다.");

		} catch (SQLException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
