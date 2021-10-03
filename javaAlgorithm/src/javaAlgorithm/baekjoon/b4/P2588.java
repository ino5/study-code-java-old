package javaAlgorithm.baekjoon.b4;

import java.util.Scanner;

public class P2588 {
	public static void main(String[] args) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int[] rs = new int[4];
		
		rs[0] = num1 * (num2 % 10);
		rs[1] = num1 * (num2/10 % 10);
		rs[2] = num1 * (num2/100 % 10);
		rs[3] = rs[0] + rs[1] * 10 + rs[2] * 100;
		
		for (int val : rs) {
			System.out.println(val);
		}
		sc.close();
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
