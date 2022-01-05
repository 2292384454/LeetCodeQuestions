//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 822 👎 0

package leetcode.editor.cn;


//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "SEE"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        board[i][j] = ' ';
                        if (help(board, word.substring(1), i, j)) {
                            return true;
                        }
                        board[i][j] = word.charAt(0);
                    }
                }
            }

            return false;
        }

        public boolean help(char[][] board, String word, int x, int y) {
            if (word.length() == 0) {
                return true;
            }
            if (x + 1 < board.length && board[x + 1][y] == word.charAt(0)) {//检测下面
                board[x + 1][y] = ' ';
                if (help(board, word.substring(1), x + 1, y)) {
                    return true;
                }
                board[x + 1][y] = word.charAt(0);
            }
            if (x - 1 >= 0 && board[x - 1][y] == word.charAt(0)) {//检测上面
                board[x - 1][y] = ' ';
                if (help(board, word.substring(1), x - 1, y)) {
                    return true;
                }
                board[x - 1][y] = word.charAt(0);
            }
            if (y + 1 < board[0].length && board[x][y + 1] == word.charAt(0)) {//检测右面
                board[x][y + 1] = ' ';
                if (help(board, word.substring(1), x, y + 1)) {
                    return true;
                }
                board[x][y + 1] = word.charAt(0);
            }
            if (y - 1 >= 0 && board[x][y - 1] == word.charAt(0)) {//检测左面
                board[x][y - 1] = ' ';
                if (help(board, word.substring(1), x, y - 1)) {
                    return true;
                }
                board[x][y - 1] = word.charAt(0);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
