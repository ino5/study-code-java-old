/*
 * 큐 구현
 * _3
 * _2에서 시간초과나서 배열 할당을 N개해서 해보기
 * 그래도 시간초과..
 */
package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P10845_3 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] list;
	static int sPtr = 0;
	static int ePtr = 0;
	public static void main(String[] args) {
		
		N = sc.nextInt();
		list = new int[N];
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
