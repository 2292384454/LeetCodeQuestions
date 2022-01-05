package leetcode.editor.cn;
//Java：K 个一组翻转链表

/**
 * <p>给你一个链表，每 <em>k </em>个节点一组进行翻转，请你返回翻转后的链表。</p>
 *
 * <p><em>k </em>是一个正整数，它的值小于或等于链表的长度。</p>
 *
 * <p>如果节点总数不是 <em>k </em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>你可以设计一个只使用常数额外空间的算法来解决此问题吗？</li>
 * <li><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际进行节点交换。</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 2
 * <strong>输出：</strong>[2,1,4,3,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 3
 * <strong>输出：</strong>[3,2,1,4,5]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 1
 * <strong>输出：</strong>[1,2,3,4,5]
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], k = 1
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <ul>
 * </ul>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>列表中节点的数量在范围 <code>sz</code> 内</li>
 * <li><code>1 <= sz <= 5000</code></li>
 * <li><code>0 <= Node.val <= 1000</code></li>
 * <li><code>1 <= k <= sz</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><p><div><li>👍 1227</li><li>👎 0</li></div>
 */
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // TO TEST
        ListNode virtualHead = new ListNode();
        ListNode pre = virtualHead;
        for (int i = 0; i < 5; i++) {
            pre.next = new ListNode(i + 1);
            pre = pre.next;
        }
        System.out.println(solution.reverseKGroup(virtualHead.next, 3));
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
        public ListNode reverseKGroup(ListNode head, int k) {
            // 创建一个节点作为结果的虚拟头结点，最终返回 virtualHead.next
            ListNode virtualHead = new ListNode();
            // 逐段进行头插法翻转， segmentHead 指向本段开始的前一个节点， segmentTail 指向本段最后一个节点
            ListNode segmentHead = virtualHead, segmentTail = null;
            ListNode p = head;
            // count 计数，记录目前已经访问过的节点数量
            int count = 0;
            // 逐段进行头插
            while (p != null) {
                // 对于每一段的开始，它在翻转后必将成为这一段的 tail ，记录下来
                if (segmentHead.next == null) {
                    segmentTail = p;
                }
                ListNode next = p.next;
                p.next = segmentHead.next;
                segmentHead.next = p;
                count++;
                // 如果 count%k == 0 ，说明已经翻转完了一段，开始下一段，重新设置 segmentHead
                if (count % k == 0) {
                    segmentHead = segmentTail;
                }
                p = next;
            }
            // 如果最后一段长度不足 k 把最后一段再次翻转回来
            if (count % k != 0) {
                p = segmentHead.next;
                segmentHead.next = null;
                while (p != null) {
                    ListNode next = p.next;
                    p.next = segmentHead.next;
                    segmentHead.next = p;
                    p = next;
                }
            }
            return virtualHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}