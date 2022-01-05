//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 247 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：Excel表列名称
public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();
            LinkedList<Integer> nums = new LinkedList<>();
            while (n > 0) {
                nums.add((--n) % 26);//这里用--n是因为A-Z对应的是1-26而不是0-25
                n /= 26;
            }
            for (int x : nums) {
                result.insert(0, (char) ('A' + x));
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}