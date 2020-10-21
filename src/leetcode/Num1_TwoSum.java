package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};
        int[] temp = twoSum2(arr, 9);
        System.out.println(Arrays.toString(temp));
    }


    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}


