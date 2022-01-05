package leetcode.editor.cn;

import java.util.ArrayList;

public class P剑指_Offer_II_056OpLdQZ {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_056OpLdQZ().new Solution();
        // TO TEST
    }
    //Java：二叉搜索树中两个节点之和
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
        ArrayList<Integer> list;

        public boolean findTarget(TreeNode root, int k) {
            list = new ArrayList<>();
            inOrder(root);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }
            return false;
        }

        private void inOrder(TreeNode root) {
            if (root != null) {
                inOrder(root.left);
                list.add(root.val);
                inOrder(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}