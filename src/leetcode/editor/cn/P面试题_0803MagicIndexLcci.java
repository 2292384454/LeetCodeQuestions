package leetcode.editor.cn;
//Java：魔术索引

/**
 * <p>魔术索引。 在数组<code>A[0...n-1]</code>中，有所谓的魔术索引，满足条件<code>A[i] = i</code>。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：nums = [0, 2, 3, 4, 5]
 * <strong> 输出</strong>：0
 * <strong> 说明</strong>: 0下标的元素为0
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：nums = [1, 1, 1]
 * <strong> 输出</strong>：1
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * <li>nums长度在[1, 1000000]之间</li>
 * <li>此题为原书中的 Follow-up，即数组中可能包含重复元素的版本</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><p><div><li>👍 96</li><li>👎 0</li></div>
 */
public class P面试题_0803MagicIndexLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0803MagicIndexLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMagicIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (i == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}