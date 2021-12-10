package javastudy.temp;

public class ReferenceType {
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {3, 4};
		
		int[] c = a;
		c = b;
		
		System.out.println(c[0]);
	}
}
