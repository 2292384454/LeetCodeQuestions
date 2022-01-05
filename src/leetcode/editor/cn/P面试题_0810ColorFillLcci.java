package leetcode.editor.cn;
//Java：颜色填充

import java.util.Arrays;

/**
 * <p>编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。</p>
 *
 * <p>待填充的图像用二维数组 <code>image</code> 表示，元素为初始颜色值。初始坐标点的行坐标为 <code>sr</code> 列坐标为 <code>sc</code>。需要填充的新颜色为 <code>newColor</code> 。</p>
 *
 * <p>「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。</p>
 *
 * <p>请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * <strong>输出</strong>：[[2,2,2],[2,2,0],[2,0,1]]
 * <strong>解释</strong>:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>image</code> 和 <code>image[0]</code> 的长度均在范围 [1, 50] 内。</li>
 * <li>初始坐标点 <code>(sr,sc)</code> 满足 <code>0 <= sr < image.length</code> 和 <code>0 <= sc < image[0].length</code> 。</li>
 * <li><code>image[i][j]</code> 和 <code>newColor</code> 表示的颜色值在范围 <code>[0, 65535]</code> 内。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>数组</li><li>矩阵</li></div></div><p><div><li>👍 33</li><li>👎 0</li></div>
 */
public class P面试题_0810ColorFillLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0810ColorFillLcci().new Solution();
        // TO TEST
        int[][] image = new int[][]{{0, 0, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(solution.floodFill(image, 1, 1, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            //新值和旧值相等就没必要图了
            if (newColor == image[sr][sc]) {
                return image;
            }
            dfs(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }

        public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
            //越界或者这个点不能图就返回
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
                return;
            }
            //图色+四个方向扩散
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, oldColor);
            dfs(image, sr + 1, sc, newColor, oldColor);
            dfs(image, sr, sc - 1, newColor, oldColor);
            dfs(image, sr, sc + 1, newColor, oldColor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}