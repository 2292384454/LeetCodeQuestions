package leetcode.editor.cn;

public class P795NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Solution solution = new P795NumberOfSubarraysWithBoundedMaximum().new Solution();
        // TO TEST
        int[] nums = new int[]{876, 880, 482, 260, 132, 421, 732, 703, 795, 420, 871, 445, 400, 291, 358, 589, 617, 202, 755, 810, 227, 813, 549, 791, 418, 528, 835, 401, 526, 584, 873, 662, 13, 314, 988, 101, 299, 816, 833, 224, 160, 852, 179, 769, 646, 558, 661, 808, 651, 982, 878, 918, 406, 551, 467, 87, 139, 387, 16, 531, 307, 389, 939, 551, 613, 36, 528, 460, 404, 314, 66, 111, 458, 531, 944, 461, 951, 419, 82, 896, 467, 353, 704, 905, 705, 760, 61, 422, 395, 298, 127, 516, 153, 299, 801, 341, 668, 598, 98, 241};
        System.out.println(solution.numSubarrayBoundedMax(nums, 658, 719));
    }

    //Java：区间子数组个数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int l = 0, r = 0, ans = 0, n = nums.length;
            int[] lastBiggerIdx = new int[n]; //记录上一个更大的数的位置
            int[] nextBiggerOrEqualIdx = new int[n];//记录下一个更大或相等的数的位置
            int[] stack = new int[n + 1];
            int top = -1;
            stack[++top] = -1;
            for (int i = 0; i < n; i++) {
                while (top > 0 && nums[stack[top]] <= nums[i]) {
                    top--;
                }
                lastBiggerIdx[i] = stack[top];
                stack[++top] = i;
            }
            stack = new int[n + 1];
            top = -1;
            stack[++top] = n;
            for (int i = n - 1; i >= 0; i--) {
                while (top > 0 && nums[stack[top]] < nums[i]) {
                    top--;
                }
                nextBiggerOrEqualIdx[i] = stack[top];
                stack[++top] = i;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] >= left && nums[i] <= right) {
                    ans += ((i - lastBiggerIdx[i]) * (nextBiggerOrEqualIdx[i] - i));
                }
            }
            return ans;
        }
    }

//runtime:9 ms
//memory:49.2 MB
//leetcode submit region end(Prohibit modification and deletion)

}