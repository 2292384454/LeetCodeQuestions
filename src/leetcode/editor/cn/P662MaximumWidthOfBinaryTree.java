package leetcode.editor.cn;
//Java：二叉树最大宽度

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与<strong>满二叉树（full binary tree）</strong>结构相同，但一些节点为空。</p>
 *
 * <p>每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的<code>null</code>节点也计入长度）之间的长度。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 *
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 *
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 *
 * 1
 * /
 * 3
 * / \
 * 5   3
 *
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 *
 * 1
 * / \
 * 3   2
 * /
 * 5
 *
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * </pre>
 *
 * <p><strong>示例 4:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 *
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * <strong>输出:</strong> 8
 * <strong>解释:</strong> 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * </pre>
 *
 * <p><strong>注意:</strong> 答案在32位有符号整数的表示范围内。</p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 236</li><li>👎 0</li></div>
 */
public class P662MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P662MaximumWidthOfBinaryTree().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, null, 7});
        System.out.println(solution.widthOfBinaryTree(root));
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
        int ans;
        // 记录每一层的最左节点的 pos
        Map<Integer, Integer> left;

        public int widthOfBinaryTree(TreeNode root) {
            ans = 0;
            left = new HashMap();
            dfs(root, 0, 1);
            return ans;
        }

        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) return;
            left.putIfAbsent(depth, pos);
            ans = Math.max(ans, pos - left.get(depth) + 1);
            dfs(root.left, depth + 1, 2 * pos);
            dfs(root.right, depth + 1, 2 * pos + 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}