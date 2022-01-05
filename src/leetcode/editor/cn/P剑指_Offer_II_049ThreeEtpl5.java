package leetcode.editor.cn;
//Java：从根节点到叶节点的路径数字之和

/**
 * <p>给定一个二叉树的根节点 <code>root</code> ，树中每个节点都存放有一个 <code>0</code> 到 <code>9</code> 之间的数字。</p>
 *
 * <div class="original__bRMd">
 * <div>
 * <p>每条从根节点到叶节点的路径都代表一个数字：</p>
 *
 * <ul>
 * <li>例如，从根节点到叶节点的路径 <code>1 -&gt; 2 -&gt; 3</code> 表示数字 <code>123</code> 。</li>
 * </ul>
 *
 * <p>计算从根节点到叶节点生成的 <strong>所有数字之和</strong> 。</p>
 *
 * <p><strong>叶节点</strong> 是指没有子节点的节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg" style="width: 212px; height: 182px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3]
 * <strong>输出：</strong>25
 * <strong>解释：</strong>
 * 从根到叶子节点路径 <code>1-&gt;2</code> 代表数字 <code>12</code>
 * 从根到叶子节点路径 <code>1-&gt;3</code> 代表数字 <code>13</code>
 * 因此，数字总和 = 12 + 13 = <code>25</code></pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg" style="width: 292px; height: 302px;" />
 * <pre>
 * <strong>输入：</strong>root = [4,9,0,5,1]
 * <strong>输出：</strong>1026
 * <strong>解释：</strong>
 * 从根到叶子节点路径 <code>4-&gt;9-&gt;5</code> 代表数字 495
 * 从根到叶子节点路径 <code>4-&gt;9-&gt;1</code> 代表数字 491
 * 从根到叶子节点路径 <code>4-&gt;0</code> 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = <code>1026</code>
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点的数目在范围 <code>[1, 1000]</code> 内</li>
 * <li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * <li>树的深度不超过 <code>10</code></li>
 * </ul>
 * </div>
 * </div>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 129&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_049ThreeEtpl5 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_049ThreeEtpl5().new Solution();
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

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode root, int num) {
            if (root == null) {
                return;
            }
            num = num * 10 + root.val;
            if (root.left == null && root.right == null) {
                ans += num;
            }
            if (root.left != null) {
                dfs(root.left, num);
            }
            if (root.right != null) {
                dfs(root.right, num);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}