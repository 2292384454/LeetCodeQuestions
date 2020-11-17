### 解题思路
根据定义， 任何一个丑叔都可以写成 n = 2i * 3j * 5k （i,j,k都是幂，输入法不太方便写成指数，三个数都为0的时候，为丑数1的情况）
于是我们按照2,3,5 的顺序依次循环除，当除到不是当前因数的倍数时，进行下一个因素的整数，这样，最后剩下的数为1则为丑数

### 代码

```java
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] factor = new int[]{2,3,5};
        for (int i : factor) {
            while (num%i == 0) {
                num = num/i;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}
```