package exam;

public class exam_01 {

	public static void main(String[] args) {
		int[] ball = new int[45];
		
		//배열의 각 요소에 1~45의 값을 저장한다.
		 for(int i=0; i < ball.length; i++) {
			 ball[i] = i+1;
		 }
		 int temp = 0;	//임시변수
		 int j = 0;		//임의의 값을 얻어서 저장할 변수
		 
		 for(int i=0; i < 100; i++) {
			 j = (int)(Math.random() * 45); // 배열 범위 (0 ~ 44)의 임의의 값을 얻음
			 temp = ball[0];
			 ball[0] = ball[j];
			 ball[j] = temp;           // ball[0] 과 ball[j] 의 값을 서로바꿈
		 }
		 // 배열 ball의 앞에서 부터 6개의 요소를 출력
		 for(int i=0; i < 6; i++) {
			 System.out.print(ball[i]+ " ");
		 }
	}

}
