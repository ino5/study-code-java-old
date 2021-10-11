// 나이트 무브

package javaalgorithm.baekjoon.silver.s2;

import java.util.*;

public class P7562 {
	static int I;
	static int T;
	static int[] starting = new int[2]; // i, j
	static int[] ending = new int[2]; // i, j
	static int cntMove;
	static int[][] map;
	static Queue<int[]> bfsList = new LinkedList<>(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- > 0) {
			I = sc.nextInt();
			starting[0] = sc.nextInt();
			starting[1] = sc.nextInt();
			ending[0] = sc.nextInt();
			ending[1] = sc.nextInt();
			
			// case: 시작점과 끝점이 같은 경우
			if (starting[0] == ending[0] && starting[1] == ending[1]) {
				System.out.println(0);
				continue;
			}
			
			// 초기화 (방문여부, 카운트)
			cntMove = 1;
			map = new int[I][I];
			bfsList.clear();
			
			// bfs 
			bfsList.offer(starting); // 시작점 리스트에 넣기
			bfs();
			
			System.out.println(map[ending[0]][ending[1]]);
		}
		
		sc.close();
	}
	
	public static void visit(int i, int j) {
		if (i < 0 || i >= I) return;
		if (j < 0 || j >= I) return;
		if (i == starting[0] && j == starting[1]) return; // 시작점은 항상 0이어야 하므로
		if (map[i][j] == 0) {
			map[i][j] = cntMove;
			bfsList.offer(new int[] {i, j});			
		}
	}
	
	public static void bfs() {
		int[] node = bfsList.peek();
		int _i = node[0];
		int _j = node[1];
		
		// 이웃에 대한 무브 수
		cntMove = map[_i][_j] + 1;
		
		// 이웃 추가 로직
		visit(_i+2, _j+1);
		visit(_i+1, _j+2);
		visit(_i-1, _j+2);
		visit(_i-2, _j+1);
		visit(_i-2, _j-1);
		visit(_i-1, _j-2);
		visit(_i+1, _j-2);
		visit(_i+2, _j-1);
		
		// 제거
		bfsList.poll();
		
		// 반복
		if (map[ending[0]][ending[1]] == 0) {
			bfs();
		}
	}
	
}