package leetcode.editor.cn;
//Java：反转链表

/**
 * <p>给定单链表的头节点 <code>head</code> ，请反转链表，并返回反转后的链表的头节点。</p>
 *
 * <div class="original__bRMd">
 * <div>
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 302px; " />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5]
 * <strong>输出：</strong>[5,4,3,2,1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 102px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2]
 * <strong>输出：</strong>[2,1]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点的数目范围是 <code>[0, 5000]</code></li>
 * <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？</p>
 * </div>
 * </div>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 206&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/reverse-linked-list/">https://leetcode-cn.com/problems/reverse-linked-list/</a></p>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_024UHnkqh {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_024UHnkqh().new Solution();
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
        public ListNode reverseList(ListNode head) {
            ListNode virtualHead = new ListNode();
            ListNode p = head;
            while (p != null) {
                ListNode next = p.next;
                p.next = virtualHead.next;
                virtualHead.next = p;
                p = next;
            }
            return virtualHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}