package javaAlgorithm.temp;

public class Temp14 {
	// 민희꺼 디버깅
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 0, 0, 0, 0, 0 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] num1 = new String[n];
		String[] num3 = new String[n];
		String[] answer = new String[n];
		for (int i = 0; i < arr1.length; i++) {
			num1[i] = Integer.toBinaryString(arr1[i]);
			char[] arr3 = num1[i].toCharArray();
			char[] arr4 = new char[n];
			if (arr3.length != n) {
				int num2 = n - num1[i].length();
				for (int k = 0; k <= num2 - 1; k++) {
					arr4[k] = '0';
				}
				num1[i] = "";
				for (int j = 0; j < arr4.length; j++) {
					if (arr4[j] == '0') num1[i] += arr4[j];					
				}
				for (int h = 0; h < arr3.length; h++) {
					num1[i] += arr3[h];
				}
			} else {
				continue;
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			num3[i] = Integer.toBinaryString(arr2[i]);
			char[] arr3 = num3[i].toCharArray();
			char[] arr4 = new char[n];
			if (arr3.length != n && num3[i].charAt(0) == '1') {
				int num2 = n - num3[i].length();
				for (int k = 0; k <= num2 - 1; k++) {
					arr4[k] = '0';
				}
				num3[i] = "";
				for (int j = 0; j < arr4.length; j++) {
					if (arr4[j] == '0') num3[i] += arr4[j];
				}
				for (int h = 0; h < arr3.length; h++) {
					num3[i] += arr3[h];
				}
			} else {
				continue;
			}
			
		}
		for (int i = 0; i < n; i++) {
			answer[i] = "";
			String num4 = num1[i];
			String num5 = num3[i];
			for (int j = 0; j < n; j++) {
				char num6 = num4.charAt(j);
				char num7 = num5.charAt(j);
				if (num6 == '0' && num7 == '0') {
					answer[i] += '0';
				} else {
					answer[i] += '1';
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < n; j++) {
				char as = answer[i].charAt(j);
				if (as == '0') {
					answer[i] += ' ';
				} else {
					answer[i] += '#';
				}
			}
			answer[i] = answer[i].substring(n);
		}
		for (String str : answer) {
			System.out.println(str);
			char[] arr = str.toCharArray();
		}
	}

}
