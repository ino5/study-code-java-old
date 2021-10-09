package javaalgorithm.temp;

public class Temp8 {
	public static void main(String[] args) {
        String[] strings = {"a", "abc", "bc", "ab"};
        int n = 0;
        for(int i = 0; i < strings.length; i++) {
            for(int j=i+1; j<strings.length; j++) {                
                 char[] arr1 = strings[i].toCharArray();
                 char[] arr2 = strings[j].toCharArray();
                if(arr1[n] > arr2[n]) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                else if(arr1[n] == arr2[n]) {
                    int length = (arr1.length < arr2.length ? arr1.length : arr2.length);
                    for(int k = 0; k < length; k++) {
                        if(arr1[k] > arr2[k]) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                            break;
                        }
                        else if(arr1[k] < arr2[k]) {
                            break;
                        }

                        if (k == length - 1) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                            System.out.println(strings[i] + " " + strings[j]);
                        }
                    }
                }
                else {continue;}
            }
        } 
	}
}
