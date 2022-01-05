package leetcode.editor.cn;
//Java：移除重复节点

import java.util.HashSet;

/**
 * <p>编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：[1, 2, 3, 3, 2, 1]
 * <strong> 输出</strong>：[1, 2, 3]
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：[1, 1, 1, 1, 2]
 * <strong> 输出</strong>：[1, 2]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>链表长度在[0, 20000]范围内。</li>
 * <li>链表元素在[0, 20000]范围内。</li>
 * </ol>
 *
 * <p> <strong>进阶：</strong></p>
 *
 * <p>如果不得使用临时缓冲区，该怎么解决？</p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 110</li><li>👎 0</li></div>
 */
public class P面试题_0201RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0201RemoveDuplicateNodeLcci().new Solution();
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
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            HashSet<Integer> visited = new HashSet<>();
            visited.add(head.val);
            ListNode p = head, cur = head.next;
            while (cur != null) {
                while (cur != null && visited.contains(cur.val)) {
                    cur = cur.next;
                }
                p.next = cur;
                if (cur != null) {
                    visited.add(cur.val);
                }
                p = p.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}