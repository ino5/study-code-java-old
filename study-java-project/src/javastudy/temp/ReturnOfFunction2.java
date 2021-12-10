package javastudy.temp;

public class ReturnOfFunction2 {
	
	public static void func(int[] arr) {
		arr[0] = arr[0] * arr[0];
	}
	
	public static void main(String[] args) {
		int[] number = {11, 11};
		func(number);
		System.out.println(number[0]);
	}
}
