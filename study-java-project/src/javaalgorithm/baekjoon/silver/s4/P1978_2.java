/*
 * 소수 판별 문제. 1번에서 최적화시키기. 루트까지만 계산해서
 */

package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P1978_2 {
	static int N;
	static int[] inputs;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		for (int i = 0; i < inputs.length; i++) {
			if (checkPrime(inputs[i])) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static boolean checkPrime(int num) {
		if (num == 1) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0 ) return false;
		}		
		return true;
	}
}
