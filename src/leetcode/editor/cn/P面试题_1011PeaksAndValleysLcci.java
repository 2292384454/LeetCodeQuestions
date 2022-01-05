package leetcode.editor.cn;
//Java：峰与谷

import java.util.Arrays;

/**
 * <p>在一个整数数组中，&ldquo;峰&rdquo;是大于或等于相邻整数的元素，相应地，&ldquo;谷&rdquo;是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入: </strong>[5, 3, 1, 2, 3]
 * <strong>输出:</strong>&nbsp;[5, 1, 3, 2, 3]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>nums.length &lt;= 10000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>排序</li></div></div><p><div><li>👍 32</li><li>👎 0</li></div>
 */
public class P面试题_1011PeaksAndValleysLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1011PeaksAndValleysLcci().new Solution();
        // TO TEST
        int[] nums = new int[]{5, 3, 1, 2, 3};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            if (nums == null) {
                return;
            }
            int n = nums.length;
            // 拍完序之后从两头交替取
            Arrays.sort(nums);
            int[] ans = new int[n];
            for (int i = 0, l = 0, r = n - 1; i < n; i++) {
                if ((i & 1) == 0) {
                    ans[i] = nums[r--];
                } else {
                    ans[i] = nums[l++];
                }
            }
            System.arraycopy(ans, 0, nums, 0, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}