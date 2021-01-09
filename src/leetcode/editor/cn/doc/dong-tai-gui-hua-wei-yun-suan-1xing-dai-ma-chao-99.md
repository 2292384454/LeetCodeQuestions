### 解题思路
- `dp[i]`表示第`i`次，Alice必赢`true`或必败`false`。`dp[0] = true`，`dp[1] = false`
- 黑板上的数字从`1`到`N`循环`i`，每次找`x`<`i`
    - `x`能整除`i`
    - 至少存在一局`dp[i - x]`必败，原因
        - `1`可整除任何数
        - `dp[1]`时，Alice先手，必败
            - `dp[2]`时，Alice和Bob都可拿1，让对方`dp[1]`必败，Alice先手，拿1，必胜
            - `dp[3]`时，Alice和Bob都可拿1，让对方`dp[2]`必胜，Alice先手，拿1，必败
            - `dp[4]`时，Alice和Bob都可拿1，让对方`dp[3]`必败，Alice先手，拿1，必胜
            - `dp[5]`时，Alice和Bob都可拿1，让对方`dp[4]`必胜，Alice先手，拿1，必败
            - ...
            - `dp[i]`时，Alice和Bob都可拿x，让对方`dp[i - x]`必败，Alice先手，拿1，必胜
- 状态转移方程：d[i] = i % x === 0 && !dp[i - x]
- 题设`Alice`最佳状态（只要有赢的可能就会赢），所以只要有一个`true`就终止循环
- 返回`dp[N]`

### 代码

```javascript
var divisorGame = function(N, dp = [true, false]) {// 执行用时：104ms
    for(var i = 1; i <= N; i++) for(var x = i; x-- > 1;) if(dp[i] = i % x === 0 & !dp[i - x]) break
    return dp[N]
};
```

### 解题思路：减少循环
- 观察上面的代码 `for(var x = i; x-- > 1;) if(dp[i] = i % x === 0 & !dp[i - x]) break`
    - `x`从`i`到`1`，`dp[i]`的值每次循环都被覆盖，最终值，都为`x = 1`时的值
    - `dp[i] = i % 1 === 0 & !dp[i - 1])`，`i % 1`恒为`0`，即
    - `dp[i] = !dp[i - 1]`
- 只要拿`1`，就可以让 本局结果 和 上一局 相反
- `1`可整除任何数，Alice和Bob每局都可以拿`1`，改变结果。双方都是最佳状态
    - Alice必败时，拿1，让Bob必败
    - Bob必败时，拿1，让Alice必败
- 本局结果 = 上局结果`取反`，1总可以拿，没有必要循环其他数
### 代码

```javascript
var divisorGame = function(N, dp = [true]) {// 执行用时：88ms
    for(var i = 1; i <= N; i++) dp[i] = !dp[i - 1]
    return dp[N]
};
```

### 解题思路：降低维度
- 每一局的状态，只与上一局有关，降低`dp`维度

### 代码
```javascript
var divisorGame = function(N, dp = true) {// 执行用时：68ms
    for(var i = 1; i <= N; i++) dp = !dp
    return dp
};
```

### 解题思路：数学抽象
- 循环`1`次，`dp`为`false`，`2次`为`true`，`3次`为`false`...
- 循环`奇数次`，`dp`为`false`，`偶数次`为`true`
- 循环次数 = `N`，判断`N`的奇偶性
### 代码
```javascript
var divisorGame = function(N) {// 执行用时：72ms
    return N % 2 === 0
};
```

### 解题思路：位运算
- 用位运算判断奇偶性，`& 1`二进制末位是`1`奇数，`0`偶数，`^ 1`异或取反
### 代码
```javascript
var divisorGame = function(N) {// 执行用时：60ms
    return N & 1 ^ 1
};
```
### 结果
- 动态规划（优化后）
![1.png](https://pic.leetcode-cn.com/1602414992-avgGWd-1.png)
- 位运算
![QQ拼音截图20201011125503.png](https://pic.leetcode-cn.com/1602415304-SBEwRN-QQ%E6%8B%BC%E9%9F%B3%E6%88%AA%E5%9B%BE20201011125503.png)
