该题需要在[剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)的基础之上，继续进行操作！唯一的不同之处在于，本题涉及 **“大数越界的求余问题”** 。

> **大数越界：** 剪绳子问题（不考虑取余）最终的结果是以*3^a*指数级别增长，可能超出 `int32` 甚至 `int64` 的取值范围，导致返回值错误。

**题解也可参考我的博客**：

[LeetCode-剑指offer-14-I-剪绳子（记忆化递归、动态规划、数学推导）](https://blog.csdn.net/qyb19970829/article/details/113739157)

[LeetCode-剑指offer-14-II-剪绳子（大数取余、动态规划、循环取余、快速幂）](https://blog.csdn.net/qyb19970829/article/details/113741109)


# 动态规划：大数取余

> 经典击败5%，同样递归方法也可以用下列的方法，但是开销也会很大！

![image-20210207140145326](https://pic.leetcode-cn.com/1612681847-PcYWbL-image-20210207140145326.png)

```java
import java.math.BigInteger;
class Solution {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
         Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
```

# 循环取余

时间复杂度：*O(n)*，空间复杂度：*O(1)*

![image-20210207143908068](https://pic.leetcode-cn.com/1612681847-uuMEIV-image-20210207143908068.png)

```java
class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }else if(n == 4){
            return n;
        }
        long res = 1;
        while(n > 4){
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        // 最终剩下来的肯定是2,3,4
        return (int) (res * n % 1000000007);
    }
}
```

# 快速幂解法（最优解）

时间复杂度：*O(logn)*， 空间复杂度：*O(1)* 

> **快速幂**部分见我先前的**博客记录**: [LeetCode-剑指offer-16-数值的整数次方](https://blog.csdn.net/qyb19970829/article/details/113407668) or **我的力扣题解**：[简单理解快速幂](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-dan-li-jie-kuai-su-mi-by-ollieq-rl74/)，快速幂是在循环取余的基础上，进一步降低时间复杂度，因此效率也是很直观的有了提升！

![image-20210207142006395](https://pic.leetcode-cn.com/1612681847-VmgvSV-image-20210207142006395.png)

```java
class Solution {
    int mod = 1000000007;
    public int cuttingRope(int n) {
        if(n < 4) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if(b == 0) return (int) (myPow(3, a) % mod);
        else if(b == 1) return (int) (myPow(3, a - 1) * 4 % mod);
        else return (int) (myPow(3, a) * 2 % mod);
    }

    public long myPow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }
}
```

