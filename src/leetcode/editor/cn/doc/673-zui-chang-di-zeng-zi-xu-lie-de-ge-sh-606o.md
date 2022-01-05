> **相信很多小伙伴刷题的时候面对力扣上近两千道题目，感觉无从下手，我花费半年时间整理了Github项目：[leetcode刷题攻略](https://github.com/youngyangyang04/leetcode-master)。 里面有100多道经典算法题目刷题顺序、配有40w字的详细图解，常用算法模板总结，以及难点视频讲解，按照list一道一道刷就可以了！star支持一波吧！**


## 思路 

这道题可以说是 300.最长上升子序列 的进阶版本

1. 确定dp数组（dp table）以及下标的含义

这道题目我们要一起维护两个数组。

dp[i]：i之前（包括i）最长递增子序列的长度为dp[i] 

count[i]：以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]

2. 确定递推公式 

在300.最长上升子序列 中，我们给出的状态转移是：

if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);

即：位置i的最长递增子序列长度 等于j从0到i-1各个位置的最长升序子序列 + 1的最大值。

本题就没那么简单了，我们要考虑两个维度，一个是dp[i]的更新，一个是count[i]的更新。

那么如何更新count[i]呢？

以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]。

那么在nums[i] > nums[j]前提下，如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 > dp[i]，说明找到了一个更长的递增子序列。

那么以j为结尾的子串的最长递增子序列的个数，就是最新的以i为结尾的子串的最长递增子序列的个数，即：count[i] = count[j]。

在nums[i] > nums[j]前提下，如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 == dp[i]，说明找到了两个相同长度的递增子序列。

那么以i为结尾的子串的最长递增子序列的个数 就应该加上以j为结尾的子串的最长递增子序列的个数，即：count[i] += count[j]; 

代码如下：

```C++
if (nums[i] > nums[j]) {
    if (dp[j] + 1 > dp[i]) {
        count[i] = count[j];
    } else if (dp[j] + 1 == dp[i]) {
        count[i] += count[j];
    }
    dp[i] = max(dp[i], dp[j] + 1);
}
```

当然也可以这么写：

```C++
if (nums[i] > nums[j]) {
    if (dp[j] + 1 > dp[i]) {
        dp[i] = dp[j] + 1; // 更新dp[i]放在这里，就不用max了
        count[i] = count[j];
    } else if (dp[j] + 1 == dp[i]) {
        count[i] += count[j];
    }
}
```

这里count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数。dp[i]记录了i之前（包括i）最长递增序列的长度。

题目要求最长递增序列的长度的个数，我们应该把最长长度记录下来。

代码如下：

```C++
for (int i = 1; i < nums.size(); i++) {
    for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
            if (dp[j] + 1 > dp[i]) {
                count[i] = count[j];
            } else if (dp[j] + 1 == dp[i]) {
                count[i] += count[j];
            }
            dp[i] = max(dp[i], dp[j] + 1);
        }
        if (dp[i] > maxCount) maxCount = dp[i]; // 记录最长长度
    }
}
```
3. dp数组如何初始化

再回顾一下dp[i]和count[i]的定义

count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数。 

那么最少也就是1个，所以count[i]初始为1。

dp[i]记录了i之前（包括i）最长递增序列的长度。

最小的长度也是1，所以dp[i]初始为1。

代码如下：

```
vector<int> dp(nums.size(), 1);
vector<int> count(nums.size(), 1);
```

**其实动规的题目中，初始化很有讲究，也很考察对dp数组定义的理解**。

4. 确定遍历顺序

dp[i] 是由0到i-1各个位置的最长升序子序列 推导而来，那么遍历i一定是从前向后遍历。

j其实就是0到i-1，遍历i的循环里外层，遍历j则在内层，代码如下：

```C++
for (int i = 1; i < nums.size(); i++) {
    for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
            if (dp[j] + 1 > dp[i]) {
                count[i] = count[j];
            } else if (dp[j] + 1 == dp[i]) {
                count[i] += count[j];
            }
            dp[i] = max(dp[i], dp[j] + 1);
        }
        if (dp[i] > maxCount) maxCount = dp[i];
    }
}
```


最后还有再遍历一遍dp[i]，把最长递增序列长度对应的count[i]累计下来就是结果了。

代码如下：

```
for (int i = 1; i < nums.size(); i++) {
    for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
            if (dp[j] + 1 > dp[i]) {
                count[i] = count[j];
            } else if (dp[j] + 1 == dp[i]) {
                count[i] += count[j];
            }
            dp[i] = max(dp[i], dp[j] + 1);
        }
        if (dp[i] > maxCount) maxCount = dp[i];
    }
}
int result = 0; // 统计结果 
for (int i = 0; i < nums.size(); i++) {
    if (maxCount == dp[i]) result += count[i];
}
``` 

统计结果，可能有的同学又有点看懵了，那么就再回顾一下dp[i]和count[i]的定义。

5. 举例推导dp数组

输入：[1,3,5,4,7] 

![673.最长递增子序列的个数](https://pic.leetcode-cn.com/1610419690-lFSmFG-file_1610419689719)

**如果代码写出来了，怎么改都通过不了，那么把dp和count打印出来看看对不对！**

以上分析完毕，C++整体代码如下：

```
class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        if (nums.size() <= 1) return nums.size();
        vector<int> dp(nums.size(), 1);
        vector<int> count(nums.size(), 1);
        int maxCount = 0;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (maxCount == dp[i]) result += count[i];
        }
        return result;
    }
};
```

* 时间复杂度O(n^2)
* 空间复杂度O(n)

> 大家好，我是程序员Carl，我已经陆续将「代码随想录」题解按照由浅入深的刷题顺序编排起来，整理成册，这份刷题顺序和题解在公众号里已经陪伴了上万录友。

pdf中不仅有刷题大纲、刷题顺序，还有详细图解，每一本pdf发布之后都广受好评，这也是carl花费大量时间写题解的动力。

说了这么多还是眼见为实，**[下载地址](https://mp.weixin.qq.com/s/RsdcQ9umo09R6cfnwXZlrQ)**，赶快下载看看！

Github项目：[力扣刷题攻略](https://github.com/youngyangyang04/leetcode-master) 

**如果感觉题解对你有帮助，不要吝啬给一个👍吧！**

