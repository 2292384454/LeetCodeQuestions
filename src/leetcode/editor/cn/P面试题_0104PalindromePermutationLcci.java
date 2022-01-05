package leetcode.editor.cn;
//Java：回文排列

import java.util.HashMap;

/**
 * <p>给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。</p>
 *
 * <p>回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。</p>
 *
 * <p>回文串不一定是字典当中的单词。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例1：</strong></p>
 *
 * <pre><strong>输入：&quot;</strong>tactcoa&quot;
 * <strong>输出：</strong>true（排列有&quot;tacocat&quot;、&quot;atcocta&quot;，等等）
 * </pre>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>哈希表</li><li>字符串</li></div></div><p><div><li>👍 53</li><li>👎 0</li></div>
 */
public class P面试题_0104PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0104PalindromePermutationLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            int oddsCount = 0;
            for (Integer value : map.values()) {
                if ((value & 1) == 1) {
                    oddsCount++;
                }
            }
            return oddsCount <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}