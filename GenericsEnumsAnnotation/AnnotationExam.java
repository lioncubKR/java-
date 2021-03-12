package GenericsEnumsAnnotation;
class Parent {
	void parentMethod() {}
}

class Child extends Parent {
	@Override
	@Deprecated //앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙임. 하위호완성 때문
	void parentMethod() {} 
}

@FunctionalInterface // 함수형 인터페이스는 하나의 추상 메서드만 가능
interface Testable {
	void test(); // 추상메서드
//	void check(); // 추상메서드
}
public class AnnotationExam {
	@SuppressWarnings("deprecation") //컴파일러의 경고메세지가 나타나지 않게 억제한다.
									// 괄호안에 억제하고자하는 경고의 종류를 문자열로 지정.
	public static void main(String[] args) {
		Child c = new Child();
		c.parentMethod(); // Deprecated된 메서드 사용

	}

}
