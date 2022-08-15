package javaalgorithm.baekjoon.silver.s3.P11659;

// 시간초과 뜸
import java.util.*;

public class Main_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] inputArr = new int[N];
		for (int i = 0; i < N; i++) {
			inputArr[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			int sIdx = sc.nextInt() - 1;
			int eIdx = sc.nextInt() - 1 ;
			int answer = doAnswer(inputArr, sIdx, eIdx);
			System.out.println(answer);
		}
	}
	
	public static int doAnswer(int[] inputArr, int sIdx, int eIdx) {
		int sum = 0;
		for (int i = sIdx; i <= eIdx; i++) {
			sum += inputArr[i];
		}
		return sum;
	}
}
