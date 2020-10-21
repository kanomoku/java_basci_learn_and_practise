package leetcode;

import java.util.*;

public class Num1480_RunningSum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4};
        int[] temp = runningSun2(arr);
        System.out.println(Arrays.toString(temp));
    }

    public static  int[] runningSum(int[] nums) {
       int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <=i ; j++) {
                arr[i] +=nums[j];
            }
        }
        return arr;
    }

    public static int[] runningSum1(int[] nums){
        for (int i = 1; i <nums.length ; i++) {
            nums[i]+=nums[i-1];
        }
        return nums;
    }
    public static int[] runningSun2(int[] nums){
        int d = 1;
        while (d<nums.length){
            nums[d]+=nums[d-1];
            d++;
        }
        return nums;
    }
}


