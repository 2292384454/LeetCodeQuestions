package leetcode.editor.cn;
//Java：删除链表的倒数第 n 个结点

/**
 * <p>给定一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], n = 2
 * <strong>输出：</strong>[1,2,3,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], n = 1
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2], n = 1
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中结点的数目为 <code>sz</code></li>
 * <li><code>1 &lt;= sz &lt;= 30</code></li>
 * <li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * <li><code>1 &lt;= n &lt;= sz</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>能尝试使用一趟扫描实现吗？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 19&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/</a></p>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_021SLwz0R {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_021SLwz0R().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode fast = head, virtualHead = new ListNode(), slow = virtualHead;
            virtualHead.next = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow.next != null) {
                slow.next = slow.next.next;
            }
            return virtualHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}