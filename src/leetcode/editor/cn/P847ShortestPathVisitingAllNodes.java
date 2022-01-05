package leetcode.editor.cn;
//Java：访问所有节点的最短路径

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>存在一个由 <code>n</code> 个节点组成的无向连通图，图中的节点按从 <code>0</code> 到 <code>n - 1</code> 编号。</p>
 *
 * <p>给你一个数组 <code>graph</code> 表示这个图。其中，<code>graph[i]</code> 是一个列表，由所有与节点 <code>i</code> 直接相连的节点组成。</p>
 *
 * <p>返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。</p>
 *
 * <p>&nbsp;</p>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/05/12/shortest1-graph.jpg" style="width: 222px; height: 183px;" />
 * <pre>
 * <strong>输入：</strong>graph = [[1,2,3],[0],[0],[0]]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>一种可能的路径为 [1,0,2,0,3]</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/05/12/shortest2-graph.jpg" style="width: 382px; height: 222px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>一种可能的路径为 [0,1,4,2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == graph.length</code></li>
 * <li><code>1 &lt;= n &lt;= 12</code></li>
 * <li><code>0 &lt;= graph[i].length &lt;&nbsp;n</code></li>
 * <li><code>graph[i]</code> 不包含 <code>i</code></li>
 * <li>如果 <code>graph[a]</code> 包含 <code>b</code> ，那么 <code>graph[b]</code> 也包含 <code>a</code></li>
 * <li>输入的图总是连通图</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>广度优先搜索</li><li>图</li><li>动态规划</li><li>状态压缩</li></div></div><p><div><li>👍 179</li><li>👎 0</li></div>
 */
public class P847ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        Solution solution = new P847ShortestPathVisitingAllNodes().new Solution();
        // TO TEST
        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(solution.shortestPathLength(graph));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            // queue 中存储三元组 (n,mask,dist)
            // node 当前节点的编号
            // mask 截止目前已经遍历过的节点的状态压缩变量
            // dist 截至目前走过的距离
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] seen = new boolean[n][1 << n];
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{i, 1 << i, 0});
                seen[i][1 << i] = true;
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int node = tuple[0], mask = tuple[1], dist = tuple[2];
                if (mask == (1 << n) - 1) {
                    ans = dist;
                    break;
                }
                // 搜索相邻的节点
                for (int nei : graph[node]) {
                    // 将 mask 的第 nei 位置为 1
                    int neiMask = mask | (1 << nei);
                    if (!seen[nei][neiMask]) {
                        queue.add(new int[]{nei, neiMask, dist + 1});
                        seen[nei][neiMask] = true;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}