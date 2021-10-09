package javaalgorithm.baekjoon.bronze.b2;

import java.util.Scanner;

public class P2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int prev = -1;
		boolean isAsc = false;
		boolean isMix = false;
		boolean isCmp = false;
		for (int i = 0; i < 8; i ++) {
			int num = sc.nextInt();
			if (!isCmp) {
				if (i == 1) {
					isAsc = num > prev ? true : false;
				} else if (i > 1) {
					if ((num > prev && !isAsc) || (num < prev && isAsc)) {
						isMix = true;
						isCmp = true;
					}
				}
				prev = num;
			}
		}
		if (isMix) System.out.println("mixed");
		else if (isAsc) System.out.println("ascending");
		else System.out.println("descending");
		sc.close();
	}
}
