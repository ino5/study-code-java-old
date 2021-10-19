/*
 * 소수 판별 문제인데 루트까지만으로 최적화도 해보기
 */

package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P1978 {
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
		for (int i = 2; i < num; i++) {
			if (num % i == 0 ) return false;
		}		
		return true;
	}
}
