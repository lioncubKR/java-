package Collection;

import java.util.*;

public class HashSetExam2 {

	public static void main(String[] args) {
		Set set = new HashSet();
		
		// set의 크기가 6보다 작은 동안 1~45사이의 난수를 저장
		for(int i=0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) +1;
			set.add(num);
		}
		
		List list  = new LinkedList(set); // LinkedList(Collection c)
		Collections.sort(list);
		System.out.println(list);
	}

}
