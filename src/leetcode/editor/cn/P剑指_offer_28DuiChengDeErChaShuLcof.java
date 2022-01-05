//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 183 👎 0

package leetcode.editor.cn;

//Java：对称的二叉树
public class P剑指_offer_28DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_28DuiChengDeErChaShuLcof().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(solution.isSymmetric(root));
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return help(root.left, root.right);
        }

        private boolean help(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                // 若左右节点都为 null
                return true;
            } else if (left == null || right == null) {
                // 左右节点有且只有一个不为 null
                return false;
            } else {
                // 左右节点都不为 null
                return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}