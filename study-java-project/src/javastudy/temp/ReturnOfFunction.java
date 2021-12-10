package javastudy.temp;

public class ReturnOfFunction {
	
	public static int func(int n) {
		int result = n * n;
		return result;
	}
	
	public static void main(String[] args) {
		int number = 11;
		int answer = func(number);
		System.out.println(answer);
	}
}
