//在 N * N 的网格上，我们放置一些 1 * 1 * 1 的立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
//
// 请你返回最终形体的表面积。
//
//
//
//
//
//
// 示例 1：
//
// 输入：[[2]]
//输出：10
//
//
// 示例 2：
//
// 输入：[[1,2],[3,4]]
//输出：34
//
//
// 示例 3：
//
// 输入：[[1,0],[0,2]]
//输出：16
//
//
// 示例 4：
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：32
//
//
// 示例 5：
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：46
//
//
//
//
// 提示：
//
//
// 1 <= N <= 50
// 0 <= grid[i][j] <= 50
//
// Related Topics 几何 数学
// 👍 134 👎 0

package leetcode.editor.cn;

//Java：三维形体的表面积
public class P892SurfaceAreaOf3dShapes {
    public static void main(String[] args) {
        Solution solution = new P892SurfaceAreaOf3dShapes().new Solution();
        // TO TEST
        int[][] grid = new int[][]{{1, 2}, {3, 4}};
        System.out.println(solution.surfaceArea(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int surfaceArea(int[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    result += 2 * (grid[i][j] > 0 ? 1 : 0);//加上顶和底的表面积
                    if (grid[i][j] > 0) {
                        int sideArea = 4 * grid[i][j];//四面的侧面积
                        int front = Math.min((i - 1 >= 0 ? grid[i - 1][j] : 0), grid[i][j]);//前面被遮挡的部分
                        int behind = Math.min((i + 1 < grid.length ? grid[i + 1][j] : 0), grid[i][j]);//后面被遮挡的部分
                        int left = Math.min((j - 1 >= 0 ? grid[i][j - 1] : 0), grid[i][j]);//左边被遮挡的部分
                        int right = Math.min((j + 1 < grid[0].length ? grid[i][j + 1] : 0), grid[i][j]);//右边被遮挡的部分
                        sideArea -= (front + behind + left + right);
                        result += sideArea;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}