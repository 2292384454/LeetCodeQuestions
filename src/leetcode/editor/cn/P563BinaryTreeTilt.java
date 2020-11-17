//给定一个二叉树，计算整个树的坡度。 
//
// 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。 
//
// 整个树的坡度就是其所有节点的坡度之和。 
//
// 
//
// 示例： 
//
// 输入：
//         1
//       /   \
//      2     3
//输出：1
//解释：
//结点 2 的坡度: 0
//结点 3 的坡度: 0
//结点 1 的坡度: |2-3| = 1
//树的坡度 : 0 + 0 + 1 = 1
// 
//
// 
//
// 提示： 
//
// 
// 任何子树的结点的和不会超过 32 位整数的范围。 
// 坡度的值不会超过 32 位整数的范围。 
// 
// Related Topics 树 
// 👍 86 👎 0

package leetcode.editor.cn;

//Java：二叉树的坡度
public class P563BinaryTreeTilt {
    public static void main(String[] args) {
        Solution solution = new P563BinaryTreeTilt().new Solution();
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
        int result = 0;

        public int findTilt(TreeNode root) {
            ReturnSumAndCalculateTilt(root);
            return result;
        }

        /**
         * @param root 传入根节点
         * @return 返回以root为根节点的树的val的和，并且计算结点root的坡度加入到result中
         */
        public int ReturnSumAndCalculateTilt(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftsum = ReturnSumAndCalculateTilt(root.left);
                int rightsum = ReturnSumAndCalculateTilt(root.right);
                result += Math.abs(leftsum - rightsum);
                return root.val + leftsum + rightsum;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}