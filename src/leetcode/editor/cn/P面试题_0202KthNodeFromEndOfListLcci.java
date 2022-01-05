package leetcode.editor.cn;
//Java：返回倒数第 k 个节点

/**
 * <p>实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。</p>
 *
 * <p><strong>注意：</strong>本题相对原题稍作改动</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5 和 <em>k</em> = 2
 * <strong>输出： </strong>4</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>给定的 <em>k</em>&nbsp;保证是有效的。</p>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><p><div><li>👍 74</li><li>👎 0</li></div>
 */
public class P面试题_0202KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0202KthNodeFromEndOfListLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode left = head, right = head;
            for (int i = 0; i < k; i++) {
                right = right.next;
            }
            while (right != null) {
                left = left.next;
                right = right.next;
            }
            return left.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}