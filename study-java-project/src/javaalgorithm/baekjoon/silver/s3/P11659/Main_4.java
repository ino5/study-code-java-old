package javaalgorithm.baekjoon.silver.s3.P11659;

import java.util.Scanner;

// 브루트포스로 해도 안됨..
public class Main_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] inputArr = new int[N];
		for (int i = 0; i < N; i++) {
			inputArr[i] = sc.nextInt();
		}
		int[][] ansArr = new int[N][];
		for (int i = 0; i < N; i++) {
			ansArr[i] = new int[N - 1 - i];
			for (int j = 1; j <N - 1 - i; j++) {
				ansArr[i][j] = doSum(inputArr, i, i + j);
			}
		}
		for (int i = 0; i < M; i++) {
			int sIdx = sc.nextInt() - 1;
			int eIdx = sc.nextInt() - 1 ;
			if (sIdx == eIdx) System.out.println(inputArr[sIdx]);
			else System.out.println(ansArr[sIdx][eIdx - sIdx]);
		}
	}
	
	public static int doSum(int[] inputArr, int sIdx, int eIdx) {
		int sum = 0;
		for (int i = sIdx; i <= eIdx; i++) {
			sum += inputArr[i];
		}
		return sum;
	}
}
