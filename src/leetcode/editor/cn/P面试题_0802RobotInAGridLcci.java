package leetcode.editor.cn;
//Java：迷路的机器人

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png" style="height: 183px; width: 400px;"></p>
 *
 * <p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>
 *
 * <p>返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:
 * </strong>[
 * &nbsp; [<strong>0</strong>,<strong>0</strong>,<strong>0</strong>],
 * &nbsp; [0,1,<strong>0</strong>],
 * &nbsp; [0,0,<strong>0</strong>]
 * ]
 * <strong>输出:</strong> [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * <strong>解释:
 * </strong>输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -&gt; 0行1列 -&gt; 0行2列 -&gt; 1行2列 -&gt; 2行2列（右下角）</pre>
 *
 * <p><strong>说明：</strong><em>r</em>&nbsp;和 <em>c </em>的值均不超过 100。</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>回溯</li><li>矩阵</li></div></div><p><div><li>👍 64</li><li>👎 0</li></div>
 */
public class P面试题_0802RobotInAGridLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0802RobotInAGridLcci().new Solution();
        // TO TEST
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.pathWithObstacles(obstacleGrid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            List<List<Integer>> ans = new ArrayList<>();
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            // dp[i][j] 记录该点是否可达（从(0,0)出发）
            boolean[][] dp = new boolean[m][n];
            for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
                dp[i][0] = true;
            }
            for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
                dp[0][j] = true;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                    }
                }
            }
            int i = m - 1, j = n - 1;
            if (!dp[i][j]) {
                return ans;
            }
            if (dp[i][j]) {
                // 从终点向回反向遍历，记录路径
                while ((i > 0 || j > 0) && i >= 0 && j >= 0) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    if (i > 0 && dp[i - 1][j]) {
                        pair.add(i--);
                        pair.add(j);
                    } else {
                        pair.add(i);
                        pair.add(j--);
                    }
                    ans.add(pair);
                }
            }
            ans.add(Arrays.asList(0, 0));
            Collections.reverse(ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}