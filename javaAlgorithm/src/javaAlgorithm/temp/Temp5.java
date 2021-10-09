package javaalgorithm.temp;

public class Temp5 {
	public static void main(String[] args) {
		String s = "try hello world";
        String[] arr = s.split("");
        boolean isEven = true;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(" ")) {
                if (!isEven) {
                    arr[i] = arr[i].toLowerCase();
                    isEven = true;
                } else {
                    arr[i] = arr[i].toUpperCase();
                    isEven = false;
                }
            } else {
                isEven = true;
            }
        }
        String answer = "";
        for (String str : arr) {
            answer += str;
        }
        System.out.println(answer);
	}
}
