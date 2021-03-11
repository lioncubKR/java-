package GenericsEnumsAnnotation;
enum Direction { EAST, SOUTH, WEST, NORTH}

public class EnumExam {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST; //열거형타입. 상수이름
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		
		System.out.println("d1==d2 ? "+(d1==d2));
		System.out.println("d1==d3 ? "+(d1==d3));
		System.out.println("d1.equls(d3) ? "+d1.equals(d3));
//		System.out.println("d2 > d3 ? "+ (d1 > d3)); //에러	
		System.out.println("d1.compareTo(d3) ? "+ (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? "+ (d1.compareTo(d2)));
		
		switch(d1) {
		case EAST: //Direction.EAST라고 쓸 수 없다.
			System.out.println("The direction is EAST."); break;
		case SOUTH:
			System.out.println("The direction is SOUTH."); break;
		case WEST:
			System.out.println("The direction is WEST."); break;
		case NORTH:
			System.out.println("The direction is NORTH."); break;
		default:
			System.out.println("Invalid Direction."); break;
		}
		
		Direction[] dArr = Direction.values(); //열거형의 모든 상수를 배열로 반환
		
		for(Direction d : dArr) // for(Direction d : Direction.values());
			System.out.printf("%s=%d%n" , d.name(), d.ordinal());
	}
}