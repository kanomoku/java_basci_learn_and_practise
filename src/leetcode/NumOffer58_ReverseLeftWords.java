package leetcode;

import java.util.Arrays;

public class NumOffer58_ReverseLeftWords {
    public static void main(String[] args) {

        String str = "abcdefg";
        String string = reverseLeftWords2(str,2);
        System.out.println(string);
    }

    public static String reverseLeftWords(String s, int n) {
        String temp = s.substring(0,n);
        return s.substring(n) + temp;
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <s.length() ; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i <n ; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 非常巧妙
     */
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <s.length()+n ; i++) {
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }
}


