package javaalgorithm.temp;
import java.util.*;
public class Temp17 {
	public static void main(String[] args) {
		int[][] scores = {{50, 90}, {50, 87}};
        String answer = "";
        int[] num = new int[scores.length];
        int[] num2 = new int[scores.length];
        double[] num3 = new double[scores.length];
        int fail = 0;
        int sum = 0;
        double avg = 0;
        for(int i=0; i<scores.length; i++){
            for(int j=0; j<scores[i].length; j++){
                num[j] = scores[j][i];
                num2[j] = scores[j][i];
            }            
            Arrays.sort(num2);
            if(scores[i][i] == num2[0] || scores[i][i] == num2[num2.length-1]){
                for(int k = 0; k <scores.length; k++){
                    if(scores[k][i] == scores[i][i] && k != i) {
                        for(int j : num2){
                            sum += j;
                        }
                        avg = sum / num2.length;
                        num3[i] = avg;    
                        break;
                    } else if (k == scores.length - 1) {
                        fail = num[i];
                        for(int j : num2){
                            sum += j;
                        }
                        sum -= fail;
                        avg = sum / (num2.length-1);
                        num3[i] = avg;                    	
                    }
                }   
            }
            else {
                for(int j : num2){
                    sum += j;
                }
                avg = sum / num2.length;
                num3[i] = avg;
            }
            System.out.println(num3[i]);
        }
        
        for(int i = 0; i < num3.length; i++) {
            if(num3[i] >= 90){
                answer += "A";
            }
            else if(80 <= num3[i] && num3[i] < 90){
                answer += "B";
            }
            else if(70 <= num3[i] && num3[i] < 80){
                answer += "C";
            }
            else if(50 <= num3[i] && num3[i] < 70){
                answer += "D";
            }
            else {
                answer += "F";
            }
        }
        
        System.out.println(answer);
	}
}
