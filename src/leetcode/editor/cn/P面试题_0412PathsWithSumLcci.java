package leetcode.editor.cn;
//Java：求和路径

/**
 * <p>给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。</p>
 *
 * <p><strong>示例:</strong><br>
 * 给定如下二叉树，以及目标和&nbsp;<code>sum = 22</code>，</p>
 *
 * <pre>              5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * </pre>
 *
 * <p>返回:</p>
 *
 * <pre>3
 * <strong>解释：</strong>和为 22&nbsp;的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]</pre>
 *
 * <p>提示：</p>
 *
 * <ul>
 * <li><code>节点总数 &lt;= 10000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 76</li><li>👎 0</li></div>
 */
public class P面试题_0412PathsWithSumLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0412PathsWithSumLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int ans = 0;

        public int pathSum(TreeNode root, int sum) {
            dfs(root, sum, false);
            return ans;
        }

        private void dfs(TreeNode root, int sum, boolean hasStarted) {
            if (root == null) {
                return;
            }
            if (root.val == sum) {
                ans++;
            }
            // 注意这里到 root.val == sum 之后不截止，因为可能沿着这条路径还有，比如 sum 为 12 时，[5,7,6,-6]这条路径
            dfs(root.left, sum - root.val, true);
            dfs(root.right, sum - root.val, true);
            if (!hasStarted) {
                // 本题不一定从根节点开始，所有还有这两个递归
                dfs(root.left, sum, false);
                dfs(root.right, sum, false);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}