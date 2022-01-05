//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 407 👎 0

package leetcode.editor.cn;


//Java：最短无序连续子数组
public class P581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 3, 3, 2, 4};
        System.out.println(solution.findUnsortedSubarray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            //初始化
            int len = nums.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int begin = 0, end = -1;
            //遍历
            for (int i = 0; i < len; i++) {
                if (nums[i] < max) {      //从左到右维持最大值，寻找右边界end
                    end = i;
                } else {
                    max = nums[i];
                }
                if (nums[len - i - 1] > min) {    //从右到左维持最小值，寻找左边界begin
                    begin = len - i - 1;
                } else {
                    min = nums[len - i - 1];
                }
            }
            return end - begin + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}