package leetcode.editor.cn;

public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
        // TO TEST
    }
    //Java：路径总和 III
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
        int ans = 0;

        public int pathSum(TreeNode root, int targetSum) {
            helper(root, targetSum, false);
            return ans;
        }

        private void helper(TreeNode root, int targetSum, boolean hasPre) {
            if (root != null) {
                if (root.val == targetSum) {
                    ans++;
                }
                if (!hasPre) {
                    helper(root.left, targetSum, false);
                    helper(root.right, targetSum, false);
                }
                helper(root.left, targetSum - root.val, true);
                helper(root.right, targetSum - root.val, true);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}