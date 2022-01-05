package leetcode.editor.cn;
//Java：节点之和最大的路径

/**
 * <p><strong>路径</strong> 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 <strong>至多出现一次</strong> 。该路径<strong> 至少包含一个 </strong>节点，且不一定经过根节点。</p>
 *
 * <p><strong>路径和</strong> 是路径中各节点值的总和。</p>
 *
 * <p>给定一个二叉树的根节点 <code>root</code> ，返回其 <strong>最大路径和</strong>，即所有路径上节点值之和的最大值。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2,3]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>最优路径是 2 -&gt; 1 -&gt; 3 ，路径和为 2 + 1 + 3 = 6</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [-10,9,20,null,null,15,7]
 * <strong>输出：</strong>42
 * <strong>解释：</strong>最优路径是 15 -&gt; 20 -&gt; 7 ，路径和为 15 + 20 + 7 = 42
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数目范围是 <code>[1, 3 * 10<sup>4</sup>]</code></li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 124&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>动态规划</li><li>二叉树</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_051JC7MId {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_051JC7MId().new Solution();
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
        public int maxPathSum(TreeNode root) {
            helper(root);
            return ans;
        }

        int ans = Integer.MIN_VALUE;

        /**
         * 返回从 root 开始向下能达到的最大路径和
         */
        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = Math.max(helper(root.left), 0);
            int r = Math.max(helper(root.right), 0);
            ans = Math.max(ans, root.val + l + r);
            return Math.max(l, r) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}