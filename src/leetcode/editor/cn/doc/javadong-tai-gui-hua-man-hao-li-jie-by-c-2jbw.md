### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        //i表示绳子长度
        for(int i = 2;i <= n;i++){
            //j表示分的段的长度,小于i
            for(int j = 1;j < i;j++){
                //都不能分了
                int a = j * (i - j);
                //j不能分,i - j能分
                int b = j * dp[i - j];
                //以此类推
                int c = dp[j] * (i - j);
                int d = dp[j] * dp[i - j];
                int e = dp[i];
                dp[i] = Math.max(Math.max(Math.max(a,b),Math.max(c,d)),e);
            }
        }
        return dp[n];
    }
}
```