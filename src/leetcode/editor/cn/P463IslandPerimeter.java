//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 242 👎 0

package leetcode.editor.cn;

//Java：岛屿的周长
public class P463IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new P463IslandPerimeter().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int Perimeter = 0, wide = grid.length, height = grid[0].length, up, down, left, right;
            for (int i = 0; i < wide; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[i][j] == 1) {
                        //其实这里应当把计算一个岛屿能提供多少周长的功能模块化，更符合设计原则，但是这样会导致用时增加，
                        // 这里为了成绩好看所以直接写入了if中
                        //Perimeter += sideCount(grid, i, j);
                        up = j > 0 ? grid[i][j - 1] : 0;
                        down = j < height - 1 ? grid[i][j + 1] : 0;
                        left = i > 0 ? grid[i - 1][j] : 0;
                        right = i < wide - 1 ? grid[i + 1][j] : 0;
                        Perimeter += (4 - up - down - left - right);
                    }
                }
            }
            return Perimeter;
        }

/*        //计算该岛屿能提供多少周长
        public int sideCount(int[][] grid, int x, int y) {
            int wide = grid.length, height = grid[0].length;//整个地图的宽度和高度
            //上、下、左、右分别是否有邻居
            int up = y > 0 ? grid[x][y - 1] : 0;
            int down = y < height - 1 ? grid[x][y + 1] : 0;
            int left = x > 0 ? grid[x - 1][y] : 0;
            int right = x < wide - 1 ? grid[x + 1][y] : 0;
            //该岛屿能提供的周长就是4减去邻居数
            return 4 - up - down - left - right;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}