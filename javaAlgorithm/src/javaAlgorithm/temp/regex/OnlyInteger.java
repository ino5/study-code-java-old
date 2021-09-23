package javaAlgorithm.temp.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyInteger {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("(^[0-9]*$)");
		int onlyNum;
		String inputVal;
		Scanner scanner = new Scanner(System.in);
		
		inputVal = scanner.nextLine();
		Matcher m = p.matcher(inputVal);
		
		if(m.find()) {
			onlyNum = Integer.parseInt(inputVal);
			System.out.println(onlyNum);
		} else {
			System.out.println("no number");
		}
		scanner.close();
	}
}
