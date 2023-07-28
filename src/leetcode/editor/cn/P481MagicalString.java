package leetcode.editor.cn;

public class P481MagicalString {
    public static void main(String[] args) {
        Solution solution = new P481MagicalString().new Solution();
        // TO TEST
        System.out.println(solution.magicalString(100));
    }

    //Java：神奇字符串
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            if (n == 1) {
                return 1;
            }
            byte[] str = new byte[n];
            str[0] = 1;
            str[1] = 2;
            int cur = 0, ans = 0;
            byte num = 1;
            for (int i = 0; i < n; i++) {
                ans +=(str[i] == 1 ? 1 : 0);
                int tar = Math.min(n, cur + str[i]);
                for (int j = cur; j < tar; j++) {
                    str[j] = num;
                }
                cur = tar;
                num = (byte) (3 - num);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}