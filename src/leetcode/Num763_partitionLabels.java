package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Num763_partitionLabels {
    public static void main(String[] args) {

        String a = "ababczbacadefegdehijhklij";
        List<Integer> temp = partitionLabels(a);
        System.out.println(temp);
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

}


