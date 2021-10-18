package javaalgorithm.baekjoon.bronze.b3;

import java.util.*;

public class P2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		do {
			for (int i = 0; i < N; i++) {
				System.out.print("*");
			}
			System.out.println();
		} while (--N > 0);

		sc.close();
	}
}
