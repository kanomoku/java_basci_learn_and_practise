package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Num763_partitionLabels {
    public static void main(String[] args) {

        String a = "ababczbacadefegdehijhklij";
        List<Integer> temp = partitionLabels1(a);
        System.out.println(temp);
    }

    public static List<Integer> partitionLabels1(String S) {
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

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = Math.max(last[S.charAt(i) - 'a'], i);//数组取最大值的思路
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(last[S.charAt(i) - 'a'], end);// 根据条件的选取右边界&&数组取最大值的思路
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;//左边界根据右边的值来跳转
            }
        }
        return list;
    }

}


