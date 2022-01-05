1. 前找单调增
2. 后找单调减
3. 找中间最大 最小值
4. 接3，判断实际左右指针的位置
```python3
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        start = 0
        end = n - 1
        for i in range(n):
            if nums[i] >= nums[start]:
                start = i
            else:
                break
        for i in range(n-1, start, -1):
            if nums[i] <= nums[end]:
                end = i
            else:
                break
        if start == end:
            return 0

        # O(n)
        min_num = min(nums[start:end+1])
        max_nums = max(nums[start:end+1])
        
        left, right = start, end
        for i in range(start, -1, -1):
            if nums[i] > min_num:
                left = i
        for i in range(end, n):
            if nums[i] < max_nums:
                right = i

        return right - left + 1
```


![微信截图_20210421200059.png](https://pic.leetcode-cn.com/1619006474-UGxLGq-%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20210421200059.png)
