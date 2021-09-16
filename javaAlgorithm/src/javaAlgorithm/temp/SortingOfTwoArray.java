package javaAlgorithm.temp;
/*
문제 : 정렬된 배열 nums1과 nums2가 주어지고, 각각의 크기는 m과 n이다.
정렬을 유지하면서 nums1배열부터 채워나가 nums2까지 확장해보자
- 병합된 m+n크기만큼의 공간은 있지 않다.
- nums1 배열에서 nums1과 nums2의 모든 요소를 작은 수부터 채워나가고 nums2에는 나머지 정렬을
유지하며 넣도록 하자.
- 추가 배열 할당 없이 문제를 해결해야 한다.
*/
import java.util.*;

public class SortingOfTwoArray {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] nums1 = {1, 3, 5, 7};
//		int[] nums2 = {2, 4, 8};
		int[] nums1 = {1, 2, 3, 7, 10};
		int[] nums2 = {5, 8, 9, 6, 4};
		sol.solution(nums1, nums2);
		for (int num : nums1) System.out.print(num + " ");
		System.out.println();
		for (int num : nums2) System.out.print(num + " ");
	}
	

}

class Solution {
	public void solution(int[] nums1, int[] nums2) {
		for (int j = 0; j < nums2.length; j++) {
			for (int i = 0; i < nums1.length; i++) {
				if (nums2[j] < nums1[i]) {
					int temp = nums2[j];
					nums2[j] = nums1[i];
					nums1[i] = temp;
				}
			}			
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
	}
}