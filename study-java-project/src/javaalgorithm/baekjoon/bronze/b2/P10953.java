package javaalgorithm.baekjoon.bronze.b2;

import java.util.*;
import java.io.*;

public class P10953 {
	static int T;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(),",");
			while (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				System.out.println(a+b);
			}		
		}

		bw.close();
		br.close();
	}
}
