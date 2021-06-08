//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 112 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的堂兄弟节点
public class P993CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P993CousinsInBinaryTree().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 3, 4});
        System.out.println(solution.isCousins(root, 3, 4));
    }
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
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null || x == y) {
                return false;
            }
            TreeNode parent_x = null, parent_y = null, p = null;
            Queue<TreeNode> myqueue = new LinkedList<>();
            myqueue.add(root);
            while (!myqueue.isEmpty()) {
                int count = myqueue.size();
                for (int i = 0; i < count; i++) {
                    p = myqueue.poll();
                    if (p.left != null) {
                        myqueue.add(p.left);
                    }
                    if (p.right != null) {
                        myqueue.add(p.right);
                    }
                    if ((p.right != null && p.right.val == x) || (p.left != null && p.left.val == x)) {
                        parent_x = p;
                    }
                    if ((p.right != null && p.right.val == y) || (p.left != null && p.left.val == y)) {
                        parent_y = p;
                    }
                }
                if ((parent_x != null && parent_y == null) || (parent_y != null && parent_x == null))//如果在这一层找到了x的双亲但是没找到y的双亲，那么返回false
                {
                    return false;
                } else if (parent_x != null && parent_y != null && parent_x != parent_y)//如果这一层找到了x和y的双亲且他们互不相等，那么返回true
                {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
