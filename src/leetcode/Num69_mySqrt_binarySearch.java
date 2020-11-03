package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num69_mySqrt_binarySearch {
    public static void main(String[] args) {

//        int temp = mySqrt3(2147395599);
        int temp = mySqrt3(2147395599);
        System.out.println(temp);
    }


    /**
     *
     */
    public static int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                if ((long) (mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 无为而为的取最优解
     */
    public static int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int mySqrt3(int x) {
        int res = -1;
        int left = 0;
        int right = x;
        while (left <= right) {// 没有等于号的时候，输入0的时候会报错
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}


