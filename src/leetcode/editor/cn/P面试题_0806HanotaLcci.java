package leetcode.editor.cn;
//Java：汉诺塔问题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:<br>
 * (1) 每次只能移动一个盘子;<br>
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;<br>
 * (3) 盘子只能叠在比它大的盘子上。</p>
 *
 * <p>请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。</p>
 *
 * <p>你需要原地修改栈。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：A = [2, 1, 0], B = [], C = []
 * <strong> 输出</strong>：C = [2, 1, 0]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：A = [1, 0], B = [], C = []
 * <strong> 输出</strong>：C = [1, 0]
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * <li>A中盘子的数目不大于14个。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>递归</li><li>数组</li></div></div><p><div><li>👍 105</li><li>👎 0</li></div>
 */
public class P面试题_0806HanotaLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0806HanotaLcci().new Solution();
        // TO TEST
        List<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 0));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        solution.hanota(A, B, C);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Character> map = new HashMap<>();

        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            map.put(System.identityHashCode(A), 'A');
            map.put(System.identityHashCode(B), 'B');
            map.put(System.identityHashCode(C), 'C');
            int N = A.size();
            move(N, A, B, C);
            System.out.println(C);
        }

        // 将 N 个圆盘从 A 柱经由 B 柱移动到 C 柱
        void move(int N, List<Integer> A, List<Integer> B, List<Integer> C) {
            if (N == 1) {
                // 直接将 A 柱的圆盘移动到 C 柱
                C.add(A.remove(A.size() - 1));
                System.out.println(C.get(C.size() - 1) + " : " + map.get(System.identityHashCode(A)) + " -> " + map.get(System.identityHashCode(C)));
                return;
            }
            move(N - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            System.out.println(C.get(C.size() - 1) + " : " + map.get(System.identityHashCode(A)) + " -> " + map.get(System.identityHashCode(C)));
            move(N - 1, B, A, C);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}