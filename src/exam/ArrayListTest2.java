package exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {

	public static void main(String[] args) {

		List<Member> list = new ArrayList<Member>();

		list.add(new Member(1234, "고길동"));
		list.add(new Member(1111, "둘리"));
		list.add(new Member(2222, "또치"));
		list.add(new Member(3333, "도우너"));
		list.add(new Member(4444, "마이콜"));

		for (Member mem : list)
			System.out.println(mem);

	}

}
