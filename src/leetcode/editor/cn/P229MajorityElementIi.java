//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 362 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：求众数 II
public class P229MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new P229MajorityElementIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            // 定义两个候选者和它们的票数
            int cand1 = 0, cand2 = 0;
            int cnt1 = 0, cnt2 = 0;
            // 投票过程
            for (int num : nums) {
                // 如果是候选者1，票数++
                if (num == cand1) {
                    cnt1++;
                }
                    // 如果是候选者2，票数++
                else if (num == cand2) {
                    cnt2++;
                }
                    // 既不是cand1也不是cand2，如果cnt1为0，那它就去做cand1
                else if (cnt1 == 0) {
                    cand1 = num;
                    cnt1++;
                }
                // 如果cand1的数量不为0但是cand2的数量为0，那他就去做cand2
                else if (cnt2 == 0) {
                    cand2 = num;
                    cnt2++;
                } else {
                    // 如果cand1和cand2的数量都不为0，那就都-1
                    cnt1--;
                    cnt2--;
                }
            }
            // 检查两个票数符不符合
            cnt1 = 0;
            cnt2 = 0;
            for (int num : nums) {
                if (num == cand1) {
                    cnt1++;
                }
                    // 这里一定要用else if
                    // 因为可能出现[0,0,0]这种用例，导致两个cand是一样的，写两个if结果就变为[0,0]了
                else if (num == cand2) {
                    cnt2++;
                }
            }
            int n = nums.length;
            if (cnt1 > n / 3) {
                res.add(cand1);
            }
            if (cnt2 > n / 3) {
                res.add(cand2);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
