//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 452 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：找到所有数组中消失的数字
public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
        int array[] = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println((solution.findDisappearedNumbers(array)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length, max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
                while (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            List<Integer> ans = new ArrayList<>(n - max);
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}