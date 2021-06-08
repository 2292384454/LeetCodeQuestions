//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 804 👎 0

package leetcode.editor.cn;

//Java：最大矩形
public class P85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalRectangle(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) {
                return 0;
            }
            int cols = matrix[0].length;
            if (cols == 0) {
                return 0;
            }
            //二维数组中元素f[i][j]存储记录matrix第i行中，以第j列结尾有几个连续的1
            int[][] f = new int[rows][cols], areas = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                int temp = 0;//temp记录当前第i行中，以第j列结尾有几个连续的1
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '1') {
                        f[i][j] = ++temp;
                    } else {
                        temp = 0;
                    }
                }
            }
            int ans = 0;
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    int area = 0, minvalue = f[i][j], m = i;
                    while (m >= 0 && f[m][j] > 0) {
                        minvalue = Math.min(minvalue, f[m][j]);
                        area = Math.max(area, minvalue * (i - m + 1));
                        m--;
                    }
                    areas[i][j] = area;
                    ans = Math.max(ans, areas[i][j]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
