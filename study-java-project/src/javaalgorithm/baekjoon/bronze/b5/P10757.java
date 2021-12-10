package javaalgorithm.baekjoon.bronze.b5;

import java.util.*;

public class P10757 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int length = (int) Math.max(a.length(), b.length());
        
        boolean isAdd = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= length; i++) {
            int x = 0;
            int y = 0;
            if (i < a.length()) x = a.charAt(i) - '0';
            if (i < b.length()) y = b.charAt(i) - '0';
            int z = x+y;
            if (isAdd) {
                z++;
                isAdd = false;
            }
            if (z >= 10) {
                z -=10;
                isAdd = true;
            }
            sb.insert(0, String.valueOf(z));
        }
        if (sb.charAt(0) == '0') sb.deleteCharAt(0);
        System.out.println(sb.toString());
        sc.close();
    }
}
