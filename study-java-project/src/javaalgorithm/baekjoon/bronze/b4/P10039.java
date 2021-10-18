package javaalgorithm.baekjoon.bronze.b4;

import java.util.*;

public class P10039 {
	static int[] scores = new int[5];
	static int avg = 0;
	static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
			
			sum += scores[i] < 40 ? 40 : scores[i]; 
		}
		avg = sum / scores.length;
		
		System.out.println(avg);
		
		sc.close();
	}
}
