package javaalgorithm.baekjoon.silver.s3.P11659;

import java.util.Scanner;

// 전체에서 빼는 게 이득이면 그렇게 했는데 그래도 시간초과
// 시간 초과
public class Main_3 {
	static int g_allSum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] inputArr = new int[N];
		g_allSum = 0;
		for (int i = 0; i < N; i++) {
			inputArr[i] = sc.nextInt();
			g_allSum += inputArr[i];
		}
		for (int i = 0; i < M; i++) {
			int sIdx = sc.nextInt() - 1;
			int eIdx = sc.nextInt() - 1 ;
			int answer = doAnswer(inputArr, sIdx, eIdx);
			System.out.println(answer);
		}
	}
	
	public static int doAnswer(int[] inputArr, int sIdx, int eIdx) {
		
		if (eIdx - sIdx > inputArr.length / 2) {
			int sum = g_allSum;
			for (int i = 0; i < sIdx; i++) {
				sum -= inputArr[i];
			}
			for (int i = eIdx + 1; i < inputArr.length; i++) {
				sum -= inputArr[i];
			}
			return sum;
		} else {
			int sum = 0;
			for (int i = sIdx; i <= eIdx; i++) {
				sum += inputArr[i];
			}	
			return sum;
		}	
	}
}	

