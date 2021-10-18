/*
 * 큐 구현
 * LinkedList로 구현하니 시간초과 발생하여서 배열로 구현
 * 근데도 시간초과...
 */
package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P10845_2 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static final int M = 10000;
	static int[] list = new int[M];
	static int sPtr = 0;
	static int ePtr = 0;
	public static void main(String[] args) {
		
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			command(sc.next());
		}
		sc.close();
	}
	
	public static void command(String str) {
		if(str.equals("push")) push(sc.nextInt());
		else if (str.equals("pop")) pop();
		else if (str.equals("size")) size();
		else if (str.equals("empty")) empty();
		else if (str.equals("front")) front();
		else if (str.equals("back")) back();
	}
	
	public static void push(int n) {
		list[ePtr++] = n;
	}
	
	public static void pop() {
		if (!isEmpty()) {
			System.out.println(list[sPtr++]);
		} else alertEmpty();
	}
	
	public static boolean isEmpty() {
		if (sPtr == ePtr) return true;
		else return false;
	}
	
	public static void alertEmpty() {
		System.out.println(-1);
	}
	
	public static void size() {
		System.out.println(ePtr - sPtr);
	}
	
	public static void empty() {
		if (isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void front() {
		if (!isEmpty()) {
			System.out.println(list[sPtr]);
		} else alertEmpty();
	}
	
	public static void back() {
		if (!isEmpty()) {
			System.out.println(list[ePtr - 1]);
		} else alertEmpty();
	}
}
