package javaalgorithm.temp;

public class MyString {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str.charAt(0));
		System.out.println(str.substring(0,1));
		
		String phone_number = "01012345678";
		System.out.println(phone_number.substring(phone_number.length()-4, phone_number.length()));
		char[] ch = phone_number.toCharArray();
		String strOfArr = String.valueOf(ch);
		System.out.println(strOfArr);
		System.out.println(phone_number.replaceAll(".(?=.{4})", "*"));
	}
}
