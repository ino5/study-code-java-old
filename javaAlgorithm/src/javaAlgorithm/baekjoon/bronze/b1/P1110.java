package javaalgorithm.baekjoon.bronze.b1;

import java.util.*;

public class P1110 {
    static int answer = 0;
    static int N = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cycle(N);
        sc.close();
        System.out.println(answer);
    }
    
    public static void cycle(int num) {
        answer++;
        int num3;
        if (num < 10) num3 = 10 * num;
        else num3 = num;
        int num2 = num3 % 10 + num3 / 10;
        int newNum = (num % 10) * 10 + num2 % 10;
        if (newNum != N) cycle(newNum);
    }
}
