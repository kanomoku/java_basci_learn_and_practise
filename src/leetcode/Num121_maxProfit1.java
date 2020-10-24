package leetcode;

public class Num121_maxProfit1 {
    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int temp = maxProfit1(arr);
        System.out.println(temp);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],-prices[i]);
        }
        return Math.max(sell[n-1],buy[n-1]);
    }

    public static int maxProfit1(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int n = prices.length;
        int[][] hp = new int[n][2];
        hp[0][0]=-prices[0];
        hp[0][1]=0;
        for (int i = 1; i <prices.length ; i++) {
            hp[i][1]=Math.max(hp[i-1][1],prices[i]+hp[i-1][0]);
            hp[i][0]=Math.max(hp[i-1][0],-prices[i]);
        }
        return hp[n-1][1];
    }
}


