/*
 * 큐 구현
 * _4
 * _3에서 출력을 BufferedWriter 이용해서 해보기...
 * BufferedWriter만 이용하니까 464ms 나온다.
 */
package javaalgorithm.baekjoon.silver.s4;

import java.io.*;
import java.util.*;

public class P10845_4 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] list;
	static int sPtr = 0;
	static int ePtr = 0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	public static void main(String[] args) throws IOException {
		
		N = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			command(sc.next());
		}
		sc.close();
		bw.flush();
		bw.close();
	}
	
	public static void command(String str) throws IOException {
		if(str.equals("push")) push(sc.nextInt());
		else if (str.equals("pop")) pop();
		else if (str.equals("size")) size();
		else if (str.equals("empty")) empty();
		else if (str.equals("front")) front();
		else if (str.equals("back")) back();
	}
	
	public static void push(int n) throws IOException {
		list[ePtr++] = n;
	}
	
	public static void pop() throws IOException {
		if (!isEmpty()) {
			bw.write(list[sPtr++] + "\n");
		} else alertEmpty();
	}
	
	public static boolean isEmpty() throws IOException {
		if (sPtr == ePtr) return true;
		else return false;
	}
	
	public static void alertEmpty() throws IOException {
		bw.write(-1 + "\n");
	}
	
	public static void size() throws IOException {
		bw.write((ePtr - sPtr) + "\n");
	}
	
	public static void empty() throws IOException {
		if (isEmpty()) bw.write(1 + "\n");
		else bw.write(0 + "\n");
	}
	
	public static void front() throws IOException {
		if (!isEmpty()) {
			bw.write(list[sPtr] + "\n");
		} else alertEmpty();
	}
	
	public static void back() throws IOException {
		if (!isEmpty()) {
			bw.write(list[ePtr - 1] + "\n");
		} else alertEmpty();
	}
}
