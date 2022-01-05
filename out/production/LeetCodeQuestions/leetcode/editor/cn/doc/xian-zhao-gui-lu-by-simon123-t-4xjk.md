### 解题思路
通过枚举小数量的结果可以发现：
1.最优的应该放墙角、摆放成正四面体的形式。
2.下面一层始终比上面一层多出一排盒子。

我们先试着计算下接近正四面体的形态的盒子数量：
假设摆放成n层盒子：
1.从顶至底，第k层盒子数量Sk = k*(k+1)/2;
2.所有盒子数量 S = S1+S2+…+Sn = [1*2/2] + [2*3/2]+…+[n*(n+1)/2] = [n*(n+1)*(2*n+1)/6 + n*(n+1)/2]/2；
其中，底部盒子数量ans = n*(n+1)/2。


### 代码

```java
class Solution {
    public int minimumBoxes(int n) {
        if (n == 1) {
            return 1;
        }
        int ans = 0;
        int k = 1;
        for (int i = 2; i < 10000; i++) {
            long tmp = ((long) i * (i + 1) * (2 * i + 1) / 6 + i * (i + 1) / 2) / 2;
            if (tmp <= n) {
                k = i;
            } else {
                n -= ((long) k * (k + 1) * (2 * k + 1) / 6 + k * (k + 1) / 2) / 2;
                ans += k * (k + 1) / 2;
                break;
            }
        }
        int t = (int) Math.sqrt(2 * n);
        if (t * (t + 1) / 2 < n) {
            t++;
        }
        ans += t;
        return ans;
    }
}
```