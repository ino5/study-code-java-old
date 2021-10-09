package javaalgorithm.comparatorstudy;

import java.util.*;

public class main1 {
	public static void main(String[] args) {
		int[] arrOrigin = {10, 5, 3, 6, 7};
		Solution1 sol = new Solution1();
		int[] answer = sol.solution(arrOrigin);
		for (int num : answer) {
			System.out.print(num + " ");
		}
	}
}		

class Solution1 {
	public int[] solution(int[] arrOrigin) {
		Integer[] arr = new Integer[arrOrigin.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrOrigin[i];
		}
		Arrays.sort(arr, comparator);
		
		int[] answer = new int[arr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr[i];
		}
		return answer;
	}
	Comparator<Integer> comparator = new Comparator<Integer>() {
		public int compare(Integer a, Integer b) {
			if (a > b) return b - a;
			throw new IllegalArgumentException("No solution");
		}
	};		
}
