package javaalgorithm.baekjoon.silver.s2;

import java.util.*;

// DFS, BFS
public class P1260 {
	static int N, M, V;
	static boolean[][] map; // 노드 연결 여부
	static boolean[] isVisited; // 방문 여부
	static Stack<Integer> stk = new Stack<>(); // BFS를 위한 대기열
	static StringBuffer sbBfs = new StringBuffer(); // BFS 출력 결과
	static Queue<Integer> que = new LinkedList<>();  // DFS를 위한 대기열
	static StringBuffer sbDfs = new StringBuffer(); // DFS 출력 결과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		map = new boolean[N+1][N+1];
		isVisited = new boolean[N+1];

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = true;
		}
		
		// dfs 탐색
		stk.push(V); // 초기 위치 V
		while (!stk.isEmpty()) {
			dfs();
		}
		
		// 방문 내역 초기화
		initiate();
		
		// bfs 탐색
		que.offer(V); // 초기 위치 V
		while (!que.isEmpty()) {
			bfs();
		}
		
		// 출력
		System.out.println(sbDfs.toString().trim());
		System.out.println(sbBfs.toString().trim());
		
		sc.close();
	}
	
	// dfs 탐색
	public static void dfs() {
		// 대기열에서 수행할 노드 찾기
		int x = stk.peek();		
		
		// 방문 로직 수행
		if (!isVisited[x]) {
			isVisited[x] = true;
			sbDfs.append(x + " ");
		}

		// 다음 대기열 추가한다.
		if (!addStk(x)) { // 더이상 추가할 이웃 노드 없으면
			stk.pop(); // 대기열에서 노드 꺼내기
		}
	}
	
	// 스택 대기열에 노드 추가하기
	public static boolean addStk(int x) {
		for (int i = 1; i <= N; i++) {
			if (map[x][i] && !isVisited[i]) {
				stk.push(i);
				return true;
			}
		}
		return false;
	}
	
	// bfs 탐색
	public static void bfs() {
		// 대기열에서 수행할 노드를 찾기
		int x = que.peek();
		
		// 방문 로직 수행
		if (!isVisited[x]) {
			sbBfs.append(x + " ");
			isVisited[x] = true;			
		}
		
		// 다음 대기열 추가
		addQue(x);
		
		// 대기열에서 노드 꺼내기
		que.poll();
	}
	
	// 큐 대기열에 노드 추가하기
	public static void addQue(int x) {
		for (int i = 1; i <= N; i++) {
			if (map[x][i] && !isVisited[i]) {
				que.offer(i);
			}
		}
	}
	
	// 방문 내역 초기화하기
	public static void initiate() {
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
	}
}