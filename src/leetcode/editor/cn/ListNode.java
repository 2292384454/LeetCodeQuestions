package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 从数组创建链表（KevinHwang20210502）
     *
     * @param nums 链表值
     */
    ListNode(int[] nums) {
        if (nums == null || nums.length == 0) return;
        ListNode p = null, next = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            p = new ListNode(nums[i], next);
            next = p;
        }
        this.val = p.val;
        this.next = p.next;
    }

    /**
     * 链表转成字符串输出（KevinHwang20210502）
     *
     * @return 链表转成字符串
     */
    @Override
    public String toString() {
        StringBuilder strSB = new StringBuilder("[");
        ListNode p = this;
        while (p.next != null) {
            strSB.append(p.val).append(",");
            p = p.next;
        }
        strSB.append(p.val).append("]");
        return strSB.toString();
    }
}
