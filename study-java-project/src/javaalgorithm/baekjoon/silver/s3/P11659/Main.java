package javaalgorithm.baekjoon.silver.s3.P11659;

// 인터넷 보고 품..
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] inputArr = new int[N];
		for (int i = 0; i < N; i++) {
			inputArr[i] = sc.nextInt();
		}
		int[] ansArr = new int[N];
		ansArr[0] = inputArr[0];
		for (int i = 1; i < N; i++) {
			ansArr[i] = ansArr[i - 1] + inputArr[i];
		}
		for (int i = 0; i < M; i++) {
			int sIdx = sc.nextInt() - 1;
			int eIdx = sc.nextInt() - 1 ;
			int answer;
			if (sIdx == 0) {
				answer = ansArr[eIdx];
			} else {
				answer = ansArr[eIdx] - ansArr[sIdx - 1];
			}
			
			System.out.println(answer);
		}
	}
}
