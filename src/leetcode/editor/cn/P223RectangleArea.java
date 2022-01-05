//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学 
// 👍 110 👎 0

package leetcode.editor.cn;

//Java：矩形面积
public class P223RectangleArea {
    public static void main(String[] args) {
        Solution solution = new P223RectangleArea().new Solution();
        // TO TEST
        System.out.println(
                solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int left = Math.max(A, E);//重叠部分左边界
            int right = Math.min(C, G);//重叠部分右边界
            int up = Math.min(D, H);//重叠部分上边界
            int down = Math.max(B, F);//重叠部分下边界
            int overlapArea = 0;//重叠部分面积
            //检测是否重叠
            if (right > left && up > down) {
                overlapArea = (right - left) * (up - down);
            }
            return (C - A) * (D - B) + (G - E) * (H - F)
                    - overlapArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
