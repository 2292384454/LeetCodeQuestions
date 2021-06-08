//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 752 👎 0

package leetcode.editor.cn;


//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            //buy和sell分别存储截止当前日期，最后一次操作为买入/卖出能取得的最大收益，lock存储截止当前日期，最后一次操作为冷冻时的最大收益
            int[] buy = new int[len], sell = new int[len], lock = new int[len];
            buy[0] = -prices[0];
            for (int i = 1; i < len; i++) {
                buy[i] = Math.max(buy[i - 1], lock[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                lock[i] = Math.max(lock[i - 1], sell[i - 1]);
            }
            return Math.max(Math.max(buy[len - 1], sell[len - 1]), lock[len - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
