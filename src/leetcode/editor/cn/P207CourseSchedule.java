//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 798 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(2, prerequisites));
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
        boolean ans = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        //从node开始深度优先遍历找环，如果找到就将ans置为false
        private void DFS(int[][] graph, int node) {
            int n = graph.length;
            visited[node] = 1;
//            System.out.print(node+"-");
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1) {
                    //找到一个环
                    if (visited[i] == 1) {
                        ans = false;
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
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
