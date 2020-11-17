//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 数学 
// 👍 67 👎 0

package leetcode.editor.cn;

//Java：最大三角形面积
public class P812LargestTriangleArea {
    public static void main(String[] args) {
        Solution solution = new P812LargestTriangleArea().new Solution();
        // TO TEST
        int points[][] = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        System.out.println(solution.largestTriangleArea(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestTriangleArea(int[][] points) {
            int len = points.length;
            double result = 0;
            for (int i = 0; i < len; i++)
                for (int j = i + 1; j < len; j++)
                    for (int k = j + 1; k < len; k++) {
                        double ax = points[j][0] - points[i][0], ay = points[j][1] - points[i][1],
                                bx = points[j][0] - points[k][0], by = points[j][1] - points[k][1];
                        double area = Math.abs(ax * by - ay * bx) / 2;
                        result = Math.max(result, area);
                    }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}