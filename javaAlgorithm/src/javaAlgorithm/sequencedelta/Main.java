package javaAlgorithm.sequencedelta;

/*  
 * 길이가 5인 배열이 주어진다. 각 배열의 요소 중 하나의 값만 -1이고 나머지 값은 0이상의 정수이다.
 * 배열의 요소들은 순서대로 적어도 등차수열 또는 등비수열을 이룬다. 단, 값이 -1인 요소는 미지수이다.
 * 미지수를 구하는 메소드를 작성하시오.;
 * 예제) 메소드에 인자로 {1, 2, ?, 4, 5} 이 주어질 때 3을 반환
 */


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		if (true) {
			int[] arr = {1, -1, 3, 4, 5};
			System.out.println(sol.solution(arr));
		}

		if (true) {
			int[] arr = {3, 6, 12, 24, -1};
			System.out.println(sol.solution(arr));
		}
		
		if (true) {
			int[] arr = {408, 1632, -1, 26112, 104448};
			System.out.println(sol.solution(arr));
		}		
		
		if (true) {
			int[] arr = {3, -1, 12, 24, 36};
			System.out.println(sol.solution(arr));
		}		
	}
}
class Solution {
	public int solution(int[] arr) {
		int indexOfQuestion = -1;
		int indexsOfLength = 4;
		int[] indexsOfSub = new int[indexsOfLength];
		int tempIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				indexOfQuestion = i;
			} else {
				indexsOfSub[tempIndex++] = i; 
			}
		}
		
		// 등차 수열인지 확인
		int d = d(arr, indexsOfSub, 0, 1);
		if (d == d(arr, indexsOfSub, 1, 2) && d == d(arr, indexsOfSub, 2, 3)) {
			if (indexOfQuestion == 0) {
				return arr[indexOfQuestion + 1] - d;
			} else {
				return arr[indexOfQuestion - 1] + d;
			}
		} else { // 등차 수열이 아닌 등비 수열일 때
			int r = r(arr, indexsOfSub, 0, 1);
			if (indexOfQuestion == 0) {
				return arr[indexOfQuestion + 1] / r;
			} else {
				return arr[indexOfQuestion - 1] * r;
			}
		}		
	}
	
	public int d(int[] arr, int[] indexsOfSub, int a, int b) {
		return (arr[indexsOfSub[b]] - arr[indexsOfSub[a]]) / (indexsOfSub[b] - indexsOfSub[a]); 
	}
	public int r(int[] arr, int[] indexsOfSub, int a, int b) {
		return (int) Math.pow((arr[indexsOfSub[b]] / arr[indexsOfSub[a]]), 1 / (double) (indexsOfSub[b] - indexsOfSub[a]));
	}	
}