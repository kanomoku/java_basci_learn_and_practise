package leetcode;

public class Num122_maxProfit2 {
    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 2, 6, 4};
        int temp = maxProfit2(arr);
        System.out.println(temp);
    }

    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley_shangu = prices[0];
        int peak_shanfeng = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley_shangu = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak_shanfeng = prices[i];
            maxprofit += peak_shanfeng - valley_shangu;
        }
        return maxprofit;
    }

    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // sellMaxProfit：卖股票获取的最大利润: 卖了股票赚多少钱
        // buyMaxProfit：买股票获取的最大利润：买了股票省多少钱
        // 状态数组
        int[] sellMaxProfit = new int[len];
        int[] buyMaxProfit = new int[len];

        //没股票可卖，所以0
        sellMaxProfit[0] = 0;
        //第一天买股票，花了股票第一天价格的钱
        buyMaxProfit[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            //都是今天和昨天比哪个利润最大就选哪个
            // 只有卖出去才会确定前面哪一步是买的动作，同理只有买了才会确定之前的哪一步确定卖了
            sellMaxProfit[i] = Math.max(sellMaxProfit[i - 1], buyMaxProfit[i - 1] + prices[i]);
            buyMaxProfit[i] = Math.max(buyMaxProfit[i - 1], sellMaxProfit[i - 1] - prices[i]);
        }
        return sellMaxProfit[len - 1];
    }

    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] hp = new int[len][2];
        //没股票可卖，所以0
        hp[0][1] = 0;//sellMaxProfit 卖股票获取的最大利润: 卖了股票赚多少钱
        //第一天买股票，花了股票第一天价格的钱
        hp[0][0] = -prices[0];//buyMaxProfit 买股票获取的最大利润：买了股票省多少钱

        for (int i = 1; i < len; i++) {
            //都是今天和昨天比哪个利润最大就选哪个
            // 只有卖出去才会确定前面哪一步是买的动作，同理只有买了才会确定之前的哪一步确定卖了
            hp[i][1] = Math.max(hp[i - 1][1], hp[i - 1][0] + prices[i]);//hp[i-1][0]+prices[i] 就好比，买了股票手里有多少钱
            hp[i][0] = Math.max(hp[i - 1][0], hp[i - 1][1] - prices[i]);//hp[i-1][1]-prices[i] 就好比，卖了股票手里有多少钱
        }
        return hp[len - 1][1];
    }

    public int maxProfit3(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

}


