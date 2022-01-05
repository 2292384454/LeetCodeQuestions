//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 
// 👍 161 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：重复的DNA序列
public class P187RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        // TO TEST
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int len = s.length();
            Set<String> ansSet = new HashSet<>();
            if (len < 10) {
                return new ArrayList<>();
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= len - 10; i++) {
                String subStr = s.substring(i, i + 10);
                if (set.contains(subStr)) {
                    ansSet.add(subStr);
                } else {
                    set.add(subStr);
                }
            }
            return new ArrayList<>(ansSet);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
