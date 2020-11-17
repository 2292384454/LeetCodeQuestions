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
            if (root == null || root.left == null || root.right == null || root.left.val == root.right.val) return -1;
            if (root.val == root.left.val)
                return Math.min(helper(root.left, root.val, root.right.val), root.right.val);
            else
                return Math.min(helper(root.right, root.val, root.left.val), root.left.val);
        }

        /**
         * @param root 输入根节点
         * @param low  下限
         * @param high 上限
         * @return 返回以root为根节点的树中在区间(low, high)中的最小值
         */
        public int helper(TreeNode root, int low, int high) {
            if (root == null) return high;
            if (root.val < high && root.val > low)
                high = root.val;
            high = Math.min(helper(root.left, low, high), high);
            high = Math.min(helper(root.right, low, high), high);
            return high;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}