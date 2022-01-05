package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P剑指_Offer_II_055KTOapQ {
    public static void main(String[] args) {
        BSTIterator solution = new P剑指_Offer_II_055KTOapQ().new BSTIterator(null);
        // TO TEST
    }
    //Java：二叉搜索树迭代器
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
    class BSTIterator {
        private int cur = 0;
        private List<Integer> vals = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            inorder(root);
        }

        public int next() {
            return vals.get(cur++);
        }

        public boolean hasNext() {
            return cur < vals.size();
        }

        private void inorder(TreeNode root) {
            if (root != null) {
                inorder(root.left);
                vals.add(root.val);
                inorder(root.right);
            }
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}