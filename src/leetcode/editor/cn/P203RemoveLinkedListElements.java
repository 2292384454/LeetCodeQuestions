//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 429 👎 0

package leetcode.editor.cn;

//Java：移除链表元素
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        // TO TEST
        ListNode head = new P203RemoveLinkedListElements().new ListNode(1);
        ListNode p = head;
        p.next = new P203RemoveLinkedListElements().new ListNode(2);
        p = p.next;
        p.next = new P203RemoveLinkedListElements().new ListNode(6);
        p = p.next;
        p.next = new P203RemoveLinkedListElements().new ListNode(3);
        p = p.next;
        p.next = new P203RemoveLinkedListElements().new ListNode(4);
        p = p.next;
        p.next = new P203RemoveLinkedListElements().new ListNode(5);
        p = p.next;
        p.next = new P203RemoveLinkedListElements().new ListNode(6);
        ListNode q = solution.removeElements(head, 6);
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode p = new ListNode(0), q = p;
            p.next = head;
            while (p.next != null) {
                if (p.next.val == val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return q.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}