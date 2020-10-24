package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num26_removeDuplicates {
    public static void main(String[] args) {

        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int temp = removeDuplicates(arr);
        System.out.println(temp);
        for (int i = 0; i < temp; i++) {
            System.out.print(arr[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}


