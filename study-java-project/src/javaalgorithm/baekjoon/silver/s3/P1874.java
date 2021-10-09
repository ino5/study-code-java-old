package javaalgorithm.baekjoon.silver.s3;
import java.util.*;
//스택 수열
public class P1874 {
	static int N;
	static int[] inputs;
	static int i;
	static int[] stack;
	static int ptr = 0; // 스택이 쌓일 위치
	static int ptrI = 1; // 입력받는 값
	static int ptrO = 0; // pop해야되는 값
	final static char PUSH = '+';
	final static char POP = '-';
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		stack = new int[N];
		i = 0;
		while(N-- > 0) {
			inputs[i++] = sc.nextInt();
		}
		
		while(ptrI != inputs.length + 1) {		
			push();
			while (inputs[ptrO] == stack[ptr - 1]) {
				pop();
				ptrO++;
				if (ptrO == inputs.length) break;
				if (ptr == 0) break;
			}
		}
		if (ptrO < inputs.length) {
			System.out.println("NO");
		} else if (ptrO == inputs.length) {
			System.out.println(sb.toString());
		}
		
		sc.close();
		
	}
	
	public static void push() {
		stack[ptr++] = ptrI++;
		sb.append(PUSH + "\n");
	}
	
	public static void pop() {
		stack[--ptr] = 0;
		sb.append(POP + "\n");
	}
}
