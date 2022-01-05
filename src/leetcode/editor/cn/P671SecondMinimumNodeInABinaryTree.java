//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。。
// 
//
// 示例 2: 
//
// 输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树 
// 👍 117 👎 0

package leetcode.editor.cn;

//Java：二叉树中第二小的节点
public class P671SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P671SecondMinimumNodeInABinaryTree().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{2, 2, 2});
        System.out.println(solution.findSecondMinimumValue(root));
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
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null) {
                return -1;
            }
            long ans = helper(root, root.val);
            if (ans > Integer.MAX_VALUE) {
                ans = -1;
            }
            return (int) ans;
        }

        /**
         * @param root 输入根节点
         * @return 返回以 root 为根节点的树中大于 rootVal 的第一个值，如果没有就返回  Integer.MAX_VALUE+1
         */
        public long helper(TreeNode root, int rootVal) {
            if (root == null) {
                return Integer.MAX_VALUE + 1L;
            }
            if (root.val > rootVal) {
                return root.val;
            }
            if (root.left != null && root.right != null) {
                return Math.min(helper(root.left, rootVal), helper(root.right, rootVal));
            }
            return Integer.MAX_VALUE + 1L;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}