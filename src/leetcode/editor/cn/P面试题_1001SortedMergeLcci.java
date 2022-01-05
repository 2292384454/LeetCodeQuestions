package leetcode.editor.cn;
//Java：合并排序的数组

import java.util.Arrays;

/**
 * <p>给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。</p>
 *
 * <p>初始化&nbsp;A 和 B 的元素数量分别为&nbsp;<em>m</em> 和 <em>n</em>。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * <strong>输出:</strong>&nbsp;[1,2,2,3,5,6]</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li><code>A.length == n + m</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><p><div><li>👍 111</li><li>👎 0</li></div>
 */
public class P面试题_1001SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1001SortedMergeLcci().new Solution();
        // TO TEST
        int[] A = new int[]{1, 2, 3, 0, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        solution.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            // 为了节约空间，从后往前遍历，取大的放进 A 中
            int i = m - 1, j = n - 1, k = A.length - 1;
            while (i >= 0 && j >= 0) {
                if (A[i] > B[j]) {
                    A[k--] = A[i--];
                } else {
                    A[k--] = B[j--];
                }
            }
            while (i >= 0) {
                A[k--] = A[i--];
            }
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}