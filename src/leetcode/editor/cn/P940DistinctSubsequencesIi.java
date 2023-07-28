package leetcode.editor.cn;

public class P940DistinctSubsequencesIi {
    public static void main(String[] args) {
        Solution solution = new P940DistinctSubsequencesIi().new Solution();
        // TO TEST
        String s = "aaa";
        System.out.println(solution.distinctSubseqII(s));
    }

    //Java：不同的子序列 II
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distinctSubseqII(String s) {
            final int MOD = 1000000007;
            int[] g = new int[26];//g[i]表示以字符 'a'+i 为最后一个字符的非空子序列的个数
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                int total = 1;
                for (int j = 0; j < 26; ++j) {
                    total = (total + g[j]) % MOD;
                }
                g[s.charAt(i) - 'a'] = total;
            }

            int ans = 0;
            for (int i = 0; i < 26; ++i) {
                ans = (ans + g[i]) % MOD;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}