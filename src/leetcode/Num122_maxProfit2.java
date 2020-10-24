package leetcode;

public class Num122_maxProfit2 {
    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int temp = maxProfit1(arr);
        System.out.println(temp);
    }

    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // sell：卖股票
        // hold：买股票
        // 状态数组
        // 状态转移：sell → buy → sell → buy → sell → buy → sell
        int[] sell = new int[len];
        int[] buy = new int[len];

        //没股票可卖，所以0
        sell[0] = 0;
        //第一天买股票，花了股票第一天价格的钱
        buy[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            //昨天
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }

}


