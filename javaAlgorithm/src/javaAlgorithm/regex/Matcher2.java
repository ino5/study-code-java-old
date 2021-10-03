package javaAlgorithm.regex;

import java.util.regex.*;

public class Matcher2 {
	public static void main(String[] args) {
		int cnt = 0;
		String str = "erin0521@partner.sk.com";
//		System.out.println("length: " + str.length());
//		String regex = "^\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String regex = "er";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			cnt++;
			System.out.println(matcher.start() + "~" + matcher.end());
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
		System.out.println("cnt: " + cnt);
	}
}
