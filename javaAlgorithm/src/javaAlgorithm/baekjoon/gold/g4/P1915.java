package javaAlgorithm.baekjoon.gold.g4;

import java.util.*;
import java.io.*;

// 아직 못풀었다
public class P1915 {
	static String str;
	static StringTokenizer st;
	static boolean[][] map;
	static int length;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (str.charAt(j-1) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		// 해당 길이 정사각형 있는지 체크하고 없으면 길이 1줄이고 체크 반복
		length = Math.min(N, M);
		while (length > 0) {
			if (check()) {
				break;
			}
			length--;
		}
		
		// 정답 출력
		bw.write(((length+1) * (length+1)) + "\n");
		
		br.close();
		bw.close();
	}
	
	// 해당 길이의 정사각형 존재하는지 체크하는 함수
	public static boolean check() {
		for (int y = 1; y + length <= N; y++) {
			for (int x = 1; x + length <= M; x++) {
				if (seeAll(x, y)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 해당 좌표를 왼쪽 위 꼭지점으로 갖는 정사각형에 대해서 모든 칸이 모두 1인지 확인
	public static boolean seeAll (int x, int y) {

		if (!map[y][x]) return false;
		if (!map[y][x+length]) return false;
		if (!map[y+length][x]) return false;
		if (!map[y+length][x+length]) return false;
		
		for (int i = y+1; i < y+length; i++) {
			for (int j = x+1; j < x+length; j++) {
				if (!map[i][j]) return false;
			}
		}
		
		return true;
	}
}