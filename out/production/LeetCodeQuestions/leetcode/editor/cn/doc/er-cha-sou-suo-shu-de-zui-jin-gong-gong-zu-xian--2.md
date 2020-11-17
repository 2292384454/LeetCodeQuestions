## 题解

我们来复习一下二叉搜索树（BST）的性质：
>1. 节点 *N* 左子树上的所有节点的值都小于等于节点 *N* 的值
>2. 节点 *N* 右子树上的所有节点的值都大于等于节点 *N* 的值
>3. 左子树和右子树也都是 BST

#### 方法一 （递归）

**思路**

节点 *p*，*q* 的最近公共祖先（LCA）是距离这两个节点最近的公共祖先节点。在这里 `最近` 考虑的是节点的深度。下面这张图能帮助你更好的理解 `最近` 这个词的含义。

 [image.png](https://pic.leetcode-cn.com/d4ae198f46c063a84c91dc0488917f7d501d2ee352a398aec9d7e3f7ecd97fc2-image.png){:width=400}
{:align=center}

笔记：*p* 和 *q* 其中的一个在 LCA 节点的左子树上，另一个在 LCA 节点的右子树上。

也有可能是下面这种情况：

 [image.png](https://pic.leetcode-cn.com/57065f75de837616260b54bac172ef9b3c1afab04468ef2ea3394a6708949fa7-image.png){:width=400}
{:align=center}

**算法**

1. 从根节点开始遍历树
2. 如果节点 *p* 和节点 *q* 都在右子树上，那么以右孩子为根节点继续 1 的操作
3. 如果节点 *p* 和节点 *q* 都在左子树上，那么以左孩子为根节点继续 1 的操作
4. 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 *p* 和节点 *q* 的 LCA 了

```Java []
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}
```

```Python []
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Value of current node or parent node.
        parent_val = root.val

        # Value of p
        p_val = p.val

        # Value of q
        q_val = q.val

        # If both p and q are greater than parent
        if p_val > parent_val and q_val > parent_val:    
            return self.lowestCommonAncestor(root.right, p, q)
        # If both p and q are lesser than parent
        elif p_val < parent_val and q_val < parent_val:    
            return self.lowestCommonAncestor(root.left, p, q)
        # We have found the split point, i.e. the LCA node.
        else:
            return root
```

**复杂度分析**

* 时间复杂度：*O(N)*
其中 *N* 为 BST 中节点的个数，在最坏的情况下我们可能需要访问 BST 中所有的节点。

* 空间复杂度：*O(N)*
所需开辟的额外空间主要是递归栈产生的，之所以是 *N* 是因为 BST 的高度为 *N*。

#### 方法二 （迭代）

**算法**

这个方法跟方法一很接近。唯一的不同是，我们用迭代的方式替代了递归来遍历整棵树。由于我们不需要回溯来找到 LCA 节点，所以我们是完全可以不利用栈或者是递归的。实际上这个问题本身就是可以迭代的，我们只需要找到分割点就可以了。这个分割点就是能让节点 *p* 和节点 *q* 不能在同一颗子树上的那个节点，或者是节点 *p* 和节点 *q* 中的一个，这种情况下其中一个节点是另一个节点的父亲节点。

```Java []
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
```

```Python []
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        # Value of p
        p_val = p.val

        # Value of q
        q_val = q.val

        # Start from the root node of the tree
        node = root

        # Traverse the tree
        while node:

            # Value of current node or parent node.
            parent_val = node.val

            if p_val > parent_val and q_val > parent_val:    
                # If both p and q are greater than parent
                node = node.right
            elif p_val < parent_val and q_val < parent_val:
                # If both p and q are lesser than parent
                node = node.left
            else:
                # We have found the split point, i.e. the LCA node.
                return node
```

**复杂度分析**

* 时间复杂度：*O(N)*
其中 *N* 为 BST 中节点的个数，在最坏的情况下我们可能需要遍历 BST 中所有的节点。

* 空间复杂度：*O(1)*