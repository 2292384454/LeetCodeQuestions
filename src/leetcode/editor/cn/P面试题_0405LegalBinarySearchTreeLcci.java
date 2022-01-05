package leetcode.editor.cn;
//Java：合法二叉搜索树

/**
 * <p>实现一个函数，检查一棵二叉树是否为二叉搜索树。</p><strong>示例 1:</strong><pre><strong>输入:</strong><br>    2<br>   / &#92<br>  1   3<br><strong>输出:</strong> true<br></pre><strong>示例 2:</strong><pre><strong>输入:</strong><br>    5<br>   / &#92<br>  1   4<br>     / &#92<br>    3   6<br><strong>输出:</strong> false<br><strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。<br>     根节点的值为 5 ，但是其右子节点值为 4 。</pre><div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><p><div><li>👍 54</li><li>👎 0</li></div>
 */
public class P面试题_0405LegalBinarySearchTreeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0405LegalBinarySearchTreeLcci().new Solution();
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
        long pre = (long) Integer.MIN_VALUE - 1;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (isValidBST(root.left)) {
                // 左边得是一颗二叉搜索树
                // 判断递增
                if (pre >= root.val) {
                    return false;
                }
                pre = root.val;
                // 右边也得是一颗二叉搜索树
                return isValidBST(root.right);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}