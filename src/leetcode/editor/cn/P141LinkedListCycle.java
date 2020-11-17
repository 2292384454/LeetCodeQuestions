//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针 
// 👍 708 👎 0

package leetcode.editor.cn;

//Java：环形链表
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        // TO TEST
        ListNode head = new P141LinkedListCycle().new ListNode(3);
        ListNode p = head;
        p.next = new P141LinkedListCycle().new ListNode(2);
        p = p.next;
        ListNode thenode = p;
        p.next = new P141LinkedListCycle().new ListNode(0);
        p = p.next;
        p.next = new P141LinkedListCycle().new ListNode(-4);
        p = p.next;
        p.next = thenode;
        System.out.println(solution.hasCycle(head));
        System.out.println("pause");
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode pre = head, p = head.next;
            pre.next = null;
            while (p.next != null) {
                ListNode temp = p.next;
                p.next = pre;
                pre = p;
                p = temp;
            }
            if (p == head)
                return true;
            else
                return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}