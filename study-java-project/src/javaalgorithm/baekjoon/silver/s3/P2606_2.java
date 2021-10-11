package javaalgorithm.baekjoon.silver.s3;

import java.util.*;

// 바이러스
public class P2606_2 {
	static int N, P;
	static int cnt = 0; // 감염된 수
	final static int START_NUM = 1; // 시작 감염 컴퓨터 번호
	static boolean[][] map; // 노드 연결 여부
	static boolean[] isVstd; // 방문 여부
	static Queue<Integer> que = new LinkedList<>(); // 방문 대기열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = sc.nextInt();
		map = new boolean[N+1][N+1];
		isVstd = new boolean[N+1];
		// 간선 정보 입력
		for (int i = 0; i < P; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = true;
		}
		
		// bfs 탐색
		que.add(START_NUM); // 첫 감염 컴퓨터 입력
		while(!que.isEmpty()) { 
			bfs();
		}
		
		
		// 1번 컴퓨터 제외한 감염된 수 출력
		System.out.println(cnt - 1); 
		
		sc.close();
	}
	
	// bfs 탐색
	public static void bfs() {
		// 대기열에서 가져오기
		int x = que.peek();
		
		// 방문 로직 수행
		if (!isVstd[x]) {
			isVstd[x] = true;
			cnt++;
		}
		
		// 대기열에 추가하기
		addQue(x);
		
		// 대기열에서 꺼내기
		que.poll();
	}
	
	// 대기열에 추가하기
	public static void addQue(int x) {
		for (int i = 1; i <= N; i++) {
			if (map[x][i] && !isVstd[i]) {
				que.offer(i);
			}
		}
	}
}