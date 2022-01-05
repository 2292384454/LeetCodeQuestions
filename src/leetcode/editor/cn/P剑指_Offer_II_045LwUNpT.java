package leetcode.editor.cn;
//Java：二叉树最底层最左边的值

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>给定一个二叉树的 <strong>根节点</strong> <code>root</code>，请找出该二叉树的&nbsp;<strong>最底层&nbsp;最左边&nbsp;</strong>节点的值。</p>
 *
 * <p>假设二叉树中至少有一个节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2020/12/14/tree1.jpg" style="width: 182px; " /></p>
 *
 * <pre>
 * <strong>输入: </strong>root = [2,1,3]
 * <strong>输出: </strong>1
 * </pre>
 *
 * <p><strong>示例 2: </strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2020/12/14/tree2.jpg" style="width: 242px; " /><strong> </strong></p>
 *
 * <pre>
 * <strong>输入: </strong>[1,2,3,4,null,5,6,null,null,7]
 * <strong>输出: </strong>7
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li>二叉树的节点个数的范围是 <code>[1,10<sup>4</sup>]</code></li>
 * <li><meta charset="UTF-8" /><code>-2<sup>31</sup>&nbsp;&lt;= Node.val &lt;= 2<sup>31</sup>&nbsp;- 1</code>&nbsp;</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 513&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/find-bottom-left-tree-value/">https://leetcode-cn.com/problems/find-bottom-left-tree-value/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_045LwUNpT {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_045LwUNpT().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            int ans = root.val;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        ans = node.val;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}