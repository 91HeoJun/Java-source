package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDelete {

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
				String sql = "delete from userTBL where no = 3";

				pstmt = con.prepareStatement(sql);

				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
			}

		} catch (SQLException e) {
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
