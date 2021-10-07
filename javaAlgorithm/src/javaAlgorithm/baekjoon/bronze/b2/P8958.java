package javaAlgorithm.baekjoon.bronze.b2;

import java.util.*;
import java.io.*;

public class P8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스마다
		for (int TIdx = 0; TIdx < T; TIdx++) {
			String str = br.readLine();
			int sum = 0;
			int point = 1;
			
			// 문제마다 점수 계산
			for (int strIdx = 0; strIdx < str.length(); strIdx++) {
				char current = str.charAt(strIdx);
				if (current == 'O') {
					sum += point++;
				} else {
					point = 1;
				}
			}
			
			bw.write(sum + "\n");
		}
		br.close();
		bw.close();	
	}
}
