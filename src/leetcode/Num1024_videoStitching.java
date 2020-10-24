package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1024_videoStitching {
    public static void main(String[] args) {

        int[][] arr = {
                {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}
        };
        int temp = videoStitching(arr, 10);
        System.out.println(temp);
    }

    public static int videoStitching(int[][] clips, int T) {

        int[] hq = new int[T + 1];
        Arrays.fill(hq, Integer.MAX_VALUE - 1);
        hq[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] arr : clips) {
                if (arr[0] < i && i <= arr[1]) {
                    hq[i] = Math.min(hq[i], hq[arr[0]] + 1);
                }
            }
        }
        return hq[T] == Integer.MAX_VALUE - 1 ? -1 : hq[T];
    }
}


