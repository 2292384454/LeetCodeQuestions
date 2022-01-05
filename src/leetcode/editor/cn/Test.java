package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 描述.
 * <p>
 * 创建时间: 2021/9/18 15:39
 *
 * @author KevinHwang
 */
public class Test {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int fee = 1;
        Test test = new Test();
        System.out.println(test.maxProfit(k, prices, fee));
    }

    public int maxProfit(int k, int[] prices, int fee) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        // buy、sell和lock分别存储截止当前日期，最后一次操作为第 i 次买入/卖出/冷冻能取得的最大收益
        int[] buy = new int[k];
        int[] sell = new int[k];
        int[] lock = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            int _buy = buy[0];
            int _sell = sell[0];
            buy[0] = Math.max(buy[0], -price);
            if (price > fee) {
                sell[0] = Math.max(sell[0], _buy + price - fee);
            }
            lock[0] = Math.max(lock[0], _sell);
            for (int i = 1; i < k; i++) {
                _buy = buy[i];
                _sell = sell[i];
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                if (price > fee) {
                    sell[i] = Math.max(sell[i], _buy + price - fee);
                }
                lock[i] = Math.max(lock[i], _sell);
            }
        }
        return sell[k - 1];
    }
}
