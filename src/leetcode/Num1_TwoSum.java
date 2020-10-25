package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 4};
        int[] temp = twoSum4(arr, 6);
        System.out.println(Arrays.toString(temp));
    }


    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 数组中同一个元素不能使用两遍。
     * 这里 {3,2,4}; 输入6的话就会输出 [0,0]
     */
    public static int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 表示存在， 整个数组里是否存在 +当前元素=6的元素，包括当前元素自己。这也是存在的一种情境，虽然不符合当前题意
            //if (map.containsKey(target - nums[i])){
            // 那么怎么才能排除当前元素不算呢
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //先判断再追加，判断的时候自己还没有被追加进去，所以取到的指定不是自己，判断完了再追加也不会影响自己之前的判断
            //真的是聪明
            //这样效率还高，一遍判断一遍追加，比全追加进去再判断更有效率
            //这种判断加添加就好比：
            // 一个人在古董摊前买独一无二的一对酒瓶，老板刚出摊就想买，
            // 老板从袋子里拿出来一个，先看桌子上没有另一只配套的酒瓶，因为是第一回拿桌子时候空的，于是把这个酒瓶放到了桌子上
            // 老板又拿出来一个，赶紧看桌子上有没有和它是一套的，如果没有再把它放桌子上，如果有那么就找到这一对瓶子了
            // 老板又拿出来一个，又赶紧看桌子上有没有和它是一套的，如果没有再把它放桌子上，如果有那么就找到这一对瓶子了
            // 如果拿出来最后一个瓶子，要么就有一对的瓶子，要么就没有一对的

            //这种思路适合判断不重复的集合里是否存在满足某些条件的数值  因为值是唯一的所以就是判断是否“存在”
            //这里也有两种情况就是  1.是否包含本身（包含就是上面那个方法）  2.不包含本身（当前方法）
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}


