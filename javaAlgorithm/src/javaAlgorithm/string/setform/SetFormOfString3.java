package javaalgorithm.string.setform;

import java.util.Arrays;

public class SetFormOfString3 {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		// String[] -> Arr[] : stream 이용
		s = s.substring(2, s.length() - 2);
		String[] arrS = s.split("(\\}\\,\\{)");
		int[][] sets = new int[arrS.length][];
		for (int i = 0; i < sets.length; i++) {
			String[] tempArr = arrS[i].split(",");
			sets[i] = Arrays.stream(tempArr).mapToInt(Integer::parseInt).toArray();
		}
		
		
		// 출력
		for (int[] val : sets) {
			for (int val2 : val) {
				System.out.print(val2 + " ");
			}
			System.out.println();
		}
	}
}
