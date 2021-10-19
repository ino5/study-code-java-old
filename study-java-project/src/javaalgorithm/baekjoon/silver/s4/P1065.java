/*
한수

문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */

package javaalgorithm.baekjoon.silver.s4;

import java.util.*;

public class P1065 {
	static int N;
	static int length;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int x = 1; x <= N; x++) {
			int[] arr = new int[String.valueOf(x).length()];
			int d = 0;
			
			// 자릿수 하나씩 뽑아서 확인
			int xx = x;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = xx % 10;
				xx /= 10;
				
				if (i == 0) {
					
				} else if (i == 1) {
					d = arr[1] - arr[0];
				} else if (i > 1) {
					if (arr[i] - arr[i - 1] != d) {
						break;
					}
				}
				
				if (i == arr.length - 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}



/*
예제 입력 1 
110
예제 출력 1 
99
예제 입력 2 
1
예제 출력 2 
1
예제 입력 3 
210
예제 출력 3 
105
예제 입력 4 
1000
예제 출력 4 
144
*/