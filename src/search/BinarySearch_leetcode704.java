package search;

import java.util.Arrays;

public class BinarySearch_leetcode704 {
    public static void main(String[] args) {

        int[] array = new int[]{-1, 0, 3, 5, 9, 12};
        int a = MySearch(array, 99);
        System.out.println(a);
    }

    public static int MySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { //这个等于号不能省，不然一个元素的情况会报错
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int basicBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }


}
