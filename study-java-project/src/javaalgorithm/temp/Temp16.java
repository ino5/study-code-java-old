package javaalgorithm.temp;

import java.util.Scanner;

public class Temp16 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println((a+b)%c);
        System.out.println(((a%c)+(b%c))%b);
        System.out.println((a*b)%c);
        System.out.println(((a%c)*(b%c))%c);
        sc.close();
	}
}
