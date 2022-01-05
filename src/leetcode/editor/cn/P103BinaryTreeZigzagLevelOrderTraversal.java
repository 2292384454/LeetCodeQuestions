//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 435 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的锯齿形层序遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        // TO TEST
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode p;
            queue.add(root);
            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    p = queue.poll();
                    assert p != null;
                    if (leftToRight) {
                        tmp.addLast(p.val);
                    } else {
                        tmp.addFirst(p.val);
                    }
                    if (p.left != null) {
                        queue.add(p.left);
                    }
                    if (p.right != null) {
                        queue.add(p.right);
                    }

                }
                ans.add(tmp);
                leftToRight = !leftToRight;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
