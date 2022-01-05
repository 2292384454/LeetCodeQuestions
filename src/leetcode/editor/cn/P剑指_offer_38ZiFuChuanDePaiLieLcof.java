//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 290 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：字符串的排列
public class P剑指_offer_38ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_38ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ans = new ArrayList<>();

        public String[] permutation(String s) {
            int len = s.length();
            // 标记每一位字符是否可用(即没被用过)
            // 初始状态 s 的每一位都可用
            int available = (1 << len) - 1;
            // 使用 Arrays.sort() 方法对字符串进行排序
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            // 调用回溯方法计算结果
            helper(sorted, "", available);
            return ans.toArray(new String[0]);
        }

        // 回溯
        private void helper(String s, String str, int available) {
            // 如果所有字符都使用过了，那么 str 就是一个结果
            if (available == 0) {
                ans.add(str);
                return;
            }
            // pre 记录上一个使用的字符，用来去重
            char pre = ' ';
            for (int i = 0, flag = 1; i < s.length(); i++, flag <<= 1) {
                char cur = s.charAt(i);
                if ((available & flag) != 0) {
                    // 去重
                    if (i > 0 && cur == pre) {
                        continue;
                    }
                    pre = cur;
                    // 递归调用
                    helper(s, str + cur, available ^ flag);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}