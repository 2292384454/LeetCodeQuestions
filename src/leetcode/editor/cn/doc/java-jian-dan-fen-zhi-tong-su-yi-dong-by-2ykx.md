### 解题思路
本题解 采用了 **`分治`** 的思想：
> 1. 遍历 字符串
> 2. 遇到操作符，就将左右两边的字符串，分别当作 **两个表达式**

### 运行结果
![image.png](https://pic.leetcode-cn.com/1618730323-CdSLgY-image.png)

### 代码

```java
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() <= 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> curRes = new ArrayList<Integer>();
        int length = input.length();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            char aChar = charArray[i];
            if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (aChar == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (aChar == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }
                
            }
        }

        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(input));
        }
        return curRes;
    }
}
```
打卡189天，加油！！！
肥来了肥来了，继续肝题解
最近一路绿灯，十分快意！
由是人间最得意，策码倚键笑清风！😎