package javaAlgorithm.baekjoon.gold.g5;

import java.util.Scanner;

public class P1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = sc.nextInt();
		long[][] inputVal = new long[testNum][2];
		for (int i = 0; i < testNum; i++) {
			inputVal[i][0] = sc.nextInt();
			inputVal[i][1] = sc.nextInt();
		}
		
		// solve
		for (int testIdx = 0; testIdx < testNum; testIdx++) {
			long dst = inputVal[testIdx][1] - inputVal[testIdx][0];
			if (dst == 0) {
				System.out.println(0);
				continue;
			}
			else if (dst == 1) {
				System.out.println(1);
				continue;
			}
			
			long answer = 0;
			long n = 1;
			long cnt = 0;
			while (dst >= sum(n)) {
				n++;
			}
			n--;
			
			long sumVal = sum(n);
			while (dst > sumVal + n * cnt) {
				cnt++;
			}
			
			answer = (n - 1) * 2 + 1 + cnt;
			
			System.out.println(answer);
		}
		
		sc.close();
	}
	
	// 1 + 2 ... + (n-1) + n + (n-1) + ... + 2 + 1
	public static long sum(long n) {
		long result = 0;
		long m = n-1;
		result = (m*m + m) + n;
		return result;
	}
}

	/*
	1 1 = 2
	1 1 1 = 3
	
	1 2 1 = 4
	1 2 1 1 = 5
	1 2 2 1 = 6
	1 2 2 1 1 = 7
	1 2 2 2 1 = 8
	
	1 2 3 2 1 = 9
	1 2 3 2 1 1 = 10 
	1 2 3 2 2 1 = 11
	1 2 3 3 2 1 = 12
	1 2 3 3 2 1 1 = 13
	1 2 3 3 2 2 1 = 14
	1 2 3 3 3 2 1 = 15
	sum(3) = 9
	sum(3) + 3 * 1 = 12
	sum(3) + 3 * 2 = 15
	
	1 2 3 4 3 2 1 = 16
	1 2 3 4 3 2 1 1 = 17
	1 2 3 4 3 2 2 1 = 18
	1 2 3 4 3 3 2 1 = 19
	1 2 3 4 4 3 2 1 = 20
	
	1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
	1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
	1 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
	1 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1
	
	1 2 3 ... n n-1 ... 3 2 1 = sum(n)
	  
	*/

	/* 처음 풀 때 사고 과정
	 일단 2부터 20까지 일일히 다 적어봤다.
	 거기서 규칙을 발견했다.
	 주어진 숫자를 x라 하고 답을 ans라 할 때,
	 일단 x가 sum(n)보다 작다면  sum(n)에서 항의 갯수 <= ans < sum(n+1)에서 항의 갯수 이다.
	 [sum(n)에서의 항의 갯수: 1+2+...+n+...+2+1 => 2(n-1) + 1]
	 
	 그다음 발견한 중요한 규칙이 뭐냐면
	 x가 sum(n) + cnt * n 보다 크고, sum(n) + cnt * (n+1) 보다 작거나 같으면
	 ans = sum(n)에서의 항의 갯수 + (n+1)이다.
	 
	 왜냐면
	 sum(n) + cnt * n인 시점에서 1이 더커지려면 항에 1이 더 더해져야만 한다.
	 1 + 2+ ... + n + n + ... + n + (n-1) + ... + 2 + 1 인 시점이기 때문이다.
	 하지만 여기서 sum(n) + cnt * (n+1)이 되기 전까지는 항이 더 더해지지는 않는다.
	 왜냐면 제일 끝에서 전의 항에서부터 차례대로 1씩 더해질 수 있기 때문이다.
	 ex) ... + 3 + 2 + 1 + 1 => ... + 3 + 2 + 2 + 1 => ... + 3 + 3 + 2 + 1 
	 */