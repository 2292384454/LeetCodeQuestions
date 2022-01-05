时间复杂度O(N^2), 空间复杂度O(N^2)

题目：

给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。

如果有多个目标子集，返回其中任何一个均可。

 

**示例 1:**

    输入: [1,2,3]
    输出: [1,2] (当然, [1,3] 也正确)
**示例 2:**

    输入: [1,2,4,8]
    输出: [1,2,4,8]

**解题思路**
看到题目首先会想到一个问题， 如果判断一个数 **A** 能整除一个能相互整除的集合 **S** ？
暴力做法可以直接枚举， 这个时间复杂度就比较高了。
还有一种做法，就是判断这个数 **A** 能否整除这个集合 **S** 里最大的那个数 **B** 。
如果一个数A能整除集合里最大的数 **B** ，那一定能整除这个子集里所有的其他数，
因为这个子集里的其他的数都是小于等于 **B** ，且能被 **B** 整除。

所以就想到排序了。

排序后， 如何判断当前数a[i]能否加入之前已经存在的集合？ (0 < k < i)

以数字a[i]作为这个集合的最大数， 只要判断是否存在以a[k]为最大数的集合， 最大数a[k]能否被a[i]整除即可。 

![最大整除子集.png](https://pic.leetcode-cn.com/dbea454c38d20548f964f9572c1505b6690fb66cefe662f7ec4c56bd993aac02-%E6%9C%80%E5%A4%A7%E6%95%B4%E9%99%A4%E5%AD%90%E9%9B%86.png)

```
class Solution {
   public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
       if(n == 0) return new ArrayList();
        List[] dp = new List[n];
        dp[0] = new ArrayList();
        dp[0].add(nums[0]);
        List<Integer> ans = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);
                
            for(int k = 0; k < i; k++){
                if(nums[i] % nums[k] == 0){
                    if(dp[i].size() < dp[k].size() + 1){
                        dp[i] = new ArrayList(dp[k]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if(ans.size() < dp[i].size())   ans = dp[i];
        }
        return ans;

   }
}
```


