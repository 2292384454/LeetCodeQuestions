//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

package leetcode.editor.cn;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        // TO TEST
        ListNode l = new P83RemoveDuplicatesFromSortedList().new ListNode(1);
        ListNode p = l;
        p.next = new P83RemoveDuplicatesFromSortedList().new ListNode(1);
        p = p.next;
        p.next = new P83RemoveDuplicatesFromSortedList().new ListNode(1);
        ListNode l1 = solution.deleteDuplicates(l);
        p = l1;
        while (p != null) {
            System.out.println(p.val + "->");
            p = p.next;
        }

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode p = head;
            if (head != null) {
                while (p.next != null) {
                    if (p.val == p.next.val)
                        p.next = p.next.next;
                    else
                        p = p.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}