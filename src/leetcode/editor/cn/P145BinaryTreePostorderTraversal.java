//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 574 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
        // TO TEST
        Integer[] nums = new Integer[]{3, 1, 2};
        TreeNode root = TreeNode.constructTree(nums);
        System.out.println(solution.postorderTraversal(root));
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null, p = root;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            while (!stack.isEmpty()) {
                p = stack.peek();
                if (p.right == null || p.right == pre) {
                    ans.add(p.val);
                    pre = p;
                    stack.pop();
                } else {
                    p = p.right;
                    while (p != null) {
                        stack.push(p);
                        p = p.left;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
