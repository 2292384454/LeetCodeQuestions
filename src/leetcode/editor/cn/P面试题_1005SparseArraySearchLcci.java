package leetcode.editor.cn;
//Java：稀疏数组搜索

import java.util.ArrayList;

/**
 * <p>稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>: words = [&quot;at&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;ball&quot;, &quot;&quot;, &quot;&quot;, &quot;car&quot;, &quot;&quot;, &quot;&quot;,&quot;dad&quot;, &quot;&quot;, &quot;&quot;], s = &quot;ta&quot;
 * <strong> 输出</strong>：-1
 * <strong> 说明</strong>: 不存在返回-1。
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：words = [&quot;at&quot;, &quot;&quot;, &quot;&quot;, &quot;&quot;, &quot;ball&quot;, &quot;&quot;, &quot;&quot;, &quot;car&quot;, &quot;&quot;, &quot;&quot;,&quot;dad&quot;, &quot;&quot;, &quot;&quot;], s = &quot;ball&quot;
 * <strong> 输出</strong>：4
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * <li>words的长度在[1, 1000000]之间</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>数组</li><li>字符串</li><li>二分查找</li></div></div><p><div><li>👍 50</li><li>👎 0</li></div>
 */
public class P面试题_1005SparseArraySearchLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1005SparseArraySearchLcci().new Solution();
        // TO TEST
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(solution.findString(words, "ball"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findString(String[] words, String s) {
            // 保留所有非空字符串的索引
            ArrayList<Integer> notEmptyIndex = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 0) {
                    notEmptyIndex.add(i);
                }
            }
            int l = 0, r = notEmptyIndex.size() - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                String curStr = words[notEmptyIndex.get(mid)];
                int compare = stringCompare(curStr, s);
                if (compare == 0) {
                    return notEmptyIndex.get(mid);
                } else if (compare < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }

        private int stringCompare(String a, String b) {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return 1;
            }
            int len1 = a.length(), len2 = b.length();
            int manLen = Math.max(len1, len2);
            for (int i = 0; i < manLen; i++) {
                char c1 = i < len1 ? a.charAt(i) : '\0';
                char c2 = i < len2 ? b.charAt(i) : '\0';
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}