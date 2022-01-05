package leetcode.editor.cn;
//Java：变位词组

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>给定一个字符串数组 <code>strs</code> ，将&nbsp;<strong>变位词&nbsp;</strong>组合在一起。 可以按任意顺序返回结果列表。</p>
 *
 * <p><strong>注意：</strong>若两个字符串中每个字符出现的次数都相同且<strong>字符顺序不完全相同</strong>，则称它们互为变位词。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> strs = <code>[&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;]</code>
 * <strong>输出: </strong>[[&quot;bat&quot;],[&quot;nat&quot;,&quot;tan&quot;],[&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;]]</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> strs = <code>[&quot;&quot;]</code>
 * <strong>输出: </strong>[[&quot;&quot;]]
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> strs = <code>[&quot;a&quot;]</code>
 * <strong>输出: </strong>[[&quot;a&quot;]]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
 * <li><code>strs[i]</code>&nbsp;仅包含小写字母</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 49&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/group-anagrams/">https://leetcode-cn.com/problems/group-anagrams/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_033Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_033Sfvd7V().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}