package javaAlgorithm.baekjoon.silver.s1;

import java.util.*;

public class P2178 {
	static int N;
	static int M;
	static int[][] map;
	static Queue<int[]> que = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1) - '0' == 1 ? -1 : -2;
			}
		}
		
		que.add(new int[] {1,1});
		map[1][1] = 1;
		while (!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			bfs(x, y);
			que.poll();
		}
		System.out.println(map[N][M]);
		
		sc.close();
	}
	
	public static void bfs(int x, int y) {
		check(x+1, y, map[y][x]);
		check(x, y+1, map[y][x]);
		check(x-1, y, map[y][x]);
		check(x, y-1, map[y][x]);
	}
	
	public static void check(int x, int y, int cost) {
		if (x>=1 && x<= M && y>=1 && y<= N && map[y][x] == -1) {
			map[y][x] = cost + 1;
			que.add(new int[] {x, y});
		}
	}
}

	/*
	 while (큐에 값있으면)
		큐에서 값 뺀다.
		bfs(x,y)
	 
	 bfs(x,y)
	 	지금 cost 입력
	 	큐에 인근 이동 가능 좌표 등록
	 	
	 */