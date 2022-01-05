### 解题思路
1. 归纳几个数字可以发现如下规律
- 4 = 2 * 2；
- 5 = 3 * 2；
- 6 = 3 * 3；
- ==============
- 7 = 3 * 2 * 2；
- 8 = 3 * 3 * 2；
- 9 = 3 * 3 * 3；
2. 在中间我加了一条线，表明每三个数字为一组，也就是说当 n % 3 == 1 时，我们需要除一个 3 再乘上 2 * 2 
3. 这个思想的证明过程大家可以真行思考
4. 提交代码

### 代码

```java
class Solution {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        
        int res = 1;
        while (n >= 3){
            res *= 3;
            n = n - 3;
        }
        if (n == 1){
            res = (res / 3) * 2 * 2;
        }
        if (n == 2){
            res = res * n;
        }
        return res;
    }
}
```