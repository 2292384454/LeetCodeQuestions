//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 107 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Java：N叉树的后序遍历
public class P590NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();
        // TO TEST
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> postorder(Node root) {
            Stack<Node> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.val);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}