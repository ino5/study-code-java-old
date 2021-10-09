package javaalgorithm.baekjoon.bronze.b1;

import java.util.Scanner;

public class P1546 {
	static double max = Integer.MIN_VALUE;
	static double[] arr;
	static double sum;
	static double avg;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / max * 100;
			sum += arr[i];
		}
		avg = sum / arr.length;
		
		System.out.println(avg);
		
		sc.close();
	}
}
