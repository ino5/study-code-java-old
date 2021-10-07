package javaAlgorithm.baekjoon.silver.s3;

import java.util.*;

public class P2606 {	
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[][] map;
	static boolean[] isInfected;
	static int comNum;
	static int lineNum;
	static int answer = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		comNum = sc.nextInt();
		lineNum = sc.nextInt();
		map = new boolean[comNum + 1][comNum + 1];
		isInfected = new boolean[comNum + 1];
		
		// make map
		for (int i = 0; i < lineNum; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = true;
		}
		
		queue.add(1);
		bfs();
		for (boolean val : isInfected) {
			if(val) answer++;
		}
		System.out.println(answer);
		sc.close();
	}
	
	public static void bfs() {
		int num = queue.peek();
		for (int i = 1; i <= comNum; i++) {
			if (map[num][i] && !isInfected[i]) {
				queue.add(i);
			}
		}
		isInfected[num] = true;
		queue.poll();
		if (!queue.isEmpty()) {
			bfs();
		}
	}
}
