//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 983 👎 0

package leetcode.editor.cn;

//Java：环形链表 II
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // TO TEST
        ListNode head = new ListNode(3);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        ListNode thenode = p;
        p.next = new ListNode(0);
        p = p.next;
        p.next = new ListNode(-4);
        p = p.next;
        p.next = thenode;
        System.out.println(solution.detectCycle(head).val);
        System.out.println("pause");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            //快慢指针
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null && slow != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null || slow == null) {
                return null;
            }
            //到这里之后fast（slow）指向环中同一个节点，如果把环从这里断开，那么就转换成了找两个找到两个单链表相交的起始节点(leetcode160题)
            ListNode head2 = fast.next, ptr;
            int len1 = 0, len2 = 0;//如果把环从fast(slow)断开后两个链表的长度
            ptr = head;
            while (ptr != head2) {
                len1++;
                ptr = ptr.next;
            }
            ptr = head2.next;
            len2++;
            while (ptr != head2) {
                len2++;
                ptr = ptr.next;
            }
            //longList指向较长的链表（如果断开）
            ListNode longList = len1 > len2 ? head : head2;
            ListNode shortList = len1 <= len2 ? head : head2;
            ptr = longList;
            int n = Math.abs(len1 - len2);
            while (n > 0) {
                ptr = ptr.next;
                n--;
            }
            while (ptr != shortList) {
                ptr = ptr.next;
                shortList = shortList.next;
            }
            return ptr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
