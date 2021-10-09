package javaalgorithm.baekjoon.gold.g5;

import java.util.Scanner;

// Queen NxN
public class P9663 {
	static int n;
	static int[][] qList;
	static int[] qListPtr;
	static boolean[][] canPlaced;
	static int[] position;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		qList = new int[n+1][n+1];
		qListPtr = new int[n+1];
		
		canPlaced = new boolean[n+1][n+1];
		
		// position initialization
		position = new int[n+1];
		
		run(1);
		
		System.out.println(answer);
		
		sc.close();
	}
	
	
	// n번째 라인 실행하기
	public static void run(int lineNum) {
		
		// 해당 라인 초기화
		for (int i = 1; i <= n; i++) {
			canPlaced[lineNum][i] = true;
			position[lineNum] = 0;
		}
		
		// canPlaced 설정하기. 앞 선 라인의 퀸들 고려해서.
		for (int i = 1; i < lineNum; i++) {
			int diff = lineNum - i;
			canPlaced[lineNum][position[i]] = false; // 직선
			if (position[i] - diff > 0) {
				canPlaced[lineNum][position[i] - diff] = false; // 왼쪽 대각선
			}
			if (position[i] + diff <= n) {
				canPlaced[lineNum][position[i] + diff] = false; // 오른쪽 대각선
			}
		}
		
		// 둘 수 있는 위치 큐에 담기
		for (int i = 1; i <= n; i++) {
			if (canPlaced[lineNum][i]) {
				qList[lineNum][++qListPtr[lineNum]] = i;
			}
		}
		
		// 큐에서 하나씩 꺼내서 로직 실행
		while (qListPtr[lineNum] != 0) {
			// 퀸 두기
			position[lineNum] = qList[lineNum][qListPtr[lineNum]--];
			
			// 마지막 줄이 아니면 다음 줄 실행하기
			if (lineNum != n) {
				run(lineNum + 1);
			} else if (lineNum == n) { // 마지막 줄이면 계산하기
				++answer;
			}
		}	
	}
}
		