package leetcode.editor.cn;
//Java：只出现一次的数字 

/**
 * <p>给你一个整数数组&nbsp;<code>nums</code> ，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次 。</strong>请你找出并返回那个只出现了一次的元素。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2,2,3,2]
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,1,0,1,0,1,100]
 * <strong>输出：</strong>100
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * <li><code>nums</code> 中，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次</strong></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 137&nbsp;题相同：<a href="https://leetcode-cn.com/problems/single-number-ii/">https://leetcode-cn.com/problems/single-number-ii/</a></p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_004WGki4K {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_004WGki4K().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bitCount = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32 && num != 0; i++, num >>>= 1) {
                    if ((num & 1) != 0) {
                        bitCount[i]++;
                    }
                }
            }
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                ans |= ((bitCount[i] % 3) << i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}