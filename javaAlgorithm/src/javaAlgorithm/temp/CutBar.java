package javaalgorithm.temp;

import java.util.Arrays;
import java.util.Scanner;

public class CutBar {
	public static void main(String[] args) {
		int[] arr = {5, 4, 4, 2, 2, 8};
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		System.out.println(n);
		while(true) {
			int min = Integer.MAX_VALUE;
			for (int num : arr) {
				if (num > 0 && num < min) {
					min = num;
				}
			}
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] -= min;
				if (arr[i] > 0) ++count;
			}
			if (count == 0) break;
			System.out.println(count);
		}
		scanner.close();
	}
	
	
// 문제 낸 강사님이 풀었다는 코드...
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//	      int n= scanner.nextInt();
//
//	      int [] m = new int [n];
//	      for(int i = 0; i < n; i++) 
//	         int inputNum = scanner.nextInt();
//	      
//	      Arrays.sort(m);
//	      
//	      int idx = 0;
//	      int value;
//	      out : do {
//	         System.out.println(n-idx);
//	         value = m[idx];
//	         try {while(value == m[++idx]);}   catch (Exception e) {break;}
//	         do {
//	            if(idx +1 == n)   break out;
//	            idx++;
//	         }while(value == m[idx]);
//	      }while(idx < n);		
//	}
}
