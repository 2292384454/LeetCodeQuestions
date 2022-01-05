package leetcode.editor.cn;
//Java：循环轮转矩阵

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>给你一个大小为 <code>m x n</code> 的整数矩阵 <code>grid</code>​​​ ，其中 <code>m</code> 和 <code>n</code> 都是 <strong>偶数</strong> ；另给你一个整数 <code>k</code> 。</p>
 *
 * <p>矩阵由若干层组成，如下图所示，每种颜色代表一层：</p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid.png" style="width: 231px; height: 258px;"></p>
 *
 * <p>矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 <strong>逆时针 </strong>方向的相邻元素。轮转示例如下：</p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/explanation_grid.jpg" style="width: 500px; height: 268px;">
 * <p>返回执行 <code>k</code> 次循环轮转操作后的矩阵。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/19/rod2.png" style="width: 421px; height: 191px;">
 * <pre><strong>输入：</strong>grid = [[40,10],[30,20]], k = 1
 * <strong>输出：</strong>[[10,20],[40,30]]
 * <strong>解释：</strong>上图展示了矩阵在执行循环轮转操作时每一步的状态。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid5.png" style="width: 231px; height: 262px;"></strong> <strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid6.png" style="width: 231px; height: 262px;"></strong> <strong><img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/ringofgrid7.png" style="width: 231px; height: 262px;"></strong>
 *
 * <pre><strong>输入：</strong>grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * <strong>输出：</strong>[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * <strong>解释：</strong>上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>m == grid.length</code></li>
 * <li><code>n == grid[i].length</code></li>
 * <li><code>2 &lt;= m, n &lt;= 50</code></li>
 * <li><code>m</code> 和 <code>n</code> 都是 <strong>偶数</strong></li>
 * <li><code>1 &lt;= grid[i][j] &lt;=<sup> </sup>5000</code></li>
 * <li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>矩阵</li><li>模拟</li></div></div><p><div><li>👍 8</li><li>👎 0</li></div>
 */
public class P1914CyclicallyRotatingAGrid {
    public static void main(String[] args) {
        Solution solution = new P1914CyclicallyRotatingAGrid().new Solution();
        // TO TEST
        int[][] gird = new int[][]{
                {4, 5, 8, 9, 4, 2, 4, 7, 2, 4},
                {7, 1, 9, 6, 6, 1, 4, 5, 7, 7},
                {7, 1, 5, 1, 1, 7, 10, 1, 3, 1},
                {7, 2, 2, 5, 2, 6, 6, 4, 7, 7},
                {1, 2, 3, 8, 4, 7, 6, 9, 6, 2},
                {5, 10, 3, 4, 7, 2, 7, 5, 3, 10}};
        System.out.println(Arrays.deepToString(solution.rotateGrid(gird, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            // 矩阵尺寸
            int m = grid.length, n = grid[0].length;
            // 计算一共有多少层
            int layerNumber = Math.min(m, n) / 2;
            // 逐层处理
            for (int i = 0; i < layerNumber; ++i) {
                // 计算出来当前层需要多大的数组来存放, 计算方法是当前层最大尺寸 - 内部下一层尺寸.
                int[] data = new int[(m - 2 * i) * (n - 2 * i) - (m - (i + 1) * 2) * (n - (i + 1) * 2)];
                int idx = 0;
                // 从左往右
                for (int offset = i; offset < n - i - 1; ++offset)
                    data[idx++] = grid[i][offset];
                // 从上往下
                for (int offset = i; offset < m - i - 1; ++offset)
                    data[idx++] = grid[offset][n - i - 1];
                // 从右往左
                for (int offset = n - i - 1; offset > i; --offset)
                    data[idx++] = grid[m - i - 1][offset];
                // 从下往上
                for (int offset = m - i - 1; offset > i; --offset)
                    data[idx++] = grid[offset][i];
                // 把旋转完的放回去
                Integer[] ret = rotateVector(data, k);
                idx = 0;
                // 从左往右
                for (int offset = i; offset < n - i - 1; ++offset)
                    grid[i][offset] = ret[idx++];
                // 从上往下
                for (int offset = i; offset < m - i - 1; ++offset)
                    grid[offset][n - i - 1] = ret[idx++];
                // 从右往左
                for (int offset = n - i - 1; offset > i; --offset)
                    grid[m - i - 1][offset] = ret[idx++];
                // 从下往上
                for (int offset = m - i - 1; offset > i; --offset)
                    grid[offset][i] = ret[idx++];
            }
            return grid;
        }

        private Integer[] rotateVector(int[] vector, int offset) {
            // 取余, 否则会有无用功, 超时
            offset = offset % vector.length;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int item : vector) deque.add(item);
            // 旋转操作
            while (offset-- > 0) {
                deque.addLast(deque.pollFirst());
            }
            return deque.toArray(new Integer[0]);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}