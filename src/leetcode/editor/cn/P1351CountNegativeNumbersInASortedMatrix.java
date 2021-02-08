//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
//
// 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,-1],[-1,-1]]
//输出：3
// 
//
// 示例 4： 
//
// 
//输入：grid = [[-1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
//
// 
// Related Topics 数组 二分查找 
// 👍 59 👎 0

package leetcode.editor.cn;

//Java：统计有序矩阵中的负数
public class P1351CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P1351CountNegativeNumbersInASortedMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            //矩阵的行数和列数
            int row = grid.length;
            int column = grid[0].length;

            //当前数在第几列
            int col_index = 0;

            //负数的个数总和
            int sum = 0;

            for (int i = row - 1; i >= 0; i--) {
                //找到该行第一个负数所在的列数
                //这个while循环最多循环column次（col_index 从0 到 column - 1）
                while (col_index < column && grid[i][col_index] >= 0) {
                    col_index++;
                }
                //该行没负数，直接return
                if (col_index == column) {
                    return sum;
                }
                //该行还有负数，加上
                sum += (column - col_index);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
