package leetcode.editor.cn;
//Java：变位词组

import java.util.*;

/**
 * <p>编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。</p>
 *
 * <p><strong>注意：</strong>本题相对原题稍作修改</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;]</code>,
 * <strong>输出:</strong>
 * [
 * [&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;],
 * [&quot;nat&quot;,&quot;tan&quot;],
 * [&quot;bat&quot;]
 * ]</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li>所有输入均为小写字母。</li>
 * <li>不考虑答案输出的顺序。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 77</li><li>👎 0</li></div>
 */
public class P面试题_1002GroupAnagramsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1002GroupAnagramsLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            int n = strs.length;
            TreeMap<String, List<Integer>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String sortedStr = new String(chars);
                List<Integer> indexs = map.getOrDefault(sortedStr, new ArrayList<>());
                indexs.add(i);
                map.put(sortedStr, indexs);
            }
            map.forEach((str, indexs) -> {
                List<String> tempList = new ArrayList<>();
                if (indexs != null) {
                    for (int index : indexs) {
                        tempList.add(strs[index]);
                    }
                }
                ans.add(tempList);
            });
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}