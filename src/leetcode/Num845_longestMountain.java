package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num845_longestMountain {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 4, 7, 3, 2, 5};
        int temp = longestMountain1(arr);
        System.out.println(temp);
    }


    public static int longestMountain(int[] A) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }
        int[] left = new int[len];
        left[0] = 0;
        for (int i = 1; i < len; i++) {
            if (A[i - 1] < A[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        int[] right = new int[len];
        left[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] > 0 && right[i] > 0) {
                max = left[i] + right[i] + 1 > max ? left[i] + right[i] + 1 : max;
            }
        }
        return max;
    }


    public static int longestMountain1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        System.out.println(left[0]);
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        System.out.println(right[n - 1]);
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    /**
     * 目前没看懂
     * @param A
     * @return
     */
    public int longestMountain2(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }

}


