package javaalgorithm.baekjoon.bronze.b3;

import java.util.Scanner;

public class P10871 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > X) {
                sb.append(num + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        sc.close();
	}
}
