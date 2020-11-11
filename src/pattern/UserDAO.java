package pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javadb";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// 연결 종료 메소드
	public static void close(Connection con) {
		try {
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs) {
		try {
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 조회
	public List<UserVO> getList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<UserVO>();

		try {
			con = getConnection();
			// select : 여러 행의 결과가 출력(ArrayList)되는 것인지
			// or 하나의 행만 출력(~~VO)되는 것인지에 따라 담을 객체가 결정

			String sql = "select * from userTBL";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) { //
				UserVO user = new UserVO();
				user.setNo(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setBirthYear(rs.getInt("birthYear"));
				user.setAddr(rs.getString("addr"));
				user.setMobile(rs.getString("mobile"));
				list.add(user);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return list;

	}

	// 삭제
	public boolean deleteUser(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {
			con = getConnection();
//			String sql = "delete from userTBL where no =" + no;
			String sql = "delete from userTBL where no = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); // (첫번째 물음표, 대입필드)
			int result = pstmt.executeUpdate();

			if (result > 0) { // 삭제 성공
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return flag;

	}

	// 수정
	public boolean updateUser(String addr, int no) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "update userTBL set addr = ? where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setInt(2, no);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
			close(con);

		}
		return flag;

	}

	// 삽입

	public boolean insertUser(UserVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {
			con = getConnection();
			String sql = "insert into userTBL values(userTBL_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getUserName());
			pstmt.setInt(2, vo.getBirthYear());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getMobile());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
			close(con);
		}
		
		return flag;

	}

}
