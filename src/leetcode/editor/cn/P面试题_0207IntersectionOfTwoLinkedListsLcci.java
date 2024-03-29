package leetcode.editor.cn;
//Java：链表相交

/**
 * <p>给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。</p><br><p><strong>示例 1：</strong><pre><strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3<br><strong>输出：</strong>Reference of the node with value = 8<br><strong>输入解释：</strong>相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。</pre></p><br><p><strong>示例 2：</strong><pre><strong>输入：</strong>intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1<br><strong>输出：</strong>Reference of the node with value = 2<br><strong>输入解释：</strong>相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。</pre></p><br><p><strong>示例 3：</strong><pre><strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2<br><strong>输出：</strong>null<br><strong>输入解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。<br><strong>解释：</strong>这两个链表不相交，因此返回 null。</pre></p><br><p><strong>注意：</strong></p><ul><li>如果两个链表没有交点，返回 <code>null</code> 。</li><li>在返回结果后，两个链表仍须保持原有的结构。</li><li>可假定整个链表结构中没有循环。</li><li>程序尽量满足 O(<em>n</em>) 时间复杂度，且仅用 O(<em>1</em>) 内存。</li></ul><div><div>Related Topics</div><div><li>哈希表</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 86</li><li>👎 0</li></div>
 */
public class P面试题_0207IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0207IntersectionOfTwoLinkedListsLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 先取得两个链表的长度
            int lenA = 0, lenB = 0;
            ListNode p = headA, q = headB;
            while (p != null) {
                p = p.next;
                lenA++;
            }
            while (q != null) {
                q = q.next;
                lenB++;
            }
            // 转换成 "Y" 形
            ListNode longer = lenA > lenB ? headA : headB;
            ListNode shorter = lenA > lenB ? headB : headA;
            int sub = Math.abs(lenA - lenB);
            p = longer;
            q = shorter;
            while (sub > 0) {
                p = p.next;
                sub--;
            }
            // 同步遍历找公共结点
            while (p != null && q != null) {
                if (p == q) {
                    return p;
                }
                p = p.next;
                q = q.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}