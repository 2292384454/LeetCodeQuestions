package leetcode.editor.cn;
//Java：二叉搜索树中的中序后继

import java.util.Deque;
import java.util.LinkedList;

public class P剑指_Offer_II_053P5rCT8 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_053P5rCT8().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(solution.inorderSuccessor(root, root.left.right));
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
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            Deque<TreeNode> stack = new LinkedList<>();
            // 先找到 p 的祖先节点
            TreeNode cur = root;
            while (cur != p) {
                stack.push(cur);
                cur = cur.val > p.val ? cur.left : cur.right;
            }
            if (p.right != null) {
                cur = p.right;
                // 如果 p 有右孩子，那么返回它右子树的最左子节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            } else {
                if (stack.isEmpty()) {
                    return null;
                }
                TreeNode parent;
                // 如果 p 没有右孩子，那么返回它自下向上第一个是“左子节点”（或者根节点）的祖先
                while (!stack.isEmpty()) {
                    parent = stack.pop();
                    if (parent.left == cur) {
                        return parent;
                    }
                    cur = parent;
                }
                return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}