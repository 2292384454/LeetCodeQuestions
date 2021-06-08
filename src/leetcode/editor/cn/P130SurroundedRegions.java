//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X'
//,'X']]
//输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [['X']]
//输出：[['X']]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 527 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：被围绕的区域
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}};
//        char[][] board = new char[][]{{'O', 'O'}, {'O', 'O'}};
        solution.solve(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] copy;
        int m, n;

        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            m = board.length;
            n = board[0].length;
            copy = new char[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, n);
                Arrays.fill(board[i], 'X');
            }
            for (int i = 0; i < m; i++) {
                if (copy[i][0] == 'O') {
                    BFS(board, i, 0);
                }
                if (copy[i][n - 1] == 'O') {
                    BFS(board, i, n - 1);
                }
            }
            for (int j = 0; j < n; j++) {
                if (copy[0][j] == 'O') {
                    BFS(board, 0, j);
                }
                if (copy[m - 1][j] == 'O') {
                    BFS(board, m - 1, j);
                }
            }
        }

        public void BFS(char[][] board, int i, int j) {
            board[i][j] = 'O';
            copy[i][j] = 'X';
            if (i - 1 >= 0 && copy[i - 1][j] == 'O') {
                BFS(board, i - 1, j);
            }
            if (i + 1 < m && copy[i + 1][j] == 'O') {
                BFS(board, i + 1, j);
            }
            if (j - 1 >= 0 && copy[i][j - 1] == 'O') {
                BFS(board, i, j - 1);
            }
            if (j + 1 < n && copy[i][j + 1] == 'O') {
                BFS(board, i, j + 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
