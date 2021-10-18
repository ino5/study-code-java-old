package javaalgorithm.baekjoon.bronze.b3;

import java.util.*;

public class P2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int blankCnt = 0;
		do {
			blank(blankCnt++);
			star(N);
			System.out.println();
		} while (--N > 0);
		sc.close();
	}
	
	public static void star(int n) {
		if (n > 0) {
			System.out.print("*");
			star(--n);
		}
	}
	
	public static void blank(int n) {
		if (n > 0) {
			System.out.print(" ");
			blank(--n);
		}		
	}
	
}
