package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num69_mySqrt_binarySearch {
    public static void main(String[] args) {

        int temp = mySqrt1(2147395599);
        System.out.println(temp);
    }


    /**
     * 浪费性能，耗时长
     */
    public static int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid > x) {
                r = mid - 1;
            } else {
                if ((long)(mid + 1) * (mid + 1) > x) {
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
        int l=0,r=x,ans =-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid*mid<=x){
                ans=mid;
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return ans;
    }
}


