package javaalgorithm.baekjoon.silver.s3;

import java.util.*;

public class P3085 {
	
	static int n;
	static char[][] arr;
	static int answer = 0;
	public static void main(String[] args) {
		
		// input
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new char[n][n];
		for (int nIdx = 0; nIdx < n; nIdx++) {
			String str = sc.next();
			for (int strIdx = 0; strIdx < str.length(); strIdx++) {
				arr[nIdx][strIdx] = str.charAt(strIdx);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 5; k++) {
					if (k == 0) { // 바꾸지 않을 때
						test(i, j);
					} else if (k == 1) { // 위쪽과 바꿀 때
						if (i == 0) continue;
						change(i, j, i-1, j);
						test(i, j);
						change(i, j, i-1, j);
					} else if (k == 2) { // 오른쪽과 바꿀 때
						if (j == n - 1) continue;
						change(i, j, i, j+1);
						test(i, j);
						change(i, j, i, j+1);
					} else if (k == 3) { // 아래쪽과 바꿀 때
						if (i == n - 1) continue;
						change(i, j, i+1, j);
						test(i, j);
						change(i, j, i+1, j);
					} else if (k == 4) { // 왼쪽과 바꿀 때
						if (j == 0) continue;
						change(i, j, i, j-1);
						test(i, j);
						change(i, j, i, j-1);
					}
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	// 해당 칸 포함하는 가장 긴 열 찾기
	public static void test(int i, int j) {
		int startI = i;
		int endI = i;
		// 행에 대해서 왼쪽으로 확장
		while(startI > 0) {
			if (arr[startI - 1][j] == arr[i][j]) {
				startI--;
			} else {
				break;
			}
		}
		
		// 행에 대해서 오른쪽으로 확장
		while(endI < n - 1) {
			if (arr[endI + 1][j] == arr[i][j]) {
				endI++;
			} else {
				break;
			}
		}
		
		int lengthI = endI - startI + 1;
		if (lengthI > answer) answer = lengthI;
		
		
	// 열에 대해서 시행
		int startJ = j;
		int endJ = j;
		// 열에 대해서 위쪽으로 확장
		while(startJ > 0) {
			if (arr[i][startJ - 1] == arr[i][j]) {
				startJ--;
			} else {
				break;
			}
		}
		
		// 열에 대해서 아래쪽으로 확장
		while(endJ < n - 1) {
			if (arr[i][endJ + 1] == arr[i][j]) {
				endJ++;
			} else {
				break;
			}
		}
		
		int lengthJ = endJ - startJ + 1;
		if (lengthJ > answer) answer = lengthJ;
	}
	
	public static void change (int i1, int j1, int i2, int j2) {
		char temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
	}
}
