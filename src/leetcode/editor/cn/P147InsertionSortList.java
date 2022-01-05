//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 384 👎 0

package leetcode.editor.cn;

//Java：对链表进行插入排序
public class P147InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new P147InsertionSortList().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 2, 1, 3};
        ListNode head = new ListNode(nums);
        System.out.println(solution.insertionSortList(head));
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
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;//链表长度为0或1，直接返回
            }
            ListNode virtualHead = new ListNode();//添加一个虚拟头结点辅助插入
            virtualHead.next = head;
            ListNode pre = head, p = head.next;
            while (p != null) {
                ListNode next = p.next;
                //如果当前节点值大于或等于前一个节点值，直接移动后继续下一轮循环
                if (p.val >= pre.val) {
                    p = next;
                    pre = pre.next;
                    continue;
                }
                //找到要插入的位置
                ListNode q = virtualHead;
                while (q.next != null && q.next.val <= p.val) {
                    q = q.next;
                }
                //将p从原本的位置删除，插入到合适的位置
                pre.next = next;
                p.next = q.next;
                q.next = p;
                p = next;
            }
            return virtualHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
