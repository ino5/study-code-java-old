package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P9012 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while (T-- > 0) {
			String str = sc.next();
			if (checkYes(str)) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
	
	public static boolean checkYes(String str) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		
		// 홀수면 false
		if (list.size() % 2 == 1) return false;
		
		// () 찾아서 제거하기
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == '(' && list.get(i+1) == ')') {
				list.remove(i--);
				list.remove(i--+1);
				i = -1;
			}
		}

		if (list.size() == 0) return true;
		else return false;
	}
}
