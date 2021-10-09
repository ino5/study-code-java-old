package javaalgorithm.baekjoon.bronze.b2;

import java.util.Scanner;

public class P2675 {
	static int T;
	static int R;
	static String str;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			R = sc.nextInt();
			str = sc.next();
			test();
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static void test() {
		for (int i = 0; i < str.length(); i++) {
			copy(str.charAt(i));
		}
		sb.append('\n');
	}
	
	public static void copy(char ch) {
		for (int i = 0; i < R; i++) {
			sb.append(ch);
		}
	}

}
