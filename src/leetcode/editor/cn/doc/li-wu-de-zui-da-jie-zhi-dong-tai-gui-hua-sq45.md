## 解析

很基础的动态规划了，相当于从左上角走到右下角，所经过的格子的数值总和。

又每次行动只能向下或向右移动一格，换句话说，一个格子只能由它的上方或左方走到，所以很容易得到状态转移方程：

*
dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
*

其中 *dp[i][j]* 表示走到坐标为 *(i,j)* 的格子所能拿到礼物的最大值，转移公式的含义是从上方 (*dp[i - 1][j]*) 和左方 (*dp[i][j - 1]*) 选择能拿礼物多的那个路径，加上当前位置能拿礼物的价值，就是当前格子所能拿到礼物的最大值

## 动态规划

对于边界情况，我们有两种常用处理办法

- 单独初始化边界
- 多开一行一列数组，就能统一化边界处理

---

方法一、单独处理边界

```python []
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [[0 for _ in range(m)] for _ in range(n)]

        dp[0][0] = grid[0][0]
        # 初始化第一行
        for i in range(1, m):
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        # 初始化第一列
        for i in range(1, n):
            dp[i][0] = dp[i - 1][0] + grid[i][0]

        for i in range(1, n):
            for j in range(1, m):
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        
        return dp[n - 1][m - 1]
```
```java []
class Solution {
    private static int[][] dp = new int[207][207];
    public int maxValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < m; ++i)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        // 初始化第一列
        for (int i = 1; i < n; ++i)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        // 动态规划
        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
```
```cpp []
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(m, 0));
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < m; ++i)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        // 初始化第一列
        for (int i = 1; i < n; ++i)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        // 动态规划
        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
};
```

---

方法二、多开一行一列数组，就能统一化边界处理，不过需要做坐标偏移，即 *dp[i][j]* 表示走到坐标为 *(i - 1,j - 1)* 的格子所能拿到礼物的最大值,相比较上一种方法优点是编程实现更简单

```python []
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]
        
        return dp[n][m]
```

```java []
class Solution {
    private static int[][] dp = new int[207][207];
    public int maxValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }
}
```

```cpp []
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }
};
```

---

- 时间复杂度: ![O(n\timesm) ](./p__O_n_times_m__.png) 
- 空间复杂度: ![O(n\timesm) ](./p__O_n_times_m__.png) 

---

## 滚动数组优化

考虑到 *dp[i][j]* 的值只与 *dp[i-1][j]* 和 *dp[i][j-1]* 有关，我们可以用一个一维数组来代替二维的数组

```python []
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [0 for _ in range(m + 1)]

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                dp[j] = max(dp[j], dp[j - 1]) + grid[i - 1][j - 1]
        
        return dp[m]
```

```java []
class Solution {
    public int maxValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m];
    }
}
```

```cpp []
class Solution {
public:
    int maxValue(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<int> dp(m + 1, 0);
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                dp[j] = max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m];
    }
};
```

---

- 时间复杂度: ![O(n\timesm) ](./p__O_n_times_m__.png) 
- 空间复杂度: *O(m)*

## 记忆化dfs

这题也能用记忆化dfs求解，这里只展示python代码(cache装饰器对于记忆化dfs太友好惹~)

```python []
from functools import cache
class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:

        @cache
        def dfs(i: int, j: int):
            if i == 0 and j == 0:
                return grid[i][j]
            elif i == 0:
                return dfs(i, j - 1) + grid[i][j]
            elif j == 0:
                return dfs(i - 1, j) + grid[i][j]
            else:
                return max(dfs(i - 1, j), dfs(i, j - 1)) + grid[i][j]

        return dfs(len(grid) - 1, len(grid[0]) - 1)
```

- 时间复杂度: ![O(n\timesm) ](./p__O_n_times_m__.png) 
- 空间复杂度: ![O(n\timesm) ](./p__O_n_times_m__.png) 

