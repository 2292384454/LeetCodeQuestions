package leetcode.editor.cn;
//Java：得到子序列的最少操作次数

import java.util.*;

/**
 * <p>给你一个数组 <code>target</code> ，包含若干 <strong>互不相同</strong> 的整数，以及另一个整数数组 <code>arr</code> ，<code>arr</code> <strong>可能</strong> 包含重复元素。</p>
 *
 * <p>每一次操作中，你可以在 <code>arr</code> 的任意位置插入任一整数。比方说，如果 <code>arr = [1,4,1,2]</code> ，那么你可以在中间添加 <code>3</code> 得到 <code>[1,4,<strong>3</strong>,1,2]</code> 。你可以在数组最开始或最后面添加整数。</p>
 *
 * <p>请你返回 <strong>最少</strong> 操作次数，使得<em> </em><code>target</code><em> </em>成为 <code>arr</code> 的一个子序列。</p>
 *
 * <p>一个数组的 <strong>子序列</strong> 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，<code>[2,7,4]</code> 是 <code>[4,<strong>2</strong>,3,<strong>7</strong>,2,1,<strong>4</strong>]</code> 的子序列（加粗元素），但 <code>[2,4,2]</code> 不是子序列。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><b>输入：</b>target = [5,1,3], <code>arr</code> = [9,4,2,3,4]
 * <b>输出：</b>2
 * <b>解释：</b>你可以添加 5 和 1 ，使得 arr 变为 [<strong>5</strong>,9,4,<strong>1</strong>,2,3,4] ，target 为 arr 的子序列。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>target = [6,4,8,1,3,2], <code>arr</code> = [4,7,6,2,3,8,6,1]
 * <b>输出：</b>3
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= target.length, arr.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= target[i], arr[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>target</code> 不包含任何重复元素。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>哈希表</li><li>二分查找</li></div></div><p><div><li>👍 93</li><li>👎 0</li></div>
 */
public class P1713MinimumOperationsToMakeASubsequence {
    public static void main(String[] args) {
        Solution solution = new P1713MinimumOperationsToMakeASubsequence().new Solution();
        // TO TEST
        int[] target = new int[]{15, 14, 20, 11, 9, 10, 5, 1, 19, 3};
        int[] arr = new int[]{17, 20, 13, 7, 1, 3, 10, 9, 15, 14};
        System.out.println(solution.minOperations(target, arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 本题即先找到 target 和 arr 的最长公共子序列长度 len ，然后 target.length()减去 len 即是所求
         */
        public int minOperations(int[] target, int[] arr) {
            int tLen = target.length, aLen = arr.length;
            // map 存储 target 的元素与索引
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tLen; ++i) {
                map.put(target[i], i);
            }
            // 对于 target 中的元素定义一种“大小关系”：出现较早的为小，出现较晚的为大
            // d[i] 中存放长度为 i 的最长公共子序列的末尾元素的最 “小” 值
            // d 将保证 “有序”
            int[] d = new int[aLen + 1];
            int len = 0;
            for (int val : arr) {
                if (map.containsKey(val)) {
                    if (len == 0) {
                        // 只执行一次，将第一个同时出现于两个数组的的元素记录到 len[1]
                        d[++len] = val;
                        continue;
                    }
                    int valPos = map.get(val);
                    if (valPos > map.get(d[len])) {
                        d[++len] = val;
                    }
                    // 在 d 数组中二分查找，找到比 val “小” 的最 “大” 值，将它的下一个设置成 val
                    // 如果找不到说明所有的数都比 val 出现得晚，此时要更新 d[1]，所以这里将 pos 设为 0
                    int l = 1, r = len, pos = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (map.get(d[mid]) >= valPos) {
                            r = mid - 1;
                        } else {
                            pos = mid;
                            l = mid + 1;
                        }
                    }
                    d[pos + 1] = val;
                }
            }
            return tLen - len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}