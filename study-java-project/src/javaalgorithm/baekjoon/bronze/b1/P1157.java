package javaalgorithm.baekjoon.bronze.b1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1157 {
	static int maxNum = 0;
	static char maxCh = 0;
	static boolean isMany = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// 처음 등록하는 문자
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			}
			// 이미 등록되어 있는 경우 개수 더하기
			else {
				map.replace(ch, map.get(ch) + 1);
			}
			
			// 제일 많은지 체크
			if (map.get(ch) > maxNum) {
				maxNum = map.get(ch);
				maxCh = ch;
				isMany = false;
			}
			// 만약 중복되는 개수이면서 다른 문자가 있는 경우
			else if (map.get(ch) == maxNum && ch != maxCh) {
				isMany = true;
			}
		}
		
		// 복수인 경우 ? 출력
		if (isMany) {
			System.out.println("?");
		}
		// 복수가 아닌 경우 대문자 출력
		else if (!isMany) {
			System.out.println(maxCh);
		}
			
		sc.close();
	}
}
