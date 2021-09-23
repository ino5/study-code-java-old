package javaAlgorithm.temp.string;

import java.util.Arrays;

public class FromStringTo {
	public static void main(String[] args) {
		long beforeTime;
		long afterTime;
		String ch = "abcdefghi";
		final int COUNT = 1000000;
		
		// split("") : 539ms
		beforeTime = System.currentTimeMillis();
		
		for (int i = 0; i < COUNT; i++) {
			String[] arr = ch.split("");
		}
		
		afterTime = System.currentTimeMillis();
		System.out.println(afterTime - beforeTime);

		// toCharArray() : 11ms
		beforeTime = System.currentTimeMillis();
		
		for(int i = 0; i < COUNT; i++) {
			char[] arr = ch.toCharArray();
		}
		
		afterTime = System.currentTimeMillis();
		System.out.println(afterTime - beforeTime);
		
	}
}
