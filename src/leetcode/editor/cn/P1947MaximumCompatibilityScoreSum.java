package leetcode.editor.cn;
//Java：最大兼容性评分和

/**
 * <p>有一份由 <code>n</code> 个问题组成的调查问卷，每个问题的答案要么是 <code>0</code>（no，否），要么是 <code>1</code>（yes，是）。</p>
 *
 * <p>这份调查问卷被分发给 <code>m</code> 名学生和 <code>m</code> 名导师，学生和导师的编号都是从 <code>0</code> 到 <code>m - 1</code> 。学生的答案用一个二维整数数组 <code>students</code> 表示，其中 <code>students[i]</code> 是一个整数数组，包含第 <code>i</code> 名学生对调查问卷给出的答案（<strong>下标从 0 开始</strong>）。导师的答案用一个二维整数数组 <code>mentors</code> 表示，其中 <code>mentors[j]</code> 是一个整数数组，包含第 <code>j</code> 名导师对调查问卷给出的答案（<strong>下标从 0 开始</strong>）。</p>
 *
 * <p>每个学生都会被分配给 <strong>一名</strong> 导师，而每位导师也会分配到 <strong>一名</strong> 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。</p>
 *
 * <ul>
 * <li>例如，学生答案为<code>[1, <strong><em>0</em></strong>, <strong><em>1</em></strong>]</code> 而导师答案为 <code>[0, <strong><em>0</em></strong>, <strong><em>1</em></strong>]</code> ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。</li>
 * </ul>
 *
 * <p>请你找出最优的学生与导师的配对方案，以 <strong>最大程度上</strong> 提高 <strong>兼容性评分和</strong> 。</p>
 *
 * <p>给你 <code>students</code> 和 <code>mentors</code> ，返回可以得到的<em> </em><strong>最大兼容性评分和</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
 * <strong>输出：</strong>8
 * <strong>解释：</strong>按下述方式分配学生和导师：
 * - 学生 0 分配给导师 2 ，兼容性评分为 3 。
 * - 学生 1 分配给导师 0 ，兼容性评分为 2 。
 * - 学生 2 分配给导师 1 ，兼容性评分为 3 。
 * 最大兼容性评分和为 3 + 2 + 3 = 8 。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
 * <strong>输出：</strong>0
 * <strong>解释：</strong>任意学生与导师配对的兼容性评分都是 0 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>m == students.length == mentors.length</code></li>
 * <li><code>n == students[i].length == mentors[j].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 8</code></li>
 * <li><code>students[i][k]</code> 为 <code>0</code> 或 <code>1</code></li>
 * <li><code>mentors[j][k]</code> 为 <code>0</code> 或 <code>1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>动态规划</li><li>回溯</li><li>状态压缩</li></div></div><p><div><li>👍 9</li><li>👎 0</li></div>
 */
public class P1947MaximumCompatibilityScoreSum {
    public static void main(String[] args) {
        Solution solution = new P1947MaximumCompatibilityScoreSum().new Solution();
        // TO TEST
        int[][] students = new int[][]{{0, 0}, {0, 0}, {0, 0}};
        int[][] mentors = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        System.out.println(solution.maxCompatibilitySum(students, mentors));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int m = students.length, n = students[0].length;
            int[] stu = new int[m], men = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    stu[i] = (stu[i] << 1) | students[i][j];
                    men[i] = (men[i] << 1) | mentors[i][j];
                }
            }
            // 计算每一个学生与每一个老师之间的兼容性
            int[][] marks = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    marks[i][j] = getMark(stu[i], men[j], n);
                }
            }
            // 下面的任务就是在 marks 中挑选出 m 个位置
            // 这 m 个位置两两不在同一行也不在同一列，使得 m 个位置的和最大
            boolean[] mChoosed = new boolean[m];
            help(marks, mChoosed, 0, 0);
            return ans;
        }

        /**
         * 计算兼容性
         */
        private int getMark(int s, int m, int n) {
            int xnor = ~(s ^ m);
            xnor &= ((1 << n) - 1);
            int mark = 0;
            while (xnor != 0) {
                xnor &= (xnor - 1);
                mark++;
            }
            return mark;
        }

        /**
         * 进行回溯
         */
        private void help(int[][] marks, boolean[] mChoosed, int curCol, int count) {
            int m = marks.length;
            if (curCol >= m) {
                ans = Math.max(ans, count);
                return;
            }
            for (int i = 0; i < m; i++) {
                if (!mChoosed[i]) {
                    mChoosed[i] = true;
                    help(marks, mChoosed, curCol + 1, count + marks[curCol][i]);
                    mChoosed[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}