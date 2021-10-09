package javaalgorithm.temp;


public class Temp10 {
	public static void main(String[] args) {
		final int MAX = 9;
		final int MIN = 1;
		int num = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
		if (num % 2 == 1) {
			System.out.println(num + ": order");
		} else if (num % 2 == 0) {
			System.out.println(num + ": sleep");
		}
	}
}
