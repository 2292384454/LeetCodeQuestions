package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class P787CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new P787CheapestFlightsWithinKStops().new Solution();
        // TO TEST
    }

    //Java：K 站中转内最便宜的航班
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            final int INF = 10000 * 101 + 1;
            int[] cost = new int[n];
            Arrays.fill(cost, INF);
            cost[src] = 0;
            int ans = INF;
            for (int t = 1; t <= k + 1; ++t) {
                int[] temp = new int[n];
                Arrays.fill(temp, INF);
                for (int[] flight : flights) {
                    int from = flight[0], to = flight[1], price = flight[2];
                    temp[to] = Math.min(temp[to], cost[from] + price);
                }
                cost = temp;
                ans = Math.min(ans, cost[dst]);
            }
            return ans == INF ? -1 : ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}