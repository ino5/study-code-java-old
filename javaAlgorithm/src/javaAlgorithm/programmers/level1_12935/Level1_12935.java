package javaalgorithm.programmers.level1_12935;

import java.util.*;

public class Level1_12935 {
	public static void main(String[] args) {
		Solution solution = new Solution2();
		int[] arr = {4,3,2,1};
		for (int num : solution.solution(arr)) {
			System.out.println(num);
		}
		
	}
}

class Solution {
    public int[] solution(int[] arr) {
        
    	if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        
        int answerLength = arr.length - 1;
        boolean isCheckedMin = false;
        int[] answer = new int[answerLength];
        for (int i = 0; i < answerLength; i++) {
            if (arr[i] == min && !isCheckedMin) {
                isCheckedMin = true;
            }
            if (isCheckedMin) {
                answer[i] = arr[i+1];
            } else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}

class Solution2 extends Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            list.add(num);
        }
        list.remove((Integer)min);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}