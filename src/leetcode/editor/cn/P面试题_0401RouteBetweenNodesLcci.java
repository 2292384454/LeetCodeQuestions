package leetcode.editor.cn;
//Java：节点间通路

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * <strong> 输出</strong>：true
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * <strong> 输出</strong> true
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>节点数量n在[0, 1e5]范围内。</li>
 * <li>节点编号大于等于 0 小于 n。</li>
 * <li>图中可能存在自环和平行边。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li></div></div><p><div><li>👍 36</li><li>👎 0</li></div>
 */
public class P面试题_0401RouteBetweenNodesLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0401RouteBetweenNodesLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean ans = false;

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            LinkedList<Integer>[] adjacencyList = new LinkedList[n];
            for (int[] edge : graph) {
                if (adjacencyList[edge[0]] == null) {
                    adjacencyList[edge[0]] = new LinkedList<>();
                }
                adjacencyList[edge[0]].add(edge[1]);
            }
            boolean[] visted = new boolean[n];
            // 广度优先遍历
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                visted[cur] = true;
                if (cur == target) {
                    return true;
                }
                if (adjacencyList[cur] != null) {
                    // 所有没有遍历过的邻居入队
                    for (Integer nei : adjacencyList[cur]) {
                        if (!visted[nei]) {
                            queue.add(nei);
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}