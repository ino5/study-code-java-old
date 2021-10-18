package javaalgorithm.baekjoon.bronze.b1;

import java.util.*;

public class P2750 {
	static int N;
	static int[] inputs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		Arrays.sort(inputs);
		Arrays.stream(inputs).forEach(num -> System.out.println(num));
		sc.close();
	}
}
