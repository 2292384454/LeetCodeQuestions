package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class P1790CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new P1790CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        // TO TEST
    }

    //Java：仅执行一次字符串交换能否使两个字符串相等
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 != len2) {
                return false;
            }
            LinkedList<Integer> diffIndexList = new LinkedList<>();
            for (int i = 0; i < len1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffIndexList.add(i);
                    if (diffIndexList.size() > 2) {
                        return false;
                    }
                }
            }
            if (diffIndexList.size() == 2) {
                int i = diffIndexList.get(0);
                int j = diffIndexList.get(1);
                return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
            } else {
                return diffIndexList.size() == 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}