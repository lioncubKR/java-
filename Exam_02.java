package exam;

public class Exam_02 {

	public static void main(String[] args) {
		//�迭�� ����
		
		int[] number = {1,2,3,4,5};
		int[] newNumber= new int[10];
		
		for(int i=0; i<number.length; i++) {
			newNumber[i] = number[i];
		}
		
		System.arraycopy(number, 0 ,newNumber, 0, number.length);
		//number[0] ���� newNumber[0]���� number.length���� �����͸� ����
	}

}
