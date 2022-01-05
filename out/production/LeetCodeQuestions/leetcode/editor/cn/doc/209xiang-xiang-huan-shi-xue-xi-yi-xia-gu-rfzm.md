### 解题思路
left和right指针维持一个滑动窗口，right负责不停的右移，left只当窗口里值很大的时候右移，缩小窗口

### 代码

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < n) {
            sum += nums[right];
            while ((sum - nums[left]) >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
```