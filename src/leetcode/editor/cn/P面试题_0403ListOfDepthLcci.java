package leetcode.editor.cn;
//Java：特定深度节点链表

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 <code>D</code>，则会创建出 <code>D</code> 个链表）。返回一个包含所有深度的链表的数组。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>[1,2,3,4,5,null,7,8]
 *
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 *
 * <strong>输出：</strong>[[1],[2,3],[4,5,7],[8]]
 * </pre>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>链表</li><li>二叉树</li></div></div><p><div><li>👍 54</li><li>👎 0</li></div>
 */
public class P面试题_0403ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0403ListOfDepthLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }
            ArrayList<ListNode> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            ans.add(new ListNode(tree.val));
            while (!queue.isEmpty()) {
                int size = queue.size();
                ListNode fakeHead = new ListNode();
                ListNode p = fakeHead;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.add(cur.left);
                        p.next = new ListNode(cur.left.val);
                        p = p.next;
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                        p.next = new ListNode(cur.right.val);
                        p = p.next;
                    }
                }
                if (fakeHead.next != null) {
                    ans.add(fakeHead.next);
                }
            }
            return ans.toArray(new ListNode[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}