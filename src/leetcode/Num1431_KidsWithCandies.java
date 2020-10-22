package leetcode;

import com.sun.xml.internal.ws.api.message.HeaderList;

import java.util.*;

public class Num1431_KidsWithCandies {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 1, 3};
        List<Boolean> temp = kidsWithCandies1(arr, 3);
        System.out.println(temp);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList();
        for (int i = 0; i < candies.length; i++) {
            int temp = candies[i] + extraCandies;
            Boolean res = true;
            for (int j = 0; j < candies.length; j++) {
                if (i != j && temp < candies[j]) {
                    res = false;
                }
            }
            list.add(res);
        }
        return list;
    }

    public static List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= max);
        }
        return list;
    }

}


