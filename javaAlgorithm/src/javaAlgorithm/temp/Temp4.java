package javaAlgorithm.temp;

public class Temp4 {
	public static void main(String[] args) {
		long n = 12300;
        String n2 = String.valueOf(n);
        String[] num = n2.split("");
        String number = "";
        for(int i = num.length-1; i >= 0; i--) {
            number += num[i];
        }
        long num3 = Long.parseLong(number);
//        int[] answer = Stream.of(String.valueOf(num3).split("")).mapToInt(Integer::parseInt).toArray();
	}
}
