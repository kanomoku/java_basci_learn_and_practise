package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num189_rotate {
    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 好的思路
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
                System.out.println(Arrays.toString(nums));
            }
        }

    }
}


