package leetcode.editor.cn;
//Java：数组中和为 0 的三个数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>给定一个包含 <code>n</code> 个整数的数组&nbsp;<code>nums</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在三个元素&nbsp;<code>a</code> ，<code>b</code> ，<code>c</code> <em>，</em>使得&nbsp;<code>a + b + c = 0</code> ？请找出所有和为 <code>0</code> 且&nbsp;<strong>不重复&nbsp;</strong>的三元组。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
 * <strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0]
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 3000</code></li>
 * <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 15&nbsp;题相同：<a href="https://leetcode-cn.com/problems/3sum/">https://leetcode-cn.com/problems/3sum/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_007OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_007OneFGaJU().new Solution();
        // TO TEST
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                // 对 i 去重
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1, k = n - 1; j < n - 1 && k > j; j++) {
                        // 对 j 去重
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            // 向左移动 k 指针，直到 a+b+c 不大于 0
                            while (nums[i] + nums[j] + nums[k] > 0 && k > j) {
                                k--;
                            }
                            if (j == k) {
                                break;
                            }
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}