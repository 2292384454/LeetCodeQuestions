package leetcode.editor.cn;
//Java：蛇梯棋

import java.util.*;

/**
 * <p>N x N 的棋盘&nbsp;<code>board</code> 上，按从&nbsp;<code>1</code> 到 <code>N*N</code>&nbsp;的数字给方格编号，编号<strong> 从左下角开始</strong>，每一行交替方向。</p>
 *
 * <p>例如，一块 6 x 6 大小的棋盘，编号如下：</p>
 *
 * <pre><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/31/snakes.png" style="height: 200px; width: 254px;">
 * </pre>
 *
 * <p><code>r</code> 行 <code>c</code> 列的棋盘，按前述方法编号，棋盘格中可能存在 &ldquo;蛇&rdquo; 或 &ldquo;梯子&rdquo;；如果 <code>board[r][c] != -1</code>，那个蛇或梯子的目的地将会是 <code>board[r][c]</code>。</p>
 *
 * <p>玩家从棋盘上的方格&nbsp;<code>1</code> （总是在最后一行、第一列）开始出发。</p>
 *
 * <p>每一回合，玩家需要从当前方格 <code>x</code> 开始出发，按下述要求前进：</p>
 *
 * <ul>
 * <li>选定目标方格：选择从编号 <code>x+1</code>，<code>x+2</code>，<code>x+3</code>，<code>x+4</code>，<code>x+5</code>，或者 <code>x+6</code> 的方格中选出一个目标方格 <code>s</code> ，目标方格的编号 <code>&lt;= N*N</code>。
 *
 * <ul>
 * <li>该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 <code>[x+1, x+6]</code> 之间。</li>
 * </ul>
 * </li>
 * <li>传送玩家：如果目标方格 <code>S</code> 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 <code>S</code>。&nbsp;</li>
 * </ul>
 *
 * <p>注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。</p>
 *
 * <p>返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 <code>-1</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>[
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>
 * 首先，从方格 1 [第 5 行，第 0 列] 开始。
 * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * 然后你决定移动到方格 36, 游戏结束。
 * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= board.length = board[0].length&nbsp;&lt;= 20</code></li>
 * <li><code>board[i][j]</code>&nbsp;介于&nbsp;<code>1</code>&nbsp;和&nbsp;<code>N*N</code>&nbsp;之间或者等于&nbsp;<code>-1</code>。</li>
 * <li>编号为&nbsp;<code>1</code>&nbsp;的方格上没有蛇或梯子。</li>
 * <li>编号为&nbsp;<code>N*N</code>&nbsp;的方格上没有蛇或梯子。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>广度优先搜索</li><li>数组</li><li>矩阵</li></div></div><p><div><li>👍 75</li><li>👎 0</li></div>
 */
public class P909SnakesAndLadders {
    public static void main(String[] args) {
        Solution solution = new P909SnakesAndLadders().new Solution();
        // TO TEST
        int[][] board = new int[][]{
                {-1, -1, -1, -1, 33, -1, -1, -1, -1, 37, -1, -1},
                {-1, -1, -1, 17, 128, 113, 11, 5, -1, 99, -1, -1},
                {10, -1, 72, 112, 72, 31, -1, -1, 62, -1, -1, -1},
                {-1, -1, -1, -1, -1, 6, 21, 122, -1, 1, -1, 39},
                {-1, -1, -1, -1, -1, -1, -1, 79, -1, 128, 81, -1},
                {-1, 16, -1, 120, -1, -1, 11, 62, -1, -1, -1, -1},
                {101, 88, 87, -1, -1, -1, -1, -1, -1, -1, -1, 40},
                {-1, -1, 90, 80, -1, -1, -1, -1, -1, -1, -1, 35},
                {-1, 78, -1, -1, -1, 62, -1, -1, -1, -1, -1, -1},
                {-1, 3, -1, -1, -1, -1, -1, -1, 89, -1, -1, -1},
                {-1, 44, -1, -1, -1, 103, 134, -1, 69, -1, -1, 123},
                {-1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
        System.out.println(solution.snakesAndLadders(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] vis = new boolean[n * n + 1];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1, 0});
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                for (int i = 1; i <= 6; ++i) {
                    int nxt = p[0] + i;
                    if (nxt > n * n) { // 超出边界
                        break;
                    }
                    int[] rc = id2rc(nxt, n); // 得到下一步的行列
                    if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                        nxt = board[rc[0]][rc[1]];
                    }
                    if (nxt == n * n) { // 到达终点
                        return p[1] + 1;
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                    }
                }
            }
            return -1;
        }

        public int[] id2rc(int id, int n) {
            int r = (id - 1) / n, c = (id - 1) % n;
            if (r % 2 == 1) {
                c = n - 1 - c;
            }
            return new int[]{n - 1 - r, c};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}