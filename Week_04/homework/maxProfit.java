package Week_04.homework;

/**
 * 1. 股票的波动不是升就是降。
 * 2. 升的时候最低点买入，最高点卖出，即可获取最大受益（现实中韭菜心理：狗头.jpg），整个过程相当于每天买入卖出。
 * 3. 降的时候不买
 */
public class maxProfit {
    /**
     * 贪心
     * [7,1,5,3,6,4]
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                profit += temp;
            }
        }
        return profit;
    }
}
