package Collection;

import java.util.*;

public class HashMapExam {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Scanner scn = new Scanner(System.in); // 화면으로부터 라인단위로 입력받음
		
		while(true) {
			System.out.println("id와 password를 입력해주세요");
			System.out.print("id :");
			String id = scn.nextLine().trim();
			
			System.out.print("password :");
			String password = scn.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니댜. 다시 입력해주세요.");
				continue;
			}
			if(!map.containsValue(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			if(!(map.get(id).equals(password))) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
		}//while
	}//main의 

}
