package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P904FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new P904FruitIntoBaskets().new Solution();
        // TO TEST
        int[] fruits = new int[]{1, 1, 6, 5, 6, 6, 1, 1, 1, 1};
        System.out.println(solution.totalFruit(fruits));
    }

    //Java：水果成篮
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            // 即求最长连续子数组的长度，子数组需要满足"子数组中最多只能有两种元素"
            int n = fruits.length, left = 0, right = 0, ans = 0;
            if (n < 2) {
                return n;
            }
            int[] arr = new int[n];// arr[i] 记录数字 i 最后一次出现的位置
            int basket1 = fruits[0], basket2 = fruits[1];//basket1和basket2记录两个篮子中的水果的种类
            Arrays.fill(arr, -1);
            for (; right < n; right++) {
                // 如果遇到不在两个篮子中的种类的水果
                if (fruits[right] != basket1 && fruits[right] != basket2) {
                    // 并且两个篮子中水果的种类也不一样（其实也就是只有一个篮子装了水果）
                    if (basket1 != basket2) {
                        // 那就把比较早遇到的水果丢掉
                        int pop = arr[basket1] < arr[basket2] ? basket1 : basket2;// pop为要丢掉的水果的种类
                        left = arr[pop] + 1;
                        basket1 = basket1 ^ basket2 ^ pop; // 通过异或操作留下要保留的水果，放入 basket1
                    }
                    // 把新的水果装进 basket2
                    basket2 = fruits[right];
                }
                ans = Math.max(ans, right - left + 1);
                arr[fruits[right]] = right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}