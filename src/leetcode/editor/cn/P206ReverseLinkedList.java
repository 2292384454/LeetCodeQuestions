//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1168 👎 0

package leetcode.editor.cn;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * public class ListNode {
     * int val;
     * ListNode next;
     * <p>
     * ListNode(int x) {
     * val = x;
     * }
     * }
     **/
    class Solution {
        // 1、头插法
        // public ListNode reverseList(ListNode head) {
        //     if (head == null) {
        //         return null;
        //     }
        //     ListNode virtualHead = new ListNode(), p = head;
        //     while (p != null) {
        //         ListNode next = p.next;
        //         p.next = virtualHead.next;
        //         virtualHead.next = p;
        //         p = next;
        //     }
        //     return virtualHead.next;
        // }
        // 2、递归
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            // 记录下 head.next ，对 head 后面的部分翻转后它就是尾结点
            ListNode next = head.next;
            // 翻转 head 后面的部分
            ListNode reversed = reverseList(next);
            // 断开环
            head.next = null;
            // 头放到尾
            next.next = head;
            return reversed;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}