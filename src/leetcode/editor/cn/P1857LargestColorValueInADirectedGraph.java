//给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。 
//
// 给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。同时给你一个二维数组 ed
//ges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。 
//
// 图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图
//中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。 
//
// 请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
//输出：3
//解释：路径 0 -> 2 -> 3 -> 4 含有 3 个颜色为 "a" 的节点（上图中的红色节点）。
// 
//
// 示例 2： 
//
// 
//
// 输入：colors = "a", edges = [[0,0]]
//输出：-1
//解释：从 0 到 0 有一个环。
// 
//
// 
//
// 提示： 
//
// 
// n == colors.length 
// m == edges.length 
// 1 <= n <= 105 
// 0 <= m <= 105 
// colors 只含有小写英文字母。 
// 0 <= aj, bj < n 
// 
// Related Topics 拓扑排序 动态规划 
// 👍 14 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：有向图中最大颜色值
public class P1857LargestColorValueInADirectedGraph {
    public static void main(String[] args) {
        Solution solution = new P1857LargestColorValueInADirectedGraph().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            int[][] dp = new int[n][26];// dp[i][j]: 拓扑排序中截止到第 i 个节点，第 j 种颜色的最大数量
            // 储存当前节点的入度，用来进行拓扑排序
            int[] inDegree = new int[n];
            // 储存key节点的的子节点
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                if (edge[0] == edge[1]) {
                    return -1;// 有指向自己的环，直接返回-1
                }
                map.computeIfAbsent(edge[0], k -> new ArrayList<>());
                map.get(edge[0]).add(edge[1]);
                inDegree[edge[1]]++;// 记录入度
            }
            Queue<Integer> queue = new LinkedList<>();// queue 记录入度为0的节点，辅助拓扑排序
            int found = 0;//拓扑排序访问的节点数量
            // 找到初始入度为0的节点
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            // 进行拓扑排序
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                found++;
                dp[cur][colors.charAt(cur) - 'a']++; // 将节点对应颜色 + 1
                List<Integer> childs = map.get(cur);
                if (childs != null) {
                    // 遍历所有子节点修改入度，即移除cur
                    for (Integer child : childs) {
                        // 子节点的入度数目减一,减到0的节点加入队列queue
                        if ((--inDegree[child]) == 0) {
                            queue.add(child);
                        }
                        // 更新 child 所有颜色数量，即dp[child][c] = Math.max(dp[child][c], dp[cur][c])
                        for (int c = 0; c < 26; c++) {
                            dp[child][c] = Math.max(dp[child][c], dp[cur][c]);
                        }
                    }
                }
            }
            if (found != n) {
                return -1; // 有环，直接返回 -1
            }
            int ans = 0;//dp二维数组中的最大值即为结果
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, Arrays.stream(dp[i]).max().getAsInt());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}