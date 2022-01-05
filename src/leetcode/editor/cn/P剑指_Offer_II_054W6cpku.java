package leetcode.editor.cn;

public class P剑指_Offer_II_054W6cpku {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_054W6cpku().new Solution();
        // TO TEST
    }
    //Java：所有大于等于节点的值之和
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
        TreeNode preNode = null;

        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                root.val += preNode == null ? 0 : preNode.val;
                preNode = root;
                convertBST(root.left);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}