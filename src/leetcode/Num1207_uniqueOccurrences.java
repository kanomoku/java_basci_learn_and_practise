package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1207_uniqueOccurrences {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
//        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        boolean temp = uniqueOccurrences1(arr);
        System.out.println(temp);
    }


    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        for (Integer value : map.values()) {
            int count = 0;
            for (Integer value1 : map.values()) {
                if (value == value1) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean uniqueOccurrences1(int[] arr) {
        // 注意数组长度限制
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[1000+arr[i]]=count[1000+arr[i]]+1; // 和 763. 划分字母区间 取出来字母下标存起来一个思路
        }

        System.out.println(Arrays.toString(count));
        //  再来个选择排序
        for (int i = 0; i <count.length ; i++) {
            for (int j = i+1; j <count.length ; j++) {
                if (count[i]!=0 && count[i]==count[j]){
                    return false;
                }
            }
        }
        return true;
    }
}


