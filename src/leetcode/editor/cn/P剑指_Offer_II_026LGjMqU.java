package leetcode.editor.cn;
//Java：重排链表

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>给定一个单链表 <code>L</code><em> </em>的头节点 <code>head</code> ，单链表 <code>L</code> 表示为：</p>
 *
 * <p><code>&nbsp;L<sub>0&nbsp;</sub>&rarr; L<sub>1&nbsp;</sub>&rarr; &hellip; &rarr; L<sub>n-1&nbsp;</sub>&rarr; L<sub>n&nbsp;</sub></code><br />
 * 请将其重新排列后变为：</p>
 *
 * <p><code>L<sub>0&nbsp;</sub>&rarr;&nbsp;L<sub>n&nbsp;</sub>&rarr;&nbsp;L<sub>1&nbsp;</sub>&rarr;&nbsp;L<sub>n-1&nbsp;</sub>&rarr;&nbsp;L<sub>2&nbsp;</sub>&rarr;&nbsp;L<sub>n-2&nbsp;</sub>&rarr; &hellip;</code></p>
 *
 * <p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1626420311-PkUiGI-image.png" style="width: 240px; " /></p>
 *
 * <pre>
 * <strong>输入: </strong>head = [1,2,3,4]
 * <strong>输出: </strong>[1,4,2,3]</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1626420320-YUiulT-image.png" style="width: 320px; " /></p>
 *
 * <pre>
 * <strong>输入: </strong>head = [1,2,3,4,5]
 * <strong>输出: </strong>[1,5,2,4,3]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表的长度范围为 <code>[1, 5 * 10<sup>4</sup>]</code></li>
 * <li><code>1 &lt;= node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 143&nbsp;题相同：<a href="https://leetcode-cn.com/problems/reorder-list/">https://leetcode-cn.com/problems/reorder-list/</a>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_026LGjMqU {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_026LGjMqU().new Solution();
        // TO TEST
        ListNode head = new ListNode(1);
        // ListNode p = head;
        // for (int i = 2; i <= 5; i++) {
        //     p.next = new ListNode(i);
        //     p = p.next;
        // }
        solution.reorderList(head);
        System.out.println(head);
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
        public void reorderList(ListNode head) {
            if (head.next == null) {
                return;
            }
            Queue<ListNode> lPart = new LinkedList<>();
            Deque<ListNode> rPart = new LinkedList<>();
            ListNode fast = head, slow = head, p = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 如果链表长度为奇数，那么正中间那个节点会放在 rPart
            while (p != slow) {
                ListNode next = p.next;
                p.next = null;
                lPart.add(p);
                p = next;
            }
            while (p != null) {
                ListNode next = p.next;
                p.next = null;
                rPart.push(p);
                p = next;
            }
            p = head;
            lPart.poll();
            boolean fromLeft = false;
            while (!(lPart.isEmpty() && rPart.isEmpty())) {
                p.next = fromLeft && !lPart.isEmpty() ? lPart.poll() : rPart.pop();
                fromLeft = !fromLeft;
                p = p.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}