package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P869ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new P869ReorderedPowerOf2().new Solution();
        // TO TEST
    }

    //Java：重新排序得到 2 的幂
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            boolean ans=false;
            // 0~9 分别出现了几次
            int[] counts = new int[10];
            while (n > 0) {
                counts[n % 10]++;
                n /= 10;
            }
            int num = 1;
            for (int i = 0; i < 31; i++) {
                int c = num;
                int[] temp = Arrays.copyOf(counts, 10);
                ans=true;
                while (c > 0) {
                    temp[c % 10]--;
                    c /= 10;
                }
                num <<= 1;
                for (int j = 0; j < 10; j++) {
                    if (temp[j] != 0) {
                        ans=false;
                    }
                }
                if(ans){
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}