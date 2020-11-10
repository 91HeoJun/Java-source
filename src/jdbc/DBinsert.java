package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBinsert { 								// 기본값이 AUTO COMMIT 상태

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";

			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				String sql = "insert into userTBL values (userTBL_seq.nextval, '김승우', 1996, '서울', '010-0010-3030')";

				pstmt = con.prepareStatement(sql);
				// INSERT, UPDATE, DELETE 구문은 executeUpdate()로 실행해야 함.
				int result = pstmt.executeUpdate();

				if (result > 0) {
					System.out.println("입력 성공");
				} else {
					System.out.println("입력 실패");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

	}

}
