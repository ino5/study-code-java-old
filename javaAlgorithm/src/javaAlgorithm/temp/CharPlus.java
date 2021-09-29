package javaAlgorithm.temp;

public class CharPlus {
	public static void main(String[] args) {
		String str = "abcdefghi";
		String result = "";
		result += str.charAt(0);
		System.out.println(result);
		
		result="";
		result += str.charAt(0) + str.charAt(1);
		System.out.println(result);

		result="";
		result = result + str.charAt(0) + str.charAt(1);
		System.out.println(result);		

		result="";
		result = str.charAt(0) + str.charAt(1) + result;
		System.out.println(result);		
	}
}
