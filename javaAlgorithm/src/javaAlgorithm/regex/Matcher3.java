package javaalgorithm.regex;

import java.util.regex.*;

public class Matcher3 {
	public static void main(String[] args) {	
		String str = "erin0521@partner.sk.com";
		String regex = "er";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		int cnt = 0;
		while(matcher.find()) {
			cnt++;
			System.out.println(matcher.start() + "~" + matcher.end());
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
		System.out.println("cnt: " + cnt);
	}
}
