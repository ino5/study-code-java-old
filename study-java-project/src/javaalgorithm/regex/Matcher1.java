package javaalgorithm.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher1 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		Matcher matcher = Pattern.compile("\\<[^\\<\\>]+\\>").matcher(text);
    	String textMatched = new String();
    	if (matcher.find()) {
    		textMatched = text.substring(matcher.start()+1, matcher.end()-1);
    	} else {
    		textMatched = text;
    	}
    	System.out.println("textMatched: " + textMatched);
    	if (matcher.find(0)) {
    		String textMatched2 = text.substring(matcher.start()+1, matcher.end()-1);
    		System.out.println("textMatched: " + textMatched2);
    	}
    	scanner.close();
	}
}
