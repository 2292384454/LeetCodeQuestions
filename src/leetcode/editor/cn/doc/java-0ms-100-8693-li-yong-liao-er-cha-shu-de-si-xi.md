我们从左下方顶点开始看起

由于**每一行是递减**的，所以我们**只用找到每一行的第一个负数**（对应下标为col_index）就行了，
该行中其后的数字一定是负数，

当前行结束后，我们去看上一行，**只用从下标col_index开始判断正负就行了**

为什么呢？
**因为矩阵按列也是递减的。**

以下面这个小矩阵为例：
[A2     ?
 A1    -1]

我们首先找到-1，它是第二行的第一个负数，对应列下标为col_index

-1是该行第一个负数，所以 A1一定 >= 0
由于列递减，所以 A1 <= A2  那么A2 一定 >= 0

**所以对于第一行，只需要从列下标为col_index的数开始判断就行了。**


同时，如果列下标col_index == 总列数column了，即当前行没有负数了，此时可以直接return了，
因为当前行都是正数了，由于列是递减的，所以上一行肯定也都是正数了，直接return

代码如下：

```java
class Solution {
    public int countNegatives(int[][] grid) {

        //矩阵的行数和列数
        int row = grid.length;//
        int column = grid[0].length;

        //当前数在第几列
        int col_index = 0;

        //负数的个数总和
        int sum = 0;

        for(int i = row - 1; i >= 0; i--)
        {
            //找到该行第一个负数所在的列数
            //这个while循环最多循环column次（col_index 从0 到 column - 1）
            while(col_index < column && grid[i][col_index] >= 0)
            {
                col_index ++;
            }
            //该行没负数，直接return
            if(col_index == column)
            {
                return sum;
            }
            //该行还有负数，加上
            sum += (column - col_index);
        }

        return sum;
    }
}
```


![图片1.png](https://pic.leetcode-cn.com/1606544498-TrxIix-%E5%9B%BE%E7%89%871.png)



**附录：**

之前做过一道与本题有些相似的题目，是在有序矩阵中查找某个数字，记忆很深刻。

对于一个矩阵
[4  3  2 -1
 3  2  1 -1
 1  1 -1 -2
-1 -1 -2 -3]

同一行的数字不变或递减，同一列的数字不变或递减
那么我们可以从左下角的数字开始，因为左下角的数字类似于二叉树的顶点
向上变大，向右变小
那么在矩阵的某个点处，

**向右类似于去往二叉树的左节点，寻找一个更小的数**
**向上类似于去往二叉树的右节点，寻找一个更大的数**


                -1
            -1      1
        -2      1       3
    -3      -1      2       4
        -1      1      3
            -1      2
                -1     

这便是有序矩阵的一个相关思想
