package javastudy.temp;

import java.util.Scanner;

public class PrintStar5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("*");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		sc.close();
	}
}
