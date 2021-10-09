package javaalgorithm.temp2;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Temp5 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(6);
		set.add(8);
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
