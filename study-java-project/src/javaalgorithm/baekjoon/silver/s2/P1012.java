package javaalgorithm.baekjoon.silver.s2;

import java.util.*;

// 유기농 배추
public class P1012 {
	static int T, W, H, K;
	static boolean[][] map; // 배추 위치 저장한 맵
	static boolean[][] isVisited; // 방문 여부
	static int cnt; // 필요한 지렁이 수
	static int numThing, cntVisit; // 배추 수, 방문 수 
	static Queue<int[]> que = new LinkedList<>(); // bfs 방문 대기열 (x,y)
	static List<int[]> things = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while (T-- > 0) {
			W = sc.nextInt();
			H = sc.nextInt();
			K = sc.nextInt();
			
			// 초기화
			things.clear();
			cnt = numThing = cntVisit = 0;
			que.clear();
			map = new boolean[H][W];
			isVisited = new boolean[H][W];
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = true; 
				numThing++;
				things.add(new int[] {x, y});
			}
			
			// 반복마다 새로운 하나의 지렁이 방문 수행
			while(cntVisit < numThing) { // 모든 배추 방문했는지 확인
				//지렁이 수 증가
				cnt++;
				
				// 방문 시작할 배추 찾아 대기열 등록
				addStart();
				
				// 해당 지렁이 dfs로 인근 배추 방문 반복
				while (!que.isEmpty()) {
					dfs();
				}
			}
			// 결과 출력
			System.out.println(cnt);
		}
		sc.close();
	}
	
	// 시작점 배추 찾아 대기열 등록
	public static void addStart() {
		for (int i = 0; i < things.size(); i++) {
			int X = things.get(i)[0];
			int Y = things.get(i)[1];
			if (!isVisited[Y][X]) {
				que.offer(new int[] {X, Y});
				things.remove(i--);
				return;
			} else {
				things.remove(i--);
			}
		}
	}
	
	// dfs 탐색
	public static void dfs() {
		// 대기열에서 탐색할 노드 지정
		int[] node = que.peek().clone();
		int X = node[0];
		int Y = node[1];
		
		// 방문 로직 수행
		visit(X, Y);
		
		// 인근 노드에 대해 대기열에 추가할 수 있는지 확인하고 추가
		addQue(X+1, Y);
		addQue(X-1, Y);
		addQue(X, Y+1);
		addQue(X, Y-1);
		
		// 대기열에서 탐색한 노드 제거
		que.poll();
	}
	
	// 방문 로직
	public static void visit(int X, int Y) {
		if (!isVisited[Y][X]) {
			isVisited[Y][X] = true;
			cntVisit++;
		}
	}
	
	// 대기열 추가할 수 있는지 확인하고 추가
	public static void addQue(int X, int Y) {
		if (X < 0 || X > W - 1) return;
		if (Y < 0 || Y > H - 1) return;
		
		if (map[Y][X] && !isVisited[Y][X]) {
			que.offer(new int[] {X, Y});
			visit(X, Y);
		}
	}
}
