package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		// 기본 길이 (용량 , capacity))가 10인 ArrayList를 생성
		ArrayList list1 = new ArrayList(10);
		//ArrayList에는 객체만 저장가능
		//autoboxing에 의해 기본형이 참조형으로 자동변
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		//ArrayList(Collecion c)
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1 , list2);
		
		// Collection은 인터페이스 , Collections는 유틸 클래스
		Collections.sort(list1); //list1과 list2를 정렬한다.
		Collections.sort(list2); //Collections.osrt(List l)
		print(list1 , list2);
		
		// list1이 list2의 요소를 모두 포함하고 있냐고 묻는 
		System.out.println("list1.contatinsALL(list2):" + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		// 초가할 위치를 지정해 줄 수 있다 기존에 있던 요소들은 자동으로 한칸씩 이동된다.
		list2.add(3,"A");
		print(list1 , list2);
		
		//변경 index3를 AA로 변경한다.
		list2.set(3, "AA");
		print(list1 , list2);
		
		list1.add(0, "1");
		// indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
		System.out.println("index=" + list1.indexOf("1"));
		
		//index로 삭제할 수도 있고 객체나 문자열을 넣을 수도 있다.
		//list1.remove(5);
		list1.remove(new Integer(1));
		
		print(list1 , list2);
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("lsit1.retainAll(list2):" + list1.retainAll(list2));
		print(list1, list2);
		
		//list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i= list2.size()-1; i>= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1 , list2);
	}//main의 끝
	static void print(ArrayList list1 , ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();
	}
}
