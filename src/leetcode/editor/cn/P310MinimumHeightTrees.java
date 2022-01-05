//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 示例 3： 
//
// 
//输入：n = 1, edges = []
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：n = 2, edges = [[0,1]]
//输出：[0,1]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// Related Topics 广度优先搜索 图 
// 👍 331 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：最小高度树
public class P310MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new P310MinimumHeightTrees().new Solution();
        // TO TEST
        int[][] edges = new int[][]{{0, 1}, {1, 2}};
//        int[][] edges = new int[0][0];
        System.out.println(solution.findMinHeightTrees(3, edges));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer>[] graph = new List[n];//邻接表
            int[] degrees = new int[n];//存储每个节点的度
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int node0 = edge[0], node1 = edge[1];
                graph[node0].add(node1);
                graph[node1].add(node0);
                degrees[node0]++;
                degrees[node1]++;
            }
            //拓扑排序找到最终结果
            boolean[] visited = new boolean[n];//记录是否被访问过
            int visitedCount = 0;//记录已经访问过的节点数
            LinkedList<Integer> oneDegreedNodes = new LinkedList<>();//由于是无向图，所以拓扑排序找度小于等于1的节点，而不是为0的
            do {
                while (!oneDegreedNodes.isEmpty()) {
                    int node = oneDegreedNodes.pollLast();
                    for (int nei : graph[node]) {//所有邻居度减一
                        degrees[nei]--;
                    }
                    visited[node] = true;
                    visitedCount++;
                }
                //将所有度小于等于1的且未被访问过的节点入队
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        if (degrees[i] <= 1) {
                            oneDegreedNodes.addFirst(i);
                        }
                    }
                }
            } while (visitedCount + 2 < n);
            return oneDegreedNodes;
        }


        /**
         * 递归法计算树的高度（如果高度已经超过ans，就会直接返回MAX_VALUE）
         *
         * @param root   根节点
         * @param parent root的父节点
         * @return 高度
         * <code>
         *         private int getDeep(int root, int parent) {
         *             int maxDeep = 0;
         *             for (int nei : graph[root]) {
         *                 if (nei != parent) {
         *                     maxDeep = Math.max(maxDeep, getDeep(nei, root));
         *                     if (maxDeep > ans) {
         *                         return Integer.MAX_VALUE;
         *                     }
         *                 }
         *             }
         *             return maxDeep + 1;
         *         }
         *         </code>
         */

        /**
         * 层序遍历法计算树的高度（如果高度已经超过ans，就会直接返回MAX_VALUE）
         *
         * @param root 根节点
         * @param n    树中全部节点数
         * @return 高度
         * <code>private int getDeep(int root, int n) {
         *             boolean[] visited = new boolean[n];
         *             Queue<Integer> queue = new LinkedList<>();
         *             queue.add(root);
         *             visited[root] = true;
         *             int deep = 1;
         *             while (!queue.isEmpty()) {
         *                 int size = queue.size();
         *                 for (int i = 0; i < size; i++) {
         *                     Integer node = queue.poll();
         *                     for (int nei : graph[node]) {
         *                         if (!visited[nei]) {
         *                             queue.add(nei);
         *                             visited[nei] = true;
         *                         }
         *                     }
         *                 }
         *                 if (++deep > ans) {
         *                     deep = Integer.MAX_VALUE;
         *                     break;
         *                 }
         *             }
         *             return deep;
         *         }
         *         </code>
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}
