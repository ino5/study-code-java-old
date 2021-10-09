package javaalgorithm.programmers.level1_12915;

public class Temp9 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		sol.solution(strings, n);
	}
	
}

class Solution {
    public String[] solution(String[] strings, int n) {
        quickSort(strings, 0, strings.length - 1, n);
        return strings;
    }    
    
    public void quickSort(String[] strings, int left, int right, int n) {
    	if (left < right) {
    		int q = partition(strings, left, right, n);
    		quickSort(strings, left, q-1, n);
    		quickSort(strings, q+1, right, n);
    	}
    }
    
    public int partition(String[] strings, int left, int right, int n) {
    	String pivot, temp;
    	int low, high;
    	low = left;
    	high = right + 1;
    	pivot = strings[left];

    	
    	do {
    		do {
    			low++;
    		} while (low <= right && compare(strings[low], pivot, n) == -1);
    		
    		do {
    			high--;
    		} while (high >= left && compare(strings[high], pivot, n) == 1);
    		
    		
    		if (low < high) {
    			swap(strings, low, high);
    		}
    	} while (low < high);
    	swap(strings, left, high);
    	return high;
    }
    
    public int compare(String i, String j, int n) {
        if (i.charAt(n) > j.charAt(n)) {
            return 1;
        } else if (i.charAt(n) < j.charAt(n)) {
            return -1;
        } else if (i.charAt(n) == j.charAt(n)) {
            for (int k = 0; k < i.length(); k++) {
                if (k == j.length()) {
                    return 1;
                } else if (i.charAt(k) > j.charAt(k)) {
                    return 1;
                } else if (i.charAt(k) < j.charAt(k)) {
                    return -1;
                } else if (i.charAt(k) == j.charAt(k)) {
                    continue;
                }
            }
        }
        return -2;
    }    
    
    public void swap(String[] strings, int i, int j) {
    String temp = strings[i];
    strings[i] = strings[j];
    strings[j] = temp;
    }
}