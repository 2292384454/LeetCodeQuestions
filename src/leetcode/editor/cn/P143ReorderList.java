//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 574 👎 0

package leetcode.editor.cn;

//Java：重排链表
public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(nums);
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
            if (head == null || head.next == null) {
                return;
            }
            ListNode fast = head, slow = head, pre = null;
            //完成这轮循环后slow指向链表最中间的节点（如果链表长度是双数，那么slow指向最中间位置偏右的那个节点）
            while (fast != null && fast.next != null && slow != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            //把链表从中间断开（后半部分长度>=前半部分长度）
            pre.next = null;
            //把后半部分逆序
            ListNode p = slow;
            ListNode virtualHeadOfRightReverse = new ListNode(0);
            while (p != null) {
                ListNode next = p.next;
                p.next = virtualHeadOfRightReverse.next;
                virtualHeadOfRightReverse.next = p;
                p = next;
            }
            ListNode head2 = virtualHeadOfRightReverse.next;
            //把后半部分交错插入到前半部分
            p = head;
            ListNode q = head2;
            while (p != null && q != null) {
                ListNode p_next = p.next;
                ListNode q_next = q.next;
                q.next = p_next;
                p.next = q;
                pre = q;
                p = p_next;
                q = q_next;
            }
            //如果后半部分长度比前半部分多1，这一步补上最后一个元素
            pre.next = q;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
