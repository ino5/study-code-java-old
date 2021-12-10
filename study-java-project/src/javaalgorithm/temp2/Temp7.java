package javaalgorithm.temp2;

import java.util.Scanner;

public class Temp7 {
	public static void main(String[] args) {
		//입력
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자입력 > ");
		String strData = scan.nextLine();
		String[] strArrs = strData.split(" ");
		
		//처리(메서드화)
		
		for (int i = 0; i < strArrs.length - 1; i++) {
			for (int j = 0; j < strArrs.length - 1 - i; j++) {
				if (Integer.parseInt(strArrs[j]) > Integer.parseInt(strArrs[j + 1])) {
					String tmp = strArrs[j];
					strArrs[j] = strArrs[j + 1];
					strArrs[j + 1] = tmp;
				}
			}
		}
		
		//출력
		String result = String.join( " ", strArrs);
		System.out.println("정렬결과 > " + result);
	}
}
