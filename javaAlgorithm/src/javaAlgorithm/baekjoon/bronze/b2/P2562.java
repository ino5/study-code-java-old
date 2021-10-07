package javaAlgorithm.baekjoon.bronze.b2;

import java.util.Scanner;

public class P2562 {
	static int[] N = new int[9];
	static int rIdx = 0; // 결과 인덱스
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
			
			// 현재 최대값보다 큰지 비교
			if (N[i] > N[rIdx]) {
				rIdx = i;
			}
		}
		
		// 출력
		System.out.println(N[rIdx]);
		System.out.println(rIdx+1);
	}
}
