### 解题思路
如题，所以需要采用位运算

### 代码

```python3
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        missing = len(nums)
        for i, j in enumerate(nums):
            missing ^= i ^ j
        return missing
```