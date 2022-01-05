//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

//Java：两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1_1 = new P2AddTwoNumbers().new ListNode(1);
        //ListNode l1_2 = new P2AddTwoNumbers().new ListNode(4);
        //ListNode l1_3 = new P2AddTwoNumbers().new ListNode(3);
        //l1_1.next = l1_2;
        //l1_2.next = l1_3;
        ListNode l2_1 = new P2AddTwoNumbers().new ListNode(9);
        ListNode l2_2 = new P2AddTwoNumbers().new ListNode(9);
        //ListNode l2_3 = new P2AddTwoNumbers().new ListNode(4);
        l2_1.next = l2_2;
        //l2_2.next = l2_3;
        ListNode test = solution.addTwoNumbers(l1_1, l2_1);
        ListNode p = test;
        while (p != null) {
            System.out.print(p.val + ">");
            p = p.next;
        }
        System.out.println("null");
    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p = l1, q = l2, head = new ListNode(0), tail = head;
            int carry = 0, x = 0, y = 0;
            while (p != null || q != null) {
                x = (p != null) ? p.val : 0;
                y = (q != null) ? q.val : 0;
                tail.next = new ListNode((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
                tail = tail.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}