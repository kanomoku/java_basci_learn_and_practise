package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1470_shuffle {
    public static void main(String[] args) {

        int[] arr = new int[]{2,5,1,3,4,7};
        int[] temp = shuffle(arr, 3);
        System.out.println(Arrays.toString(temp));
    }

    public static int[] shuffle(int[] nums, int n) {
        int p1 = 0;
        int p2 = n;
        int p = 0;
        int[] temp = new int[nums.length];
        while (p1 < n && p2 < nums.length) {
            temp[p++] = nums[p1++];
            temp[p++] = nums[p2++];
        }
//        while (p1 < n) {
//            temp[p++] = nums[p1++];
//        }
//        while (p2 < nums.length) {
//            temp[p++] = nums[p2++];
//        }
        return temp;
    }
}


