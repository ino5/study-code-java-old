/*
 * 큐 구현
 * LinkedList로 구현
 * 시간 초과 발생
 */
package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P10845 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static LinkedList<Integer> list = new LinkedList<>();
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
		list.addLast(n);
	}
	
	public static void pop() {
		if (!list.isEmpty()) {
			System.out.println(list.pollFirst());
		} else alertEmpty();
	}
	
	public static void alertEmpty() {
		System.out.println(-1);
	}
	
	public static void size() {
		System.out.println(list.size());
	}
	
	public static void empty() {
		if (list.isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void front() {
		if (!list.isEmpty()) {
			System.out.println(list.peekFirst());
		} else alertEmpty();
	}
	
	public static void back() {
		if (!list.isEmpty()) {
			System.out.println(list.peekLast());
		} else alertEmpty();
	}
}
