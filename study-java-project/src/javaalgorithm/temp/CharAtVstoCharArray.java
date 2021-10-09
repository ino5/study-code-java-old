package javaalgorithm.temp;

public class CharAtVstoCharArray {

	public static void main(String[] args) {
		final int COUNT = 50000;
		String str = "abcdefghijklm";
		String answer = "";
		long startTime = 0;
		long endTime = 0;
		// 50000 : 60921
		answer = "";
		startTime = System.currentTimeMillis();
		for (int count = 0; count < COUNT; count++) {
			for (int i = 0; i < str.length(); i++) {
				answer += str.charAt(i);
			}			
		}
		endTime = System.currentTimeMillis();		
		System.out.println(endTime - startTime);

		// 50000 : 62200
//		answer = "";
//		startTime = System.currentTimeMillis();
//		for (int count = 0; count < COUNT; count++) {
//			char[] arr = str.toCharArray();
//			for (int i = 0; i < arr.length; i++) {
//				answer += arr[i];
//			}			
//		}
//		endTime = System.currentTimeMillis();		
//		System.out.println(endTime - startTime);		
	}
	
}
