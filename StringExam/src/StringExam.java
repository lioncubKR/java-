
public class StringExam {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		System.out.println(sb);
		String s = sb.toString();
		String s2 = sb2.toString();
		System.out.println(sb.equals(sb2));
		System.out.println(s.equals(s2));
	}

}
