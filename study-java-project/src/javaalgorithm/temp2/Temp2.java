package javaalgorithm.temp2;

import java.util.Iterator;
import java.util.TreeSet;

public class Temp2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(4);
		set.add(3);
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
