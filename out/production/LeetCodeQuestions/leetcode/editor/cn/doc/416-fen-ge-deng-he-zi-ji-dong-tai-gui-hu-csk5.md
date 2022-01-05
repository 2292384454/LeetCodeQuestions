# [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)
***
### 思路
> 01背包问题——能不能装满容量为target的背包

本题要求把数组分成两个等和的子集，相当于找到一个子集，其和为sum/2，这个sum/2就是target
- 具体步骤如下：
1. **特例**：如果sum为奇数，那一定找不到符合要求的子集，返回False。

2. **dp[j]含义**：有没有和为j的子集，有为True，没有为False。
3. **初始化dp数组**：长度为target + 1，用于存储子集的和从0到target是否可能取到的情况。
比如和为0一定可以取到（也就是子集为空），那么dp[0] = True。
4. 接下来开始**遍历nums数组**，对遍历到的数nums[i]有两种操作，一个是选择这个数，一个是不选择这个数。
－不选择这个数：dp不变
－选择这个数：dp中已为True的情况再加上nums[i]也为True。比如dp[0]已经为True，那么dp[0 + nums[i]]也是True
5. 在做出选择之前，我们先**逆序遍历子集的和从nums[i]到target的所有情况**，判断当前数加入后，dp数组中哪些和的情况可以从False变成True。
`（为什么要逆序，是因为dp后面的和的情况是从前面的情况转移过来的，如果前面的情况因为当前nums[i]的加入变为了True，比如dp[0 + nums[i]]变成了True，那么因为一个数只能用一次，dp[0 + nums[i] + nums[i]]不可以从dp[0 + nums[i]]转移过来。如果非要正序遍历，必须要多一个数组用于存储之前的情况。而逆序遍历可以省掉这个数组）`
   - dp[j] = dp[j] or dp[j - nums[i]]
   - 这行代码的意思是说，如果不选择当前数，那么和为j的情况保持不变，dp[j]仍然是dp[j]，原来是True就还是True，原来是False也还是False；
   - 如果选择当前数，那么如果j - nums[i]这种情况是True的话和为j的情况也会是True。比如和为0一定为True，只要 j - nums[i] == 0，那么dp[j]就变成了True。
   - dp[j]和dp[j-nums[i]]只要有一个为True，dp[j]就变成True，因此用or连接两者。
6. 最后就看dp[-1]是不是True，也就是dp[target]是不是True

### 代码
```Python3 []
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        sumAll = sum(nums)
        if sumAll % 2:
            return False
        target = sumAll // 2

        dp = [False] * (target + 1)
        dp[0] = True

        for i in range(len(nums)):
            for j in range(target, nums[i] - 1, -1):
                dp[j] = dp[j] or dp[j - nums[i]]
        return dp[-1]
```

```Java []
class Solution {
    public boolean canPartition(int[] nums) {
        int sumAll = Arrays.stream(nums).sum();
        if (sumAll % 2 == 1){
            return false;
        }
        int target = sumAll / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
```
**复杂度分析**
- 时间复杂度：*O(n * target)*
- 空间复杂度：*O(target)*
***
### 背包专题
|  题目   | 我的题解  |
|  ----  | ----  | ----  |
| [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)  | [动态规划之01背包问题](https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/416-fen-ge-deng-he-zi-ji-dong-tai-gui-hu-csk5/) |
| [494. 目标和](https://leetcode-cn.com/problems/target-sum/)  | [动态规划之01背包问题](https://leetcode-cn.com/problems/target-sum/solution/494-mu-biao-he-dong-tai-gui-hua-zhi-01be-78ll/) |
| [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)  | [动态规划之完全背包问题](https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-dong-tai-gui-hua-e2nt7/) |
| [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)  | [动态规划之完全背包的组合问题](https://leetcode-cn.com/problems/coin-change-2/solution/518-ling-qian-dui-huan-iidong-tai-gui-hu-5xy2/) |