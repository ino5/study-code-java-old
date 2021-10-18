/*
 * Self Numbers
 * d(i) 가 i에 비례하진 x
 */


package javaalgorithm.baekjoon.silver.s5;

import java.util.*;

public class P4673 {
	static Set<Integer> noAnswers = new HashSet<Integer>();
	static final int MAX = 9999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// d(n) 수행
		for (int i = 1; i <= MAX; i++) {
			d(i);
		}
		
		
		// set에 없는 정답 출력
		for (int i = 1; i <= MAX; i++) {
			if (!noAnswers.contains(i)) {
				System.out.println(i);
			}
		}
		
		
		sc.close();
	}
	
	public static void d(int n) {
		int result = n + sumDigit(n);
		
		// set에 등록
		noAnswers.add(result);
		
		// MAX 이하면 반복
		if (result <= MAX) d(result);
	}
	
	public static int sumDigit(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
