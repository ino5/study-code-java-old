package javaAlgorithm.temp;
/*
[파스칼의 삼각형]
파스칼의 삼각형은 수학의 이항계수를 삼각형의 형태로 숫자를 배열한 구성을 의미한다.
파스칼의 삼각형은 처음 두 줄을 제외하고 새로 만들어지는 줄의 숫자는 윗줄의 왼쪽수와 더해서 만들어진다.
       1
     1   1
   1   2   1
 1   3   3   1

문제: 입력으로 몇 줄을 만들것인지 받아서 파스칼의 삼각형을 이차원 배열의 형태로 구성하라.
ex. target=3 output = [[1],[1,1],[1,2,1]]
 */
public class Pascal {
	public static void main(String[] args) {
		int target = 10;
		int[][] arr = new int[target][];
		for (int i = 0; i < target; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					arr[i][j] = 1;
					continue;
				}
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		for (int[] arr2 : arr) {
			for (int num : arr2) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
