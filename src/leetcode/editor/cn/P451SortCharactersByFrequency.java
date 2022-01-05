package leetcode.editor.cn;
//Java：根据字符出现频率排序

import java.util.*;

/**
 * <p>给定一个字符串，请将字符串里的字符按照出现的频率降序排列。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 * &quot;tree&quot;
 *
 * <strong>输出:</strong>
 * &quot;eert&quot;
 *
 * <strong>解释:
 * </strong>&#39;e&#39;出现两次，&#39;r&#39;和&#39;t&#39;都只出现一次。
 * 因此&#39;e&#39;必须出现在&#39;r&#39;和&#39;t&#39;之前。此外，&quot;eetr&quot;也是一个有效的答案。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 * &quot;cccaaa&quot;
 *
 * <strong>输出:</strong>
 * &quot;cccaaa&quot;
 *
 * <strong>解释:
 * </strong>&#39;c&#39;和&#39;a&#39;都出现三次。此外，&quot;aaaccc&quot;也是有效的答案。
 * 注意&quot;cacaca&quot;是不正确的，因为相同的字母必须放在一起。
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 * &quot;Aabb&quot;
 *
 * <strong>输出:</strong>
 * &quot;bbAa&quot;
 *
 * <strong>解释:
 * </strong>此外，&quot;bbaA&quot;也是一个有效的答案，但&quot;Aabb&quot;是不正确的。
 * 注意&#39;A&#39;和&#39;a&#39;被认为是两种不同的字符。
 * </pre>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>桶排序</li><li>计数</li><li>排序</li><li>堆（优先队列）</li></div></div><p><div><li>👍 318</li><li>👎 0</li></div>
 */
public class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new P451SortCharactersByFrequency().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, 1 + map.getOrDefault(c, 0));
            }
            List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
            StringBuilder ans = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : entries) {
                char c = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}