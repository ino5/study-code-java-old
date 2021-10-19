package javaalgorithm.baekjoon.bronze.b4;

import java.util.*;

public class P1712 {
	static int A, B, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		// -1 조건
		if (B >= C) System.out.println(-1);
		else System.out.println((A / (C-B))+1);
	
		
		sc.close();
	}
}
