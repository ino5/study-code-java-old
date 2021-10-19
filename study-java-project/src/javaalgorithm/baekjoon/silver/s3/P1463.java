/*
 * 1로 만들기
 */

package javaalgorithm.baekjoon.silver.s3;

import java.util.*;

public class P1463 {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		map.put(1, 0);
		map.put(2, 1);
		map.put(3, 1);
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for (int i = 1 ; i < x; i++) {
			count(i); 
		}
		
		System.out.println(count(x));
		
		sc.close();
	}
	
	public static int count(int num) {
		if (map.containsKey(num)) return map.get(num);
		else {
			int result = map.get(num-1);
			if (num % 3 == 0) {
				result = result > map.get(num / 3) ? map.get(num / 3) : result; 
			}
			if (num % 2 == 0) {
				result = result > map.get(num / 2) ? map.get(num / 2) : result;
			}
			result += 1;
			map.put(num, result);
			return map.get(num);
		}
	}
}
