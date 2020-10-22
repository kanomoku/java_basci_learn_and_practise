package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1512_NumIdenticalPairs {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 1, 1, 3};
        int count = numIdenticalPairs1(arr);
        System.out.println(count);
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int numIdenticalPairs1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            count += v * (v - 1) / 2;
        }
        return count;
    }
}


