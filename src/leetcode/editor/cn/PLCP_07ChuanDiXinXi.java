package leetcode.editor.cn;
//Java：传递信息

import java.util.ArrayList;
import java.util.List;

/**
 * <p>小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：</p>
 *
 * <ol>
 * <li>有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0</li>
 * <li>每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。</li>
 * <li>每轮信息必须需要传递给另一个人，且信息可重复经过同一个人</li>
 * </ol>
 *
 * <p>给定总玩家数 <code>n</code>，以及按 <code>[玩家编号,对应可传递玩家编号]</code> 关系组成的二维数组 <code>relation</code>。返回信息从小 A (编号 0 ) 经过 <code>k</code> 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <blockquote>
 * <p>输入：<code>n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3</code></p>
 *
 * <p>输出：<code>3</code></p>
 *
 * <p>解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0-&gt;2-&gt;0-&gt;4， 0-&gt;2-&gt;1-&gt;4， 0-&gt;2-&gt;3-&gt;4。</p>
 * </blockquote>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <blockquote>
 * <p>输入：<code>n = 3, relation = [[0,2],[2,1]], k = 2</code></p>
 *
 * <p>输出：<code>0</code></p>
 *
 * <p>解释：信息不能从小 A 处经过 2 轮传递到编号 2</p>
 * </blockquote>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= n &lt;= 10</code></li>
 * <li><code>1 &lt;= k &lt;= 5</code></li>
 * <li><code>1 &lt;= relation.length &lt;= 90, 且 relation[i].length == 2</code></li>
 * <li><code>0 &lt;= relation[i][0],relation[i][1] &lt; n 且 relation[i][0] != relation[i][1]</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li><li>动态规划</li></div></div><p><div><li>👍 102</li><li>👎 0</li></div>
 */
public class PLCP_07ChuanDiXinXi {
    public static void main(String[] args) {
        Solution solution = new PLCP_07ChuanDiXinXi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] g;
        int ans = 0;

        public int numWays(int n, int[][] relation, int k) {
            g = new List[n];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] edge : relation) {
                g[edge[0]].add(edge[1]);
            }
            boolean[] visited = new boolean[n];
            dfs(0, n, k, visited);
            return ans;
        }

        private void dfs(int loc, int n, int k, boolean[] visited) {
            if (k == 0) {
                if (loc == n - 1) {
                    ans++;
                }
                return;
            }
            visited[loc] = true;
            for (int nei : g[loc]) {
                dfs(nei, n, k - 1, visited);
            }
            visited[loc] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}