package GenericsEnumsAnnotation;

import java.util.ArrayList;

class Fruit implements Eatable {
	public String toString() { return "Fruit";}
}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy				  { public String toString() { return "Toy"  ;}}

interface Eatable{}

public class LimitedGenerics {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> fruitBox = new FruitBox<Apple>(); 	//에러 타입 불일치
//		FruitBox<Toy> fruitBox = new FruitBox<Toy>(); 		//에러

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		fruitBox.add(new Grape()); // 에러. Grape는 Apple의 자손이 아님
		grapeBox.add(new Grape());
	}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();  // item을 저장할 list
	void add(T item) { list.add(item);	   } // 박스에 item을 추가
	T get(int i)	 { return list.get(i); } // 박스에서 item을 꺼냄
	int size()		 { return list.size(); }
	public String toString() { return list.toString();}
}	
