//디비 연결해서 로그인하기

package DBtest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;
//데이터베이스에 입력한 아이디랑 비밀번호 가져오기.
public class DBselectclass {
private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";// 오라클 접속 정보
	
	private static final String USER = "yr";
	private static final String PASSWORD = "1234";
	private static final String TABLE_NAME = "MEMBER";
	private static final String COL_ID = "id";
	private static final String COL_PASSWORD = "password";

	public void Bring() {
		Scanner scan = new Scanner(System.in);
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

			String sql = "SELECT * FROM MEMBER";
			System.out.println("sql 문 :" +sql);
			
			//Connection 객체를 사용해서 preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//select문으로 가져온 결과 값을 출력하기.
			ResultSet rs = pstmt.executeQuery(sql);
			
			List<String> selectId = new ArrayList<String>();
			List<String> selectPass = new ArrayList<String>();
			
			while(rs.next()) {
				selectId.add(rs.getString("id"));
				selectPass.add( rs.getString("password"));
			}
			
			System.out.print("id 입력 : ");
			String id = scan.next();
			System.out.println("pw 입력: ");
			String pw = scan.next();
			
			boolean result = false;
			
			for(int i =0; i<selectId.size(); i++) {
				if(selectId.get(i).equals(id)&& selectPass.get(i).equals(pw))
					result= true;					
				else 
					result = false;
			}
			
			if(result) {
				System.out.println("로그인 아이디와 비밀번호가 존재합니다.");
			}else {
				System.out.println("로그인 아디이와 비밀번호가 존재하지 않습니다.");
			}

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
