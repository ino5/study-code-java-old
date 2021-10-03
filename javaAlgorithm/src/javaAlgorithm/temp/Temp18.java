package javaAlgorithm.temp;
import java.util.*;
public class Temp18 {
	public static void main(String[] args) {
//		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
//		String[] languages = {"PYTHON", "C++", "SQL"};
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"JAVA", "JAVASCRIPT"};
        int[] preference = {7, 5, 5};
        String answer = "";
        int score = 0;
        int mul = 0;
        int sum = 0;
        int[] sum2 = new int[table.length];
        for(int i=0; i < table.length; i++){
            sum = 0;
            String[] table2 = table[i].split(" ");
            for(int j=1; j < table2.length; j++){
                for(int k=0; k < languages.length; k++){
                    if(table2[j].equals(languages[k])){
                        score = table2.length-j;
                        mul = score * preference[k];
                        sum += mul;
                    }
                    else{continue;}
                }
            }
            sum2[i] = sum;
        }
        int[] sum3 = new int[table.length];
        for(int i = 0; i < sum2.length; i++) {
           sum3[i] = sum2[i];
//           System.out.println(sum2[i]);
        }
        int max = 0;
        String count = "";
        Arrays.sort(sum3);
        for(int j=0; j < sum2.length; j++) {
            if(sum3[sum3.length-1] == sum2[j]) {
               count += j;
            }
        }
        if(count.length() > 1) {
            String[] count2 = count.split("");
            int[] counts = new int[count2.length];
              for(int m=0; m<count2.length; m++) {
                  counts[m] = Integer.parseInt(count2[m]);
              }
             String[] answer2 = new String[counts.length];    
             for(int n = 0; n < counts.length; n++) {
                String[] table3 = table[counts[n]].split(" ");
                answer2[n] = table3[0];
             }
             Arrays.sort(answer2);
             answer = answer2[0];
         }
         else {
            int counts2 = Integer.parseInt(count);
            String[] table3 = table[counts2].split(" ");
            answer = table3[0];
         }
	}
}
