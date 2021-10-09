package javaalgorithm.temp;

public class Temp15 {
	public static void main(String[] args) {
		char[] arr = {'A', 'B', 'C'};
		int[] arr2 = {5, 1, 3};
	}
	class SolutionOfTemp15 {
		public int[] solution(char[] arr, int[] arr2) {
			MyInteger[] myArr = new MyInteger[arr.length];
			for (int i = 0; i < myArr.length; i++) {
				myArr[i].id = arr[i];
				myArr[i].num = arr2[i];
			}
			
			int[] answer = new int[myArr.length];
			
			return answer;
		}
		
		class MyInteger {
			char id;
			int num;
		}
	}
}
