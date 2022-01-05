//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode p = l1, q = l2, result = new ListNode(), r = result, temp = null;
            while (p != null || q != null) {
                int p_val = Integer.MAX_VALUE, q_val = Integer.MAX_VALUE;
                if (p != null) {
                    p_val = p.val;
                }
                if (q != null) {
                    q_val = q.val;
                }
                if (p_val < q_val) {
                    temp = new ListNode(p_val);
                    r.next = temp;
                    r = r.next;
                    p = p.next;
                } else {
                    temp = new ListNode(q_val);
                    r.next = temp;
                    r = r.next;
                    q = q.next;
                }
            }
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}