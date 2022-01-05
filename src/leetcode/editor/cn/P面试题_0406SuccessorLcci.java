package leetcode.editor.cn;
//Java：后继者

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>设计一个算法，找出二叉搜索树中指定节点的&ldquo;下一个&rdquo;节点（也即中序后继）。</p>
 *
 * <p>如果指定节点没有对应的&ldquo;下一个&rdquo;节点，则返回<code>null</code>。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> root = <code>[2,1,3], p = 1
 *
 * 2
 * / \
 * 1   3
 * </code>
 * <strong>输出:</strong> 2</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> root = <code>[5,3,6,2,4,null,null,1], p = 6
 *
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * </code>
 * <strong>输出:</strong> null</pre>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><p><div><li>👍 67</li><li>👎 0</li></div>
 */
public class P面试题_0406SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0406SuccessorLcci().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(solution.inorderSuccessor(root, root.left.left.left));
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
            TreeNode cur;
            //如果 p 有右子树，返回它右子树的最左下节点
            if (p.right != null) {
                cur = p.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            }
            // 否则二分查找找到 p ，记录下路径
            // TODO:如果树中有与 p 值相同的节点，这里就会出问题，因为这样可能永远找不到 p 陷入死循环
            Deque<TreeNode> stack = new LinkedList<>();
            cur = root;
            while (cur != p) {
                stack.push(cur);
                if (cur.val < p.val) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            if (stack.isEmpty()) {
                // 如果 path 为空，说明 p 是根节点并且没有右子树，返回 null
                return null;
            }
            // 如果 p 是左子节点，返回 parent
            if (stack.peek().left == p) {
                return stack.peek();
            }
            // 如果 p 是右子节点，向上遍历直到当前节点是左子节点然后返回父节点
            while (true) {
                cur = stack.poll();
                if (stack.isEmpty()) {
                    return null;
                }
                if (stack.peek().left == cur) {
                    return stack.peek();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}