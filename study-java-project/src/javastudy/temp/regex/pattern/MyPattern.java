package javastudy.temp.regex.pattern;

import java.util.regex.Pattern;

public class MyPattern {
	public static void main(String[] args) {
		String regex = "^[0-9]*$";
		String str = "12b4567";
		boolean result = Pattern.matches(regex, str);
		System.out.println(result);
	}
}
