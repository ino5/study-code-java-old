package javaalgorithm.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp12 {
	
	public static void main(String[] args) {
		String[] arr = {"A", "B", "C"};
		List<String> list1 = new ArrayList<String>(Arrays.asList(arr));
		list1.set(0, "D");
		System.out.println(list1.get(0));
		list1.add("D");
	}
	
	
//	public static void main(String[] args) {
//		String[] arr = {"A", "B", "C"};
//		List<String> list1 = Arrays.asList(arr);
//		list1.set(0, "D");
//		System.out.println(list1.get(0));
//		list1.add("D");		
//	}
}
