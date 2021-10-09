package javaalgorithm.string.setform;

public class SetFormOfString {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		// 내가 한 일반적인 방법
		s = s.substring(2, s.length() - 2);
		String[] sets = s.split("(\\}\\,\\{)");

		int[][] arr = new int[sets.length][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[(sets[i].length()/2+1)];
			String[] arr2 = sets[i].split(",");
			for (int j = 0; j < arr2.length; j++) {
				arr[i][j] = Integer.parseInt(arr2[j]);
			}
		}
		
		// 출력
		for (int[] val : arr) {
			for (int val2 : val) {
				System.out.print(val2 + " ");
			}
			System.out.println();
		}
	}
}
