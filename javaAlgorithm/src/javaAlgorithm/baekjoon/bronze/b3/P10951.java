package javaalgorithm.baekjoon.bronze.b3;

import java.io.*;
import java.util.*;

public class P10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		String line = "";
		
		// insert
		while( (line = br.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = a + b;
			list.add(c);
		}
		
		// print
		for (Integer val : list) {
			bw.write(val + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
