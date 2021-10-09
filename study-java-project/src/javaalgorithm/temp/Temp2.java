package javaalgorithm.temp;

import java.util.Arrays;

public class Temp2 {
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
        Arrays.sort(arr);
        for (int num : arr) {
        	System.out.println(num);
        }
        
        int[] answer = new int[arr.length - 1];
        for (int i = 0; i < answer.length - 1; i++) {
        	System.out.println(arr[i+1]);
            answer[i] = arr[i+1];
        }
        for (int num : answer) {
        	System.out.println(num);
        }
	}
}
