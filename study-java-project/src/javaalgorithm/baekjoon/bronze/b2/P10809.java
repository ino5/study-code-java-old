package javaalgorithm.baekjoon.bronze.b2;

import java.util.Scanner;

public class P10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuffer sb = new StringBuffer();
		
		for (char ch = 'a'; ch <= 'z'; ch++) {
			int pstn = str.indexOf(ch);
			sb.append(pstn + " ");
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}
}
