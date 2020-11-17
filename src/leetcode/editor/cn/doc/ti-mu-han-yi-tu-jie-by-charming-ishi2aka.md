**题目含义**

一个m * n的图片，每个像素的颜色值可以用image[x][y]表示。这里有一张4 * 4的图片，现在需要将其中一个像素点涂上某种颜色。
![1.png](https://pic.leetcode-cn.com/1bc3cc38be96f8617ebfec4f6502ad60d1e4b8189ddcd920fd14f1a71944ad63-1.png)


之前跟这个像素颜色相同且连在一起的像素都需要改为新的颜色，这就是最后的结果。
![2.png](https://pic.leetcode-cn.com/2f8086e8e0bedb1bb70ff86903c0fbe0dfbfb7600068f7abdb076cdf78749f7e-2.png)

**深度优先搜索源码**
```
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        // 如果颜色相同则不处理
        if (originColor != newColor) {
            dfs(image, sr, sc, newColor, originColor);
        }  
        return image;
    }
    
    public void dfs(int[][] image, int x, int y, int newColor, int originColor) {
        // 判断是否超出边界
        if (x < 0 || x >= image.length || y < 0 || y >=image[0].length) {
            return;
        }
        if (image[x][y] == originColor) {
            // 将颜色替换
            image[x][y] = newColor;
            // 深度优先搜索四周的像素点
            dfs(image, x-1, y, newColor, originColor);
            dfs(image, x+1, y, newColor, originColor);
            dfs(image, x, y-1, newColor, originColor);
            dfs(image, x, y+1, newColor, originColor);
        }
        return;
    }
}
```


