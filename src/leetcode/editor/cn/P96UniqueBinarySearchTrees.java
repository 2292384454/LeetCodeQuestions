//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1091 👎 0

package leetcode.editor.cn;

//Java：不同的二叉搜索树
public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            if (n <= 2) {
                return n;//如果n为1，那么只有一种情况；如果n为2，那么有[1,null,2]和[2,1,null]两种情况
            }
            int[] dp = new int[n + 1];//动态规划数组，dp[i]存储i个节点组成二叉搜索树可能的情况种数
            dp[0] = 1;//如果0个节点那么就是[null]一种情况
            dp[1] = 1;//如果1个节点那么就是[a]一种情况
            dp[2] = 2;//如果2个节点那么就是[a,null,b]和[b,a,null]两种情况（a<b)
            //对从3到n的情况进行遍历，填充dp数组
            for (int i = 3; i <= n; i++) {
                //根节点左边的节点个数可能从0到i-1
                for (int j = 0; j < i; j++) {
                    //左子树可能的情况数乘以右子树可能的情况数
                    dp[i] += (dp[j] * dp[i - j - 1]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
