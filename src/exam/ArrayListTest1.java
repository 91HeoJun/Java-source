package exam;

import java.util.ArrayList;
import java.util.List;

/* 데이터를 어디에 담을 것인가? -> 기본형 타입, 클래스(객체) 타입
 * 단일 데이터일 경우
 * 1. 기본형 : int / float / double / char
 * 2. 객체 : Interger / Float / Double / String ...
 * 
 * 다양한 데이터일 경우 -> 배열, Collection(List, Set), Map
 * List : ArrayList, LinkedList, 
 * 
 * 
 */


public class ArrayListTest1 {

	public static void main(String[] args) {
		// list 객체 생성
		List<String> list = new ArrayList<String>();
		
		//생성된 list에 요소 추가
		list.add("java");
		list.add("JDBC");
		list.add("oracle");
		list.add("html");
		
		// 요소 확인
		System.out.println("특정요소 확인");
		System.out.println(list.get(3));
		
		System.out.println("------");
		System.out.println("전체요소 확인"); 
		// 일반 포문 이용
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 향상된 포문 이용
		for (String str:list) {
			System.out.println(str);
		}
		
		
				
	}

}
