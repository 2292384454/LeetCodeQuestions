//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树 
// 👍 327 👎 0

package leetcode.editor.cn;

//Java：把二叉搜索树转换为累加树
public class P538ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new P538ConvertBstToGreaterTree().new Solution();
        Integer TreeVals[] = {5, 2, 13};
        TreeNode root = TreeNode.constructTree(TreeVals);
        System.out.println(solution.convertBST(root));
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
        int sum = 0;//定义成员变量（做全局变量）

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.right != null) {
                root.right = convertBST(root.right);
            }
            {
                sum += root.val;
                root.val = sum;
            }
            if (root.left != null) {
                root.left = convertBST(root.left);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}