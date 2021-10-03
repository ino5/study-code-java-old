package javaAlgorithm.string;

public class StringEqualEx {
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		String c = "a";
		c += "bc";
		System.out.println(a==b);
		System.out.println(a==c);
	}
}
