// DFS와 BFS
/*
 * 기존에 내가 구성한 것은 큐에 중복해서 넣는 경우가 생겨 메모리 초과를 유발시킨다.
 * 이를 개선해보자.
 */

package javaalgorithm.baekjoon.silver.s2;

import java.util.*;

public class P1260_2 {
	final static int DFS = 1;
	final static int BFS = 2;
	static int N, M, V;
	static boolean[][] isEdge;
	static boolean[]isVisited;
	static Stack<Integer> dfsList = new Stack<>();
	static Queue<Integer> bfsList = new LinkedList<>();
	static StringBuffer sbDfs = new StringBuffer();
	static StringBuffer sbBfs = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		// 간선 정보 입력
		isEdge = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			isEdge[a][b] = isEdge[b][a] = true;
		}
		
		
		/* DFS */
		isVisited = new boolean[N+1]; // 방문 여부 초기화
		visit(V, DFS); // 초기 위치 V 방문
		dfs(); // DFS 수행
		
		/* BFS */
		isVisited = new boolean[N+1]; // 방문 기록 초기화
		visit(V, BFS); // 초기 위치 V 방문
		bfs(); // BFS 수행
		
		// 결과 출력하기
		System.out.println(sbDfs.toString().trim());
		System.out.println(sbBfs.toString().trim());
		
		sc.close();
	}
	
	// 해당 노드에 방문하기 
	public static void visit(int node, int mode) {
		// 방문 처리하기
		isVisited[node] = true;
		
		// 방문 로직 수행 및 리스트 등록
		if (mode == DFS) {
			sbDfs.append(node+ " ");
			dfsList.push(node);
		} else if (mode == BFS) {
			sbBfs.append(node+ " ");
			bfsList.offer(node);
		}
	}
	
	// DFS 탐색
	public static void dfs() {
		// 리스트에서 탐색할 노드 찾기
		int node = dfsList.peek();
		
		// DFS 방식으로 이웃 노드 탐색
		for (int i = 1; i < isEdge[node].length; i++) {
			// 이웃노드이면서 아직 방문하지 않은 노드에 대해서
			if (isEdge[node][i] && !isVisited[i]) {
				// 노드 방문하기
				visit(i, DFS);
				
				// 다음 DFS 탐색 수행하기
				dfs();
			}
		}
		
		// 리스트에서 탐색 완료한 노드 꺼내기
		dfsList.pop();
	}
	
	// BFS 탐색
	public static void bfs() {
		// 리스트에서 탐색할 노드 찾기
		int node = bfsList.peek();
		
		// BFS 방식으로 이웃 노드 탐색
		for (int i = 1; i < isEdge[node].length; i++) {
			// 이웃노드이면서 아직 방문하지 않은 노드에 대해서
			if (isEdge[node][i] && !isVisited[i]) {
				// 노드 방문하기
				visit(i, BFS);
			}
		}
		
		// 리스트에서 탐색 완료한 노드 꺼내기
		bfsList.poll();
		
		// 다음 BFS 탐색 수행하기
		if(!bfsList.isEmpty()) {
			bfs();
		}
	}
}
