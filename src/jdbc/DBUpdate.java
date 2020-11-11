package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUpdate {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "javadb";
		String password = "12345";

		try {
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				String sql = "update userTBL set addr = '제주' where no = 2";
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "수정 성공" : "수정 실패");
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
