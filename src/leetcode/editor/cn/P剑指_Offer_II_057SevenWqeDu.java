package leetcode.editor.cn;

import java.util.TreeMap;

public class P剑指_Offer_II_057SevenWqeDu {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_057SevenWqeDu().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 1, 6, 3};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 100, 1));
    }

    //Java：值和下标之差都在给定的范围内
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeMap<Long, Integer> map = new TreeMap<>();
            int n = nums.length;
            if (n == 0) {
                return false;
            }
            for (int i = 0; i <= k && i < n; i++) {
                Long ceil = map.ceilingKey((long) nums[i]), floor = map.floorKey((long) nums[i]);
                if (!map.isEmpty() && (ceil != null && Math.abs(ceil - nums[i]) <= t)
                        || map.floorKey((long) nums[i]) != null && Math.abs(floor - nums[i]) <= t) {
                    return true;
                }
                int count = map.getOrDefault((long) nums[i], 0);
                map.put((long) nums[i], count + 1);
            }
            for (int i = k + 1; i < n; i++) {
                // 淘汰旧值
                int oldCount = map.getOrDefault((long) nums[i - k - 1], 0);
                if (oldCount <= 1) {
                    map.remove((long) nums[i - k - 1]);
                }
                // 判断
                Long ceil = map.ceilingKey((long) nums[i]), floor = map.floorKey((long) nums[i]);
                if (!map.isEmpty() && (ceil != null && Math.abs(ceil - nums[i]) <= t)
                        || map.floorKey((long) nums[i]) != null && Math.abs(floor - nums[i]) <= t) {
                    return true;
                }
                // 添加新值
                int count = map.getOrDefault((long) nums[i], 0);
                map.put((long) nums[i], count + 1);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}