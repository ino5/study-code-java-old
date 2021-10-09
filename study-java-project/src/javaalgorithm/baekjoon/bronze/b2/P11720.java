package javaalgorithm.baekjoon.bronze.b2;

import java.util.*;

public class P11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int sum = 0;
		for (int i = 0; i < n ; i++) {
			int num = str.charAt(i) - '0';
			sum += num;
		}
		System.out.println(sum);
	}
}