package javaAlgorithm.baekjoon.bronze.b1;

import java.util.*;

public class P4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		double[] answers = new double[caseNum];
		
		for (int caseIdx = 0; caseIdx < caseNum; caseIdx++) {
			int pplNum = sc.nextInt(); // people number
			int[] scores = new int[pplNum];
			double sum = 0;
			double avg = 0;
			// insert scores
			for (int pplIdx = 0; pplIdx < pplNum; pplIdx++) {
				scores[pplIdx] = sc.nextInt();
				sum += scores[pplIdx];
			}
			avg = sum / pplNum;
			
			int answerCnt = 0;
			for (int i = 0; i < pplNum; i++) {
				if (scores[i] > avg) {
					answerCnt++;
				}
			}
			
			answers[caseIdx] = 100.0 * answerCnt / pplNum;
		}
		
		// print answer
		for (double val : answers) {
			System.out.println(String.format("%.3f", val) + "%");
		}
		sc.close();
	}
}
