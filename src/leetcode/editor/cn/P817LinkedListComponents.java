package leetcode.editor.cn;

public class P817LinkedListComponents{
    public static void main(String[] args) {
        Solution solution = new P817LinkedListComponents().new Solution();
        // TO TEST
    }
    //Java：链表组件
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
        public int numComponents(ListNode head, int[] nums) {
            // kevinhwang@20221012：本题的实质就是，在链表中仅保留在 nums 中出现过的数字，最终链表会被划分成几段，这个段数即为结果。
            int listLen = 0, ret = 0;
            ListNode p = head;
            while (p != null) {
                p = p.next;
                listLen++;
            }
            boolean[] appeared = new boolean[listLen];
            for (int num : nums) {
                appeared[num] = true;
            }
            p = head;
            // 初始将 p 指向链表中第一个（在数组中）出现过的数
            while (p != null && !appeared[p.val]) {
                p = p.next;
            }
            while (p != null) {
                // p向右滑动至下一个未（在数组中）出现过的数
                while (p != null && appeared[p.val]) {
                    p = p.next;
                }
                ret++;
                // p向右滑动至下一个（在数组中）出现过的数
                while (p != null && !appeared[p.val]) {
                    p = p.next;
                }
            }
            return ret;
        }
    }

//runtime:1 ms
//memory:41.8 MB

//leetcode submit region end(Prohibit modification and deletion)

}