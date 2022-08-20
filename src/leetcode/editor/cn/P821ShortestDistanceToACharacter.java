package leetcode.editor.cn;

import java.util.Arrays;

public class P821ShortestDistanceToACharacter {
    public static void main(String[] args) {
        Solution solution = new P821ShortestDistanceToACharacter().new Solution();
        // TO TEST
    }

    //Java：字符的最短距离
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int len = s.length();
            int[] ans = new int[len];
            Arrays.fill(ans, len);
            ans[0] = s.charAt(0) == c ? 0 : len;
            ans[len - 1] = s.charAt(len - 1) == c ? 0 : len;
            for (int i = 1; i < len; i++) {
                ans[i] = Math.min(ans[i], (s.charAt(i) == c ? 0 : ans[i - 1] + 1));
                ans[len - 1 - i] = Math.min(ans[len - 1 - i], (s.charAt(len - 1 - i) == c ? 0 : ans[len - i] + 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}