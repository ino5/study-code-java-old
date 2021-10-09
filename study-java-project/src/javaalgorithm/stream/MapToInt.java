package javaalgorithm.stream;

import java.util.*;

public class MapToInt {
	public static void main(String[] args) {
		String[] arr = {"10", "20", "30"};
		int[] answer = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(answer));
	}
}
