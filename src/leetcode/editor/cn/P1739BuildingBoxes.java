//有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下： 
//
// 
// 你可以把盒子放在地板上的任何地方。 
// 如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。 
// 
//
// 给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3
//输出：3
//解释：上图是 3 个盒子的摆放位置。
//这些盒子放在房间的一角，对应左侧位置。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 4
//输出：3
//解释：上图是 3 个盒子的摆放位置。
//这些盒子放在房间的一角，对应左侧位置。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：n = 10
//输出：6
//解释：上图是 10 个盒子的摆放位置。
//这些盒子放在房间的一角，对应后方位置。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 109 
// 
// Related Topics 数学 二分查找 
// 👍 10 👎 0

package leetcode.editor.cn;

//Java：放置盒子
public class P1739BuildingBoxes {
    public static void main(String[] args) {
        Solution solution = new P1739BuildingBoxes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumBoxes(int n) {
            int bottom = 1;
            for (int sum = 1, height = 1; sum < n; height++) {
                for (int i = 0; i <= height && sum < n; i++) { // 每次增加 1 个底部盒子
                    bottom++;
                    sum += i + 1; // i 个是在上方堆叠的，不与地面接触
                }
            }
            return bottom;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
