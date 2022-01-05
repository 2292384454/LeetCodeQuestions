//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 620 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
        solution.spiralOrder(new int[][]{{1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            List<Integer> ans = new ArrayList<>();
            int i = 0, j = 0;
            int direction = 0;//0，1,2,3分别表示向右，向下，向左，向上
            while (ans.size() < m * n) {
                ans.add(matrix[i][j]);
                matrix[i][j] = 200;//删除已经访问过的元素
                //判断是否转向
                if ((direction == 0 && (j + 1 == n || matrix[i][j + 1] > 100))
                        || (direction == 1 && (i + 1 == m || matrix[i + 1][j] > 100))
                        || (direction == 2 && (j - 1 < 0 || matrix[i][j - 1] > 100))
                        || (direction == 3 && (i - 1 < 0 || matrix[i - 1][j] > 100))) {
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
