package leetcode.editor.cn;
//Java：检查平衡性

/**
 * <p>实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。</p><br><strong>示例 1:</strong><pre>给定二叉树 [3,9,20,null,null,15,7]<br>    3<br>   / &#92<br>  9  20<br>    /  &#92<br>   15   7<br>返回 true 。</pre><strong>示例 2:</strong><br><pre>给定二叉树 [1,2,2,3,3,null,null,4,4]<br>      1<br>     / &#92<br>    2   2<br>   / &#92<br>  3   3<br> / &#92<br>4   4<br>返回 false 。</pre><div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 61</li><li>👎 0</li></div>
 */
public class P面试题_0404CheckBalanceLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0404CheckBalanceLcci().new Solution();
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
        boolean ans = true;

        public boolean isBalanced(TreeNode root) {
            DFS(root);
            return ans;
        }

        public int DFS(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = DFS(root.left);
            int rightDepth = DFS(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                ans = false;
            }
            return 1 + (Math.max(leftDepth, rightDepth));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}