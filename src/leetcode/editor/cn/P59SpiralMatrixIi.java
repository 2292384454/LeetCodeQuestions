//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 315 👎 0

package leetcode.editor.cn;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
        solution.generateMatrix(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = -1;
                }
            }
            int i = 0, j = 0, direction = 0, num = 1;//direction0，1,2,3分别表示向右，向下，向左，向上
            while (num <= n * n) {
                ans[i][j] = num++;
                //判断是否转向
                if ((direction == 0 && (j + 1 == n || ans[i][j + 1] > 0))
                        || (direction == 1 && (i + 1 == n || ans[i + 1][j] > 0))
                        || (direction == 2 && (j - 1 < 0 || ans[i][j - 1] > 0))
                        || (direction == 3 && (i - 1 < 0 || ans[i - 1][j] > 0))) {
                    direction = (direction + 1) % 4;
                }
                if (direction == 0) {
                    j++;
                } else if (direction == 1) {
                    i++;
                } else if (direction == 2) {
                    j--;
                } else {
                    i--;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
