package CalendarExam;

import java.util.Calendar;

public class CalendarExam4 {
	static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
		int diff = 0;
		try {
			int year1 = Integer.parseInt(yyyymmdd1.substring(0,4));
			int month1 = Integer.parseInt(yyyymmdd1.substring(4,6)) - 1;
			int day1 = Integer.parseInt(yyyymmdd1.substring(6,8));
			int year2 = Integer.parseInt(yyyymmdd2.substring(0,4));
			int month2 = Integer.parseInt(yyyymmdd2.substring(4,6)) -1;
			int day2 = Integer.parseInt(yyyymmdd2.substring(6,8));
			Calendar date1 = Calendar.getInstance();
			Calendar date2 = Calendar.getInstance();
			date1.clear(); //Calendar 생성시 클리어를 필수로 해줘야함.
			date2.clear(); //동시에 선언하는게 아니기떄문에 미세한 차이가 생
			date1.set(year1, month1, day1);
			date2.set(year2, month2, day2);
			diff = (int) ((date1.getTimeInMillis() - date2.getTimeInMillis())/(24 * 60 * 60 * 1000));
		} catch(Exception e) {
			diff = 0; // substring() , parseInt() 에서 예와가 발생하면 0을 반환
		}
		return diff;
	}
	
	public static void main(String[] args) {
		System.out.println(getDayDiff("20010103" , "20010101"));
		System.out.println(getDayDiff("20010103" , "20010103"));
		System.out.println(getDayDiff("20010103" , "200103"));
	}

}
