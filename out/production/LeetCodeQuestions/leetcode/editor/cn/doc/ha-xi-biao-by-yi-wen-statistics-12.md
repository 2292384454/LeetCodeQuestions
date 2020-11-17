## 方法1——哈希表+深度优先搜索
如代码

### 代码

```python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        # 第一想法是哈希表记录
        Hash = {}
        def dfs(root, Hash):
            if not root:
                return
            Hash[root.val] = Hash.get(root.val, 0) + 1
            dfs(root.left, Hash)
            dfs(root.right, Hash)
        dfs(root, Hash)
        mode = max(Hash.values())
        return [key for key in Hash.keys() if Hash[key] == mode]
```

### 复杂度分析
时间复杂度：O(N)
空间复杂度：O(N+K)，K为数字种类数