// 완전제곱수 구하기

package javaalgorithm.etc.prime;

import java.util.Scanner;

public class PrimeRoot {
	public static void main(String[] args) {
		for (int i = 1; i < 10000; i++) {
			int n = i;
			int m = (int) (Math.round(Math.sqrt(n)) * Math.round(Math.sqrt(n)));
			if (n == m) System.out.println(n + " " + (int)Math.sqrt(n));			
		}
	}
}
