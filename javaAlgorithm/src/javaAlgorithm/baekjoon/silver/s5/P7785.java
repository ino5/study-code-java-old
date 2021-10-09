package javaalgorithm.baekjoon.silver.s5;

import java.util.*;

public class P7785 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int LineNum = sc.nextInt();
		Map<String, Boolean> map = new HashMap<>();
		for (int LineIdx = 0; LineIdx < LineNum; LineIdx++) {
			String name = sc.next();
			String state = sc.next();
			boolean isEntered = state.equals("enter") ? true : false;
	
			if (isEntered) {
				map.put(name, true);
			} else {
				map.remove(name);
			}
		}
		Set<String> set = map.keySet();
		List<String> answers = new ArrayList<>();
		for (String val : set) {
			answers.add(val);
		}
		Collections.sort(answers, Collections.reverseOrder());
		
		// print
		for (String val : answers) {
			System.out.println(val);
		}
		
		sc.close();
	}
}
