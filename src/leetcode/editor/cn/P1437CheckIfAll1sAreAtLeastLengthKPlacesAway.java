//给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
//
// 
//
// 示例 1： 
//
// 
//
// 输入：nums = [1,0,0,0,1,0,0,1], k = 2
//输出：true
//解释：每个 1 都至少相隔 2 个元素。 
//
// 示例 2： 
//
// 
//
// 输入：nums = [1,0,0,1,0,1], k = 2
//输出：false
//解释：第二个 1 和第三个 1 之间只隔了 1 个元素。 
//
// 示例 3： 
//
// 输入：nums = [1,1,1,1,1], k = 0
//输出：true
// 
//
// 示例 4： 
//
// 输入：nums = [0,1,0,1], k = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 0 <= k <= nums.length 
// nums[i] 的值为 0 或 1 
// 
// Related Topics 数组 
// 👍 9 👎 0

package leetcode.editor.cn;

//Java：是否所有 1 都至少相隔 k 个元素
public class P1437CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public static void main(String[] args) {
        Solution solution = new P1437CheckIfAll1sAreAtLeastLengthKPlacesAway().new Solution();
        // TO TEST
        int[] arr = new int[]{1, 0, 0, 1, 0, 1};
        System.out.println(solution.kLengthApart(arr, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            int lastOne = -9999999;
            int i = 0;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    if (i - lastOne - 1 < k) {
                        return false;
                    }
                    lastOne = i;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
