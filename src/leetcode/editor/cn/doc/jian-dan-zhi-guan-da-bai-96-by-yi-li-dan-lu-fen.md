### 解题思路
直接递归搞起来（最后输出的时候去掉最外层的括号）
![image.png](https://pic.leetcode-cn.com/b0144414cc88d5db09f45d33681ce5ede8673cd123e41ae5abe5042c8b067eb8-image.png)

### 代码

```python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def tree2str(self, t: TreeNode) -> str:
        def func(node):
            if not node:
                return '()'
            l = func(node.left)
            r = func(node.right)
            if l == r == '()':
                return '('+ str(node.val) + ')'
            elif l != '()' and r == '()' :
                return '('+ str(node.val) + l + ')'
            else:
                return '('+ str(node.val) + l + r + ')'   
        return func(t)[1:-1]
```