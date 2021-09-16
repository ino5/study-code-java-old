package javaAlgorithm.temp.Palindrome;

/*
문제: 문자열이 주어지면 해당 문자열이 회문인지 아닌지 확인하자.
문자열에서 회문으로 확인해야 하는 문자는 알파벳과 숫자이며, 알파벳은 대/소문자를 구분하지 않는다.
ex. 입력으로 'Abbc.bb.a'문자열이 주어진다면 true를 반환해야 한다.
알파벳과 숫자만 남기면 'Abbccbba'가 되며 대소문자를 구분하지 않기 때문에 'abbccbba'가 된다.
* 회문은 앞으로 읽나 거꾸로읽나 똑같이 읽히는 문장을 의미한다.
 */
public class Palindrome {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String str = "Abbc.bb.a";
		System.out.println(sol.solution(str));
	}
}

class Solution {
	public boolean solution(String str) {
		char[] arr = str.toCharArray();
		String strEnglish = "";
		String strEnglishReverse = "";
		for (int i = 0; i < str.length(); i++) {
			if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) {
				strEnglish += arr[i];
			}
		}
		
		for (int i = strEnglish.length() - 1; i >= 0; i--) {
			strEnglishReverse += strEnglish.charAt(i);
		}
		
		if (strEnglish.toLowerCase().equals(strEnglishReverse.toLowerCase())) {
			return true;
		}
		
		return false;
	}
}
