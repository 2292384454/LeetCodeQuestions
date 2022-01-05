//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 471 👎 0

package leetcode.editor.cn;

//Java：最长同值路径
public class P687LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new P687LongestUnivaluePath().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            helper(root);
            return ans;
        }

        /**
         * @return 从root向下，具有与root相同结点值的最长路径的长度，不考虑形如 /\ 的形式，必须是向下的.
         */
        private int helper(TreeNode root) {
            if (root != null) {
                int ret = 0, len = 0;
                int l = helper(root.left);
                int r = helper(root.right);
                if (root.left != null && root.val == root.left.val) {
                    len += (l + 1);
                    ret = Math.max(ret, l + 1);
                }
                if (root.right != null && root.val == root.right.val) {
                    len += (r + 1);
                    ret = Math.max(ret, r + 1);
                }
                // 理解 helper 函数时可以先忽略掉这一行计算 ans 的代码以及与变量 len 相关的代码
                ans = Math.max(ans, len);
                return ret;
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}