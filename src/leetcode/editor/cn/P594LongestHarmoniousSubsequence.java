//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表 
// 👍 123 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：最长和谐子序列
public class P594LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new P594LongestHarmoniousSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.findLHS(new int[]{-3, -1, -1, -1, -3, -2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int result = 0;
            HashMap<Integer, Short> num_count = new HashMap<>();
            for (int x : nums) {
                short count = num_count.containsKey(x) ? num_count.get(x) : 0;
                num_count.put(x, (short) (count + 1));
            }
            Integer keys[] = num_count.keySet().toArray(new Integer[num_count.size()]);
            Arrays.sort(keys);
            for (int i = 1; i < keys.length; i++) {
                if (keys[i] - keys[i - 1] == 1) {
                    result = Math.max(result, num_count.get(keys[i - 1]) + num_count.get(keys[i]));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}