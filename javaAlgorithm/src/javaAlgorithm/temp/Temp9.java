package javaalgorithm.temp;

import java.util.*;

public class Temp9 {
	public static void main(String[] args) {

		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.set(1, 2);
		list.remove(0);
		System.out.println(list.get(0));
		list.add(3);
	}
	
	public int[] test() {
		return new int[] {1, 2, 3};
	}
}

