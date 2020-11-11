package pattern;

public class UserVO {

	// user TBL 테이블의 하나의 레코드를 담을 수 있는 형태로 작성

	private int no;
	private String userName;
	private int birthYear;
	private String addr;
	private String mobile;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "no=" + no + ", userName=" + userName + ", birthYear=" + birthYear + ", addr=" + addr
				+ ", mobile=" + mobile;
	}

}
