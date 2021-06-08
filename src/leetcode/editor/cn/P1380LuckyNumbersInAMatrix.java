//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。 
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// Related Topics 数组 
// 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：矩阵中的幸运数
public class P1380LuckyNumbersInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P1380LuckyNumbersInAMatrix().new Solution();
        // TO TEST
        int arr[][] = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(solution.luckyNumbers(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            //minOfRow存储每一行最小值及其列数
            int[][] minOfRow = new int[m][2];
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                minOfRow[i][0] = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] < minOfRow[i][0]) {
                        minOfRow[i][0] = matrix[i][j];
                        minOfRow[i][1] = j;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                int k = 0;
                for (k = 0; k < m; k++) {
                    if (matrix[k][minOfRow[i][1]] > minOfRow[i][0]) {
                        break;
                    }
                }
                if (k == m) {
                    result.add(minOfRow[i][0]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
