package javaalgorithm.typeconversion;

import java.util.*;

public class IntegerToInt {
	public static void main(String[] args) {
		Integer a[] = {1, 2, 3, 4};
		int b[] = Arrays.stream(a).mapToInt(Integer::intValue).toArray();
	}
}
