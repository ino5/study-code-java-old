package javaalgorithm.temp;

public class Temp {
    public static int solution(int num) {
        if (num == 1) {
            return 0;
            }
        for (int i = 1; i <= 500; i++) {            
            num = doCollatz(num);
            System.out.println(num);
            if (num == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public static int doCollatz(int num) {
        if (num % 2 == 0) {
            num /= 2;
        } else if (num % 2 == 1) {
            num = 3 * num + 1;
        }
        return num;
    } 
    
    public static void main(String[] args) {
		System.out.println(solution(626331));
	}
}
