package leetcode.editor.cn;
//Java：回文链表

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>编写一个函数，检查输入的链表是否是回文的。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入： </strong>1-&gt;2
 * <strong>输出：</strong> false
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入： </strong>1-&gt;2-&gt;2-&gt;1
 * <strong>输出：</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong><br>
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 73</li><li>👎 0</li></div>
 */
public class P面试题_0206PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0206PalindromeLinkedListLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            Deque<Integer> stack = new LinkedList<>();
            ListNode p = head, q = head;
            while (q != null && q.next != null) {
                stack.push(p.val);
                p = p.next;
                q = q.next.next;
            }
            if (q != null) {
                // 如果 q!=null ，那么链表总长度是奇数， p 指向正中间
                // 需要把 p 右移一位
                p = p.next;
            }
            while (!stack.isEmpty()) {
                if (p.val != stack.pop()) {
                    return false;
                }
                p = p.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}