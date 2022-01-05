- 求得小于给定n的最大饱和堆（即靠角落每一层都放满）的高度height
- 求得剩余的盒子数量remain，由上面一条可知肯定是不足以放满下一层的
- 如何放置remain个盒子呢？如下图红色方框所示，依旧是贴着斜边放置。最底层放一个时，上一层无法放置；最底层放两个，上一次就可以再放一个；依此递推，尽可能的放置在第一层的上面层，减少最底层的盒子个数。
- 所以`1+2+3+……+N = remain`，其中，N代表最底层放置的盒子个数，N < height + 1（因为如果N = height + 1时候，就相当于放置满了新的一层了），求出N的值，就得到了最底层一共最少需要放置多少个。
- 很明显，根据等差数列求和公式，`N^2 + N - 2*remain = 0`，求解一元二次方程，`(-b+Math.sqrt(b^2 - 4ac)) / 2a`求得答案。**注意要取小数的ceil值**
![image.png](https://pic.leetcode-cn.com/1611472722-mMWVYz-image.png)

```java
    public int minimumBoxes(int n) {
        int sum = 0;
        int tmp = 0;
        int height = 1;
        for (; sum < n; height++) {
            tmp += height;
            sum = sum + tmp;
        }
        int remain = n - sum + tmp;
        height--;
        return tmp - height + (int) Math.ceil((Math.ceil(Math.sqrt(1 + 8 * remain)) - 1) / 2);
    }
```
