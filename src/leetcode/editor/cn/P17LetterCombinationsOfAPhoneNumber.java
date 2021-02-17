//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1128 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("3"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            int len = digits.length();
            if (len == 0) return ans;
            int num = digits.charAt(len - 1) - '0', start = (num - 2) * 3, count = 3;
            if (num == 7 || num == 9) count++;
            if (num > 7) start++;
            if (digits.length() == 1) {
                for (int i = start; i < start + count; i++)
                    ans.add((char) (i + 'a') + "");
            } else {
                List<String> pre = letterCombinations(digits.substring(0, len - 1));
                for (String str : pre) {
                    for (int i = start; i < start + count; i++)
                        ans.add(str + (char) (i + 'a'));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
