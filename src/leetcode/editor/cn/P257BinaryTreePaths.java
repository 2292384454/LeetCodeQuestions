//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 312 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的所有路径
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(solution.binaryTreePaths(root));

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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> mystack = new Stack<>();//后根遍历搜索辅助堆栈
            TreeNode p, last = null;//last指向上一次被遍历的结点
            //进行后序遍历
            mystack.push(root);
            while (!mystack.empty()) {
                while (mystack.peek().left != null) {
                    mystack.push(mystack.peek().left);
                }
                while (!mystack.empty()) {
                    p = mystack.peek();
                    if (p.right == null || p.right == last) {
                        if (p.left == null && p.right == null) {//如果被访问的结点是叶子结点，那么将堆栈中此时所有结点的值按顺序添加到字符串中
                            int i = 0;
                            StringBuilder temp = new StringBuilder();
                            for (; i < mystack.size() - 1; i++) {
                                temp.append(mystack.elementAt(i).val + "->");
                            }
                            temp.append(mystack.elementAt(i).val + "");
                            result.add(temp.toString());
                        }
                        last = p;
                        mystack.pop();
                    } else if (p != null) {
                        mystack.push(p.right);
                        break;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}