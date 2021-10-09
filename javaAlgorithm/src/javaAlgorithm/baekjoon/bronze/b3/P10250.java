package javaalgorithm.baekjoon.bronze.b3;
import java.util.*;
public class P10250 {
	static int T,H,W,N;
	static int backNum;
	static int frontNum;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while (T-- > 0) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			num = 0;
			
			// 뒷호수번호 구하기
			backNum = (N - 1) / H + 1; 
			
			// 앞호수번호(층) 구하기
			frontNum = (N - 1) % H + 1;
					
			// 출력
			num = frontNum * 100 + backNum;
			System.out.println(num);
		}
		sc.close();
	}
}
