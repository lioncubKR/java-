package exam;

public class exam_01 {

	public static void main(String[] args) {
		int[] ball = new int[45];
		
		//�迭�� �� ��ҿ� 1~45�� ���� �����Ѵ�.
		 for(int i=0; i < ball.length; i++) {
			 ball[i] = i+1;
		 }
		 int temp = 0;	//�ӽú���
		 int j = 0;		//������ ���� �� ������ ����
		 
		 for(int i=0; i < 100; i++) {
			 j = (int)(Math.random() * 45); // �迭 ���� (0 ~ 44)�� ������ ���� ����
			 temp = ball[0];
			 ball[0] = ball[j];
			 ball[j] = temp;           // ball[0] �� ball[j] �� ���� ���ιٲ�
		 }
		 // �迭 ball�� �տ��� ���� 6���� ��Ҹ� ���
		 for(int i=0; i < 6; i++) {
			 System.out.print(ball[i]+ " ");
		 }
	}

}
