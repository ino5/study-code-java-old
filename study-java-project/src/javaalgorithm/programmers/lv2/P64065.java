package javaalgorithm.programmers.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 튜플
public class P64065 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s ="{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] answer = sol.solution(s);
		for (int val : answer) {
			System.out.print(val + " ");
		}
	}
}

class Solution {
	static int[] answer;
	static int sLength;
	static int[][] arrS; 
	public int[] solution(String s) {
		// s 쉼표 갯수 이용하여 길이 찾기
		sLength = findSLength(s);
		
		// s의 원소 배열 arrS 만들기
		arrS = new int[sLength][];
		makeArrS(s);
		
		// arrS에서 한개씩 꺼내면서 숫자 더하기
		answer = new int[sLength];
		add(0);
		
		return answer;
	}
	
	// arrS의 원소 갯수 알아내기
	public int findSLength(String s) {
		int cnt = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',' && s.charAt(i-1) == '}') {
				cnt++;
			}
		}
		return cnt;
	}	
	
	// arrS의 하위 배열의 원소 갯수 알아내기
	public int findALength(String s) {
		int cnt = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				cnt++;
			}
		}
		return cnt;
	}
	
	// arrS와 arrS의 하위 배열들 만들기
	public void makeArrS(String s) {	
		int arrSIdx = 0;
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{') {
				int endIdx = s.indexOf('}', i);
				String subStr = s.substring(i+1, endIdx);
				
				// 배열 a에 요소들 넣기 
				inputArrA(arrSIdx, subStr);
				arrSIdx++;
				i = endIdx;
			}
		}	
	}
	
	// arrS의 하위배열 만들어서 순서에 맞게 arrS에 넣기
	public void inputArrA(int arrSIdx, String subStr) {
		int arrALength = findALength(subStr);
		int[] arrA = new int[arrALength];
		StringTokenizer st = new StringTokenizer(subStr, ",");
		int idx = 0;
		while (st.hasMoreTokens()) {
			arrA[idx++] = Integer.parseInt(st.nextToken());
		}
		arrS[arrALength-1] = arrA;
	}
	
	// answer 배열에 n번째 값 넣기
	public void add(int n) {
		if (n == 0) {
			answer[0] = arrS[0][0];
		} else {
			answer[n] = minus(arrS[n-1], arrS[n]);
		}
		
		if (n + 1 < answer.length) {
			add(n+1);
		}
	}
	
	// 두 배열 비교해서 한 배열에 없는 값 찾기
	public int minus(int[] arr1, int[] arr2) {
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], true);
		}
		
		for (int i = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i])) {
				return arr2[i];
			}
		}
		throw new IllegalArgumentException();
	}
}
