package javaAlgorithm.baekjoon.b2;

import java.util.Scanner;

public class P2577 {
    static int[] cnts = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = a * b * c;
        scan(d);

        for (int i = 0; i < cnts.length; i++) {
            System.out.println(cnts[i]);
        }
    }

    public static void scan(long num) {
        while (num > 0) {
            cnts[(int) num % 10]++;
            num /= 10;
        }
    }
}
