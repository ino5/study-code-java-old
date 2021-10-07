package javaAlgorithm.baekjoon.bronze.b2;

import java.util.*;

public class P3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		for (int tIdx = 0; tIdx < 10; tIdx++) {
			int num = sc.nextInt();
			set.add(num % 42);
		}
		System.out.println(set.size());
		sc.close();
	}
}
