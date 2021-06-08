//给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。 
//
// 
//
// 示例: 
//
// 输入:
//[1,2,3]
//
//输出:
//3
//
//解释:
//只需要3次移动（注意每次移动会增加两个元素的值）：
//
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数学 
// 👍 142 👎 0

package leetcode.editor.cn;

//Java：最小移动次数使数组元素相等
public class P453MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new P453MinimumMovesToEqualArrayElements().new Solution();
        // TO TEST
        int nums[] = {1, 2, 3};
        System.out.println(solution.minMoves(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int result = 0, minvalue = nums[0];
            for (int x : nums) {
                if (x < minvalue) {
                    minvalue = x;
                }
            }
            for (int x : nums) {
                result += (x - minvalue);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}