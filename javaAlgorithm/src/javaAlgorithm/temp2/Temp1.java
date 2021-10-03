package javaAlgorithm.temp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Temp1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			while(true) {
				String str = br.readLine();
				System.out.println(str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
