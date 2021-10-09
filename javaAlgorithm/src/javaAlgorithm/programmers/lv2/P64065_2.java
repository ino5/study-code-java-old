package javaalgorithm.programmers.lv2;

public class P64065_2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s ="{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] answer = sol.solution(s);
	}
}

class Solution2 {
	public int[] solution(String s) {
		String[] abc = s.split(",");
		for (String val : abc) {
			System.out.println(val);
		}
		return null;
	}
}