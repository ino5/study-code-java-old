package javaalgorithm.baekjoon.silver.s3.P11659;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

// Main_1에서 버퍼드라이터로 바꿔도 시간초과
public class Main_2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
			bw.write(Integer.toString(answer) + "\n");
			bw.flush();
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
