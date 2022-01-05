package leetcode.editor.cn;
//Java：二叉树中的最大路径和

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p><strong>路径</strong> 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 <strong>至多出现一次</strong> 。该路径<strong> 至少包含一个 </strong>节点，且不一定经过根节点。</p>
 *
 * <p><strong>路径和</strong> 是路径中各节点值的总和。</p>
 *
 * <p>给你一个二叉树的根节点 <code>root</code> ，返回其 <strong>最大路径和</strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" />
 * <pre>
 * <strong>输入：</strong>root = [-10,9,20,null,null,15,7]
 * <strong>输出：</strong>42
 * <strong>解释：</strong>最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数目范围是 <code>[1, 3 * 10<sup>4</sup>]</code></li>
 * <li><code>-1000 <= Node.val <= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>动态规划</li><li>二叉树</li></div></div><p><div><li>👍 1138</li><li>👎 0</li></div>
 */
public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 3});
        // TreeNode root = TreeNode.constructTree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        System.out.println(solution.maxPathSum(root));
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
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return ans;
        }

        /**
         * 计算 root 的最大贡献值：以 root 为起点向下的最大路径和
         */
        private int maxGain(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);
            ans = Math.max(ans, leftGain + rightGain + root.val);
            return Math.max(leftGain, rightGain) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}