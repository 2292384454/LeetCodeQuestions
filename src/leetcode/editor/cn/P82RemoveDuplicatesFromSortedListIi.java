//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 485 👎 0

package leetcode.editor.cn;


import java.util.HashSet;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
        ListNode head = new ListNode(1), p = head;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(2);
        solution.deleteDuplicates(head);
        System.out.println("END");
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            HashSet<Integer> repeatedValues = new HashSet<>();
            ListNode p = head, q = p;
            while (p != null) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                    repeatedValues.add(q.val);
                }
                q = q.next;
                p.next = q;
                p = p.next;
            }
            while (head != null && repeatedValues.contains(head.val)) {
                head = head.next;
            }
            p = head;
            while (p != null && p.next != null) {
                if (repeatedValues.contains(p.next.val)) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
