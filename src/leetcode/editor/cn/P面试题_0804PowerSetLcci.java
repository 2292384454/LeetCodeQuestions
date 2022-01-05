package leetcode.editor.cn;
//Java：幂集

import java.util.ArrayList;
import java.util.List;

/**
 * <p>幂集。编写一种方法，返回某集合的所有子集。集合中<strong>不包含重复的元素</strong>。</p>
 *
 * <p>说明：解集不能包含重复的子集。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong> 输入</strong>： nums = [1,2,3]
 * <strong> 输出</strong>：
 * [
 * [3],
 * &nbsp; [1],
 * &nbsp; [2],
 * &nbsp; [1,2,3],
 * &nbsp; [1,3],
 * &nbsp; [2,3],
 * &nbsp; [1,2],
 * &nbsp; []
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>回溯</li></div></div><p><div><li>👍 67</li><li>👎 0</li></div>
 */
public class P面试题_0804PowerSetLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0804PowerSetLcci().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3, 5, 3};
        System.out.println(solution.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>(1 << nums.length);
            //先添加一个空的集合
            res.add(new ArrayList<>());
            for (int num : nums) {
                //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
                for (int i = 0, j = res.size(); i < j; i++) {
                    //遍历之前的子集，重新封装成一个新的子集
                    List<Integer> list = new ArrayList<>(res.get(i));
                    //然后在新的子集后面追加这个元素
                    list.add(num);
                    //把这个新的子集添加到集合中
                    res.add(list);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}