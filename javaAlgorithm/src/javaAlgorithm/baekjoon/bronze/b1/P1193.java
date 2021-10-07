package javaAlgorithm.baekjoon.bronze.b1;

import java.io.*;

public class P1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int X = Integer.parseInt(br.readLine());
		int level = 0;
		do {
			level++;
			
		} while (sum(level) < X);
		
		int k = X - sum(level - 1);
		if (level % 2 == 0) {
			bw.write(k + "/" + (level + 1 - k) + "\n");
		} else {
			bw.write((level + 1 - k) + "/" + k + "\n");
		}
		
				
		br.close();
		bw.close();
	}
	
	public static int sum(int n) {
		return n * (n+1) / 2;
	}
	
}

/*
 a1 = 1
 a2 = 1 + 2 = 3
 a3 = 1 + 2 + 3 = 6
 a4 = 1 + 2 + 3 + 4 = 10
 an = 1 + ... + n = n(n+1)/2
 
 2an = n(n+1)
 n+1  > root(2an) > n
 
 만약 a(n-1)보다 크면서 an 이하에 있다면, n층에 있는 것이다.
 
 */