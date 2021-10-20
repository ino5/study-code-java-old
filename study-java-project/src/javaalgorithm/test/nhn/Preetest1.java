package javaalgorithm.test.nhn;

import java.util.*;

public class Preetest1 {
	static int N;
	static boolean[][][] map; // [][][0]: 유효영역여부, [][][1]: 방문여부
	static int visitCnt; // 방문한 수
	static int visitTotal; // 총 방문수 
	static int areaCnt; // 구역 수
	static int area;
	static List<Integer> sizeList = new ArrayList<>();
	static Stack<int[]> stack = new Stack<>();
	static int startingI = 0;
	static int startingJ = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N][2];
		
		// 행렬 값 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sc.nextInt() == 1) {
					map[i][j][0] = true;
					visitTotal++;
				}
				else map[i][j][0] = false;
			}
		}
		
		
		
		// 모두 방문할 때까지  반복
		while(visitCnt != visitTotal) {
			areaCnt++; // 구역 수 추가
			area = 0; // 면적 초기화
			visitStarting(); // 스타팅 위치 찾고 방문 시작
			
			// 인근 지역 모두 방문 끝났을 때
			sizeList.add(area); // 면적 등록
			
		}
		
		// 면적 오름차순 정렬
		Collections.sort(sizeList);
		
		// 출력		
		if (sizeList.size() == 0) {
			System.out.println(0);
		} else {
			for (int val : sizeList) {
				System.out.print(val + " ");
			}			
		}
		
		sc.close();
	}
	
	// 스타팅 위치 찾고 방문
	public static void visitStarting() {
		for (int i = startingI; i < N; i++) {
			startingJ = 0;
			for (int j = startingJ; j < N; j++) {
				if (map[i][j][0] && !map[i][j][1]) {
					visit(i,j);
					startingI = i;
					startingJ = j;
					return;
				}
			}
		}
	}
	
	// 방문
	public static void visit(int i, int j) {
		if (i >= N || i < 0) return;
		if (j >= N || j < 0) return;
		if (map[i][j][0] && !map[i][j][1]) {
			area++; // 면적 증가
			visitCnt++; // 방문카운트 증가
			map[i][j][1] = true;
			stack.push(new int[] { i, j });
			dfs();
		}
	}
	
	// DFS
	public static void dfs() {
		final int I = stack.peek()[0];
		final int J = stack.peek()[1];
		visit(I+1, J);
		visit(I-1, J);
		visit(I, J+1);
		visit(I, J-1);
		stack.pop();
	}
}

/*
NHN 프리테스트 1차 기출

인근 영역 방문하고 영역별 크기 순서대로 출력

// ex1)

6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0

3
4 5 7


// ex2

4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0

0


// ex3
4
1 0 0 0
1 0 0 0
0 0 0 0
0 0 1 1

2
2 2

*/




