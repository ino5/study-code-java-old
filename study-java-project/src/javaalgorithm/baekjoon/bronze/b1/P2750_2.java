/*
 * 원래 문제는 오름차순인데, 내림차순 comparator 만들어서 해보기
 */

package javaalgorithm.baekjoon.bronze.b1;

import java.util.*;

public class P2750_2 {
	static int N;
	static int[] inputs;
	static Integer[] inputsBox;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		inputsBox = Arrays.stream(inputs).boxed().toArray(Integer[]::new);
		
		
		// Comparator 익명클래스 이용
//		Arrays.sort(inputsBox, new Comparator<Integer>() {
//			public int compare(Integer a, Integer b) {
//				return b - a;
//			}
//		});
		
		// Comparator 클래스 이용
//		Arrays.sort(inputsBox, new Aes());
		Aes aes = new Aes();
		Arrays.sort(inputsBox, aes);
		
		Arrays.stream(inputsBox).forEach(num -> System.out.println(num));
		
		sc.close();
	}
	
	public static class Aes implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 - o2;
		}
		
	}
}
