package javaalgorithm.baekjoon.bronze.b2;

import java.util.Scanner;

public class P2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        a = reverse(a);
        b = reverse(b);

        System.out.println(Math.max(a, b));
    }
    public static int reverse(int n) {
        int result = 0;
        while (n > 0) {
            result *= 10;
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
