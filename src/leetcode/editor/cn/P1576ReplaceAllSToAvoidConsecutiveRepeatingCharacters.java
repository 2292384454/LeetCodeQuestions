package leetcode.editor.cn;

public class P1576ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P1576ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
        // TO TEST
    }

    //Java：替换所有的问号
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            return modifyString(s, "");
        }

        private String modifyString(String s, String pre) {
            if (s == null || ("").equals(s)) {
                return pre;
            } else if (s.charAt(0) == '?') {
                char preChar = ("").equals(pre) ? ' ' : pre.charAt(pre.length() - 1);
                char nextChar = s.length() < 2 ? ' ' : s.charAt(1);
                for (char c = 'a'; true; c++) {
                    if (c != preChar && c != nextChar) {
                        return modifyString(s.substring(1), pre + c);
                    }
                }
            } else {
                char c = s.charAt(0);
                return modifyString(s.substring(1), pre + c);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}