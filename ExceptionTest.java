
public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(5);
		}catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	System.out.println(6);
	}

}
