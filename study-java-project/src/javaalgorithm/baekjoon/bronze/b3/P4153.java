package javaalgorithm.baekjoon.bronze.b3;

import java.util.*;

// 직삼각형인지 확인하기
public class P4153 {
	static int a, b, c;
	static int temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if (a+b+c == 0) break;
			// 제일 큰 수는 c로
			if (a > b) {
				temp = a;
				a = b;
				b = temp;
			}
			if (b > c) {
				temp = b;
				b = c;
				c = temp;
			}
			
			if (c*c == a*a + b*b) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		sc.close();
	}
}
