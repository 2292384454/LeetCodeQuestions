//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 170 👎 0

package leetcode.editor.cn;

//Java：二叉搜索树的第k大节点
public class P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
        private int k = 0;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            return inOrder(root);
        }

        private Integer inOrder(TreeNode root) {
            if (root != null) {
                Integer left, right;
                if ((right = inOrder(root.right)) != null) {
                    return right;
                }
                if (--k == 0) {
                    return root.val;
                }
                if ((left = inOrder(root.left)) != null) {
                    return left;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}