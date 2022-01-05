//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 259 👎 0

package leetcode.editor.cn;

//Java：顺时针打印矩阵
public class P剑指_offer_29ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_29ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new int[0];
            }
            int m = matrix.length, n = matrix[0].length;
            boolean[][] hasVisited = new boolean[m][n];
            int[] ans = new int[m * n];
            int x = 0, y = 0, count = 0;
            int direction = 0;// 0：右，1：下，2：左，3：上
            while (count < m * n) {
                hasVisited[x][y] = true;
                ans[count++] = matrix[x][y];
                int tryCount = 0;
                while (tryCount < 4) {
                    if (direction == 0) {
                        // 如果能向右走
                        if (y + 1 < n && !hasVisited[x][y + 1]) {
                            y++;
                            break;
                        } else {
                            direction = 1;
                            tryCount++;
                        }
                    }
                    if (direction == 1) {
                        // 如果能向下走
                        if (x + 1 < m && !hasVisited[x + 1][y]) {
                            x++;
                            break;
                        } else {
                            direction = 2;
                            tryCount++;
                        }
                    }
                    if (direction == 2) {
                        // 如果能向左走
                        if (y - 1 >= 0 && !hasVisited[x][y - 1]) {
                            y--;
                            break;
                        } else {
                            direction = 3;
                            tryCount++;
                        }
                    }
                    if (direction == 3) {
                        // 如果能向上走
                        if (x - 1 >= 0 && !hasVisited[x - 1][y]) {
                            x--;
                            break;
                        } else {
                            direction = 0;
                            tryCount++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}