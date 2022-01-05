package leetcode.editor.cn;
//Java：网络延迟时间

import java.util.Arrays;

/**
 * <p>有 <code>n</code> 个网络节点，标记为 <code>1</code> 到 <code>n</code>。</p>
 *
 * <p>给你一个列表 <code>times</code>，表示信号经过 <strong>有向</strong> 边的传递时间。 <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>，其中 <code>u<sub>i</sub></code> 是源节点，<code>v<sub>i</sub></code> 是目标节点， <code>w<sub>i</sub></code> 是一个信号从源节点传递到目标节点的时间。</p>
 *
 * <p>现在，从某个节点 <code>K</code> 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 <code>-1</code> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="height: 220px; width: 200px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>times = [[1,2,1]], n = 2, k = 1
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>times = [[1,2,1]], n = 2, k = 2
 * <strong>输出：</strong>-1
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= k <= n <= 100</code></li>
 * <li><code>1 <= times.length <= 6000</code></li>
 * <li><code>times[i].length == 3</code></li>
 * <li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
 * <li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
 * <li><code>0 <= w<sub>i</sub> <= 100</code></li>
 * <li>所有 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 对都 <strong>互不相同</strong>（即，不含重复边）</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li><li>最短路</li><li>堆（优先队列）</li></div></div><p><div><li>👍 289</li><li>👎 0</li></div>
 */
public class P743NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new P743NetworkDelayTime().new Solution();
        // TO TEST
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 所求即为距离 k 点最远的点的距离
        public int networkDelayTime(int[][] times, int n, int k) {
            // 如果边数小于 n-1 ，那么一定不可能遍历完整个图
            if (times.length < n - 1) {
                return -1;
            }
            final int INF = Integer.MAX_VALUE / 2;
            // graph 用邻接矩阵存储图
            int[][] graph = new int[n][n];
            // dist 记录从 k 到每一个点的最短距离
            int[] dist = new int[n];
            // used 记录每一个节点是否已经求出了最短路径
            boolean[] used = new boolean[n];
            Arrays.fill(dist, INF);
            dist[k - 1] = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(graph[i], INF);
                graph[i][i] = 0;
            }
            for (int[] time : times) {
                graph[time[0] - 1][time[1] - 1] = time[2];
            }
            for (int i = 0; i < n; i++) {
                int toAdd = -1;
                // 找到所有尚未使用的节点中距离 k 最近的节点，将之加入
                for (int j = 0; j < n; j++) {
                    if (!used[j] && (toAdd == -1 || dist[j] < dist[toAdd])) {
                        toAdd = j;
                    }
                }
                used[toAdd] = true;
                // 更新 dist 数组
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], dist[toAdd] + graph[toAdd][j]);
                }
            }
            int ans = Arrays.stream(dist).max().getAsInt();
            return ans < INF ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}