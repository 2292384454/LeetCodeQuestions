//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 604 👎 0

package leetcode.editor.cn;

//Java：回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
        ListNode head = new P234PalindromeLinkedList().new ListNode(1);
        ListNode p = head;
        p.next = new P234PalindromeLinkedList().new ListNode(2);
        p = p.next;
        //p.next = new P234PalindromeLinkedList().new ListNode(2);
        //p = p.next;
        p.next = new P234PalindromeLinkedList().new ListNode(1);
        p = p.next;
        System.out.println(solution.isPalindrome(head));
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
        public boolean isPalindrome(ListNode head) {
            //如果链表为空或者链表只有一个元素，那么一定返回true
            if (head == null || head.next == null) return true;
            ListNode p = head, q = head, pre = null;
            //循环结束后p指向(int)(n/2)号节点，n为链表长度，索引从0开始
            while (q != null && q.next != null) {
                q = q.next.next;//q每次向后移动两个位置
                ListNode temp = p.next;//临时记录下p的后继节点
                p.next = pre;//p的next指针反向
                pre = p;//移动pre
                p = temp;//移动p
            }
            if (q != null) //链表长度为奇数，此时pre指向(int)(n/2)-1号元素，p指向(int)(n/2)号元素
                p = p.next;//p向后移动一位
            //判断是否回文
            while (p != null && pre != null) {
                if (p.val != pre.val)
                    return false;
                p = p.next;
                pre = pre.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}