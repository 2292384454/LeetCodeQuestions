package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P5836NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        Solution solution = new P5836NumberOfWaysToArriveAtDestination().new Solution();
        // TO TEST
    }

    //Java：到达目的地的方案数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final long INF = Long.MAX_VALUE >> 1;
        final int MOD = 1000000007;

        public int countPaths(int n, int[][] roads) {
            long[][] graph = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(graph[i], INF);
            }
            for (int[] road : roads) {
                graph[road[0]][road[1]] = road[2];
                graph[road[1]][road[0]] = road[2];
            }
            // dp[0][i] 记录从 0 到每一个点的最短距离
            // dp[1][i] 记录从 0 到每一个点的最短路径的数量
            long[][] dp = new long[2][n];
            Arrays.fill(dp[0], INF);
            dp[0][0] = 0;
            dp[1][0] = 1;
            // 小根堆用来找距离 0 最近的节点
            // 堆中数组对象 [0] 是距离， [1] 是节点 id
            PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
            minHeap.add(new long[]{0L, 0L});
            while (!minHeap.isEmpty()) {
                // 取出距离 0 最近的节点
                long[] p = minHeap.poll();
                long dist = p[0];
                int i = (int) p[1];
                // 如果从 0 到 i 的距离大于或等于 dist，则更新 dist 数组
                if (dp[0][i] >= dist) {
                    for (int j = 0; j < n; j++) {
                        long newDist = dp[0][i] + (long) graph[i][j];
                        // 如果新路径的长度没变，那么将经过 i 到达 j 的路径数量计入
                        if (newDist == dp[0][j]) {
                            dp[1][j] = (dp[1][i] + dp[1][j]) % MOD;
                        }
                        // 如果出现了新的更短的路径，记录之并将最短路径的数量置为 dp[1][i]
                        if (newDist < dp[0][j]) {
                            dp[0][j] = newDist;
                            minHeap.add(new long[]{newDist, j});
                            dp[1][j] = dp[1][i];
                        }
                    }
                }
            }
            return (int) dp[1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}