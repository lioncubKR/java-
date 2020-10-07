class Person {
	long id;
	
	public boolean equals(Object obj) {
		if(obj instanceof Person)
			return id == ((Person)obj).id;
		else 
			return false;
	}
	
	Person(long id){
		this.id = id;
	}
}
public class objectTest2 {

	public static void main(String[] args) {
		Person p1 = new Person(11123456789L);
		Person p2 = new Person(11123456789L);
		
		if(p1.equals(p2)) 
			System.out.println("p1과p2는 같습니다.");
		else 
			System.out.println("p1과p2는 다릅니다.");
		

	}

}
