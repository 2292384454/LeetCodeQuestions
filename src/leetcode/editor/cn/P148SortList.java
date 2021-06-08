//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1117 👎 0

package leetcode.editor.cn;

//Java：排序链表
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(solution.sortList(head));
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
        //非递归法归并排序
        public ListNode sortList(ListNode head) {
            ListNode h, h1, h2, pre, virtualHead;
            h = head;
            int length = 0, step = 1, leftLen, rightLen;
            //计算出链表长度
            while (h != null) {
                h = h.next;
                length++;
            }
            //创建虚拟头结点，排完序的链表跟在它后面
            virtualHead = new ListNode(0);
            virtualHead.next = head;
            while (step < length) {
                pre = virtualHead;
                h = virtualHead.next;
                while (h != null) {
                    for (leftLen = 0, h1 = h; leftLen < step && h != null; leftLen++) {
                        h = h.next;
                    }
                    if (leftLen < step) {
                        break;
                    }
                    for (rightLen = 0, h2 = h; rightLen < step && h != null; rightLen++) {
                        h = h.next;
                    }
                    //合并左右部分
                    while (leftLen > 0 && rightLen > 0) {
                        if (h1.val < h2.val) {
                            pre.next = h1;
                            h1 = h1.next;
                            leftLen--;
                        } else {
                            pre.next = h2;
                            h2 = h2.next;
                            rightLen--;
                        }
                        pre = pre.next;
                    }
                    pre.next = leftLen == 0 ? h2 : h1;
                    while (leftLen > 0 || rightLen > 0) {
                        pre = pre.next;
                        leftLen--;
                        rightLen--;
                    }
                    pre.next = h;
                }
                step <<= 1;
            }
            return virtualHead.next;
        }
        /*
        //递归法归并排序
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            //快慢节点找中间，最终slow指向中间节点（如果是链表编号是1,2,...2n，slow会指向n-1号节点）
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);//递归排序前半部分
            ListNode right = sortList(tmp);//递归排序后半部分
            ListNode h = new ListNode(0);
            ListNode res = h;
            //合并左右两部分
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
