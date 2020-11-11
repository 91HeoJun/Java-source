package pattern;

import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {

		System.out.println("===== UserTBL =====");
		System.out.println("1. 조회");
		System.out.println("2. 삽입");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("===================");

		System.out.print("번호입력 : ");
		Scanner s = new Scanner(System.in);
		int menu = s.nextInt();

		UserDAO dao = new UserDAO();

		switch (menu) {
		case 1: // 전체출력
			System.out.println("userTBL 전체출력");
			List<UserVO> list = dao.getList();
			for (UserVO vo : list) {
				System.out.println(vo);
			}
			break;

		case 2: // 삽입
			UserVO vo = new UserVO();
			
			System.out.println("삽입할 회원 정보");
			System.out.print("회원명 :");
			vo.setUserName(s.next());
			
			System.out.print("출생년도 :");
			vo.setBirthYear(s.nextInt());
			
			System.out.print("주소 :");
			vo.setAddr(s.next());
			
			System.out.print("폰번호 :");
			vo.setMobile(s.next());

			System.out.println(dao.insertUser(vo)? "삽입성공" : "삽입실패");
			
			break;

		case 3: // 삭제
			System.out.print("삭제할 회원번호 입력 : ");
			int no = s.nextInt();
			boolean flag = dao.deleteUser(no);
			System.out.println(flag ? "삭제성공" : "삭제실패");

			break;

		case 4: // 수정
			System.out.println("수정할 회원정보 입력");

			System.out.print("수정할 회원번호 입력 : ");
			no = s.nextInt();

			System.out.print("수정할 주소 입력 : ");
			String addr = s.next();

			flag = dao.updateUser(addr, no);
			System.out.println(flag ? "수정성공" : "수정실패");

			break;

		}
	}
}