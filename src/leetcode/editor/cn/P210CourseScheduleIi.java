//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 396 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：课程表 II
public class P210CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        // TO TEST
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(solution.findOrder(2, prerequisites)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * visited数组记录了节点的访问状态.
         * visited[i] = 0表示节点i尚未被访问过;
         * visited[i] = 1表示节点i被访问了，但是尚未被检测完毕;
         * visited[i] = 2表示节点i已经被检测完毕了
         */
        int[] visited;
        int[] father;// father[i]表示到达节点i经过的前驱节点
        int[] ans;
        int index = 0;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            ans = new int[numCourses];
            index = numCourses;
            //创建邻接矩阵存储图，prerequisites[i] = [ai, bi]表示存在一条从bi指向ai的边。
            int[][] graph = new int[numCourses][numCourses];
            for (int[] p : prerequisites) {
                graph[p[1]][p[0]] = 1;
            }
            //深度优先遍历找是否存在环
            visited = new int[numCourses];
            father = new int[numCourses];
            Arrays.fill(father, -1);
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0) {
                    DFS(graph, i);
                }
            }
            return ans;
        }

        //从node开始深度优先遍历填充ans拓扑排序序列
        private void DFS(int[][] graph, int node) {
            int n = graph.length;
            visited[node] = 1;
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1) {
                    //找到一个环
                    if (visited[i] == 1) {
                        ans = new int[0];
                        return;//找到环了，就没必要继续遍历了，直接返回即可。
//                        int tmp = node;
//                        System.out.print("cycle: ");
//                        while (tmp != i) {
//                            System.out.print(tmp + "->");
//                            tmp = father[tmp];
//                        }
//                        System.out.println(tmp);
                    } else if (visited[i] == 0) {
                        father[i] = node;
                        DFS(graph, i);
                    }
                }
            }
            visited[node] = 2;
            if (ans.length > 0) {
                ans[--index] = node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
