package leetcode.editor.cn;
//Java：回文链表

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>给定一个链表的 <strong>头节点&nbsp;</strong><code>head</code><strong>&nbsp;，</strong>请判断其是否为回文链表。</p>
 *
 * <p>如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><strong><img alt="" src="https://pic.leetcode-cn.com/1626421737-LjXceN-image.png" /></strong></p>
 *
 * <pre>
 * <strong>输入:</strong> head = [1,2,3,3,2,1]
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><strong><img alt="" src="https://pic.leetcode-cn.com/1626422231-wgvnWh-image.png" style="width: 138px; height: 62px;" /></strong></p>
 *
 * <pre>
 * <strong>输入:</strong> head = [1,2]
 * <strong>输出:</strong> fasle
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表 L 的长度范围为 <code>[1, 10<sup><span style="font-size: 9.449999809265137px;">5</span></sup>]</code></li>
 * <li><code>0&nbsp;&lt;= node.val &lt;= 9</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>能否用&nbsp;O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 234&nbsp;题相同：<a href="https://leetcode-cn.com/problems/palindrome-linked-list/">https://leetcode-cn.com/problems/palindrome-linked-list/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_027AMhZSa {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_027AMhZSa().new Solution();
        // TO TEST
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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode p = head;
            Deque<ListNode> stack = new LinkedList<>();
            while (p != slow) {
                stack.push(p);
                p = p.next;
            }
            if (fast != null) {
                // 这时说明链表长度为奇数， p==slow 指向正中间
                // 向后移动一位
                p = p.next;
            }
            while (p != null) {
                if (stack.pop().val != p.val) {
                    return false;
                }
                p = p.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}