//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串 
// 👍 52 👎 0

package leetcode.editor.cn;

//Java：学生出勤记录 I
public class P551StudentAttendanceRecordI {
    public static void main(String[] args) {
        Solution solution = new P551StudentAttendanceRecordI().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkRecord(String s) {
            if (s == "") return true;
            char s_chars[] = s.toCharArray();
            for (int i = 0, A_count = 0; i < s_chars.length; i++) {
                if (s_chars[i] == 'A') {
                    A_count++;
                    if (A_count > 1) return false;
                }
                if (i + 2 < s_chars.length && (s_chars[i] == 'L') && (s_chars[i + 1] == 'L') && (s_chars[i + 2] == 'L'))
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}