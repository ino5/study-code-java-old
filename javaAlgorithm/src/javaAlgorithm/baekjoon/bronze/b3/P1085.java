package javaalgorithm.baekjoon.bronze.b3;

import java.util.*;

// 직사각형 경계선
public class P1085 {
	static int x;
	static int y;
	static int w;
	static int h;
	static int d = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		compareD(x);
		compareD(w-x);
		compareD(y);
		compareD(h-y);
		
		System.out.println(d);
		sc.close();
	}
	public static void compareD(int num) {
		if (num < d) {
			d = num;
		}
	}
}