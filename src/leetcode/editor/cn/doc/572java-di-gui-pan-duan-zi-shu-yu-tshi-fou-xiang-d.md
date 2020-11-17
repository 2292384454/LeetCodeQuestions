**更多LeetCode题解请看[题解仓库](https://github.com/ustcyyw/yyw_algorithm),如果觉得还不错请别吝啬你的star~**
### 解法

```java
public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSame(s, t))
            return true;
        else
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode p, TreeNode q){
        if(q == null && p == null) return true;
        if(q == null || p == null) return false;
        if(q.val != p.val) return false;
        else return isSame(q.left, p.left) && isSame(q.right, p.right);
    }
```

思路分析：

* 题目所指的s中是否包含t，就是在问s中是否有某一棵子树与t相同（相等就是树结构一致，且每个结点值都相等。）
* 如何判断两棵树是否相同，辅助函数`boolean isSame(TreeNode p, TreeNode q)`，可以参考仓库里题解[100. 相同的树](https://github.com/ustcyyw/yyw_algorithm/blob/master/easy/Tree/isSameTree100.md)。
    * 根节点值相同，且左右子树相同才能判断一颗树相同。这就是递归的关系。
    * 递归结束的条件，当两颗树均是`null`时他们相等，当两颗树其中之一为`null`另外一颗非`null`时他们不相等。
    * 其它情况下，先判断当前节点的值是否相等，如果相等再判断当前节点的左右子树是否均相同
* 再回到树的包含问题上
    * 如果结点s与t为根的树相同，显然s包含t。` if(isSame(s, t)) return true;`。
    * 否则判断s的左子树或者右子树是否包含t，如果有其中之一包含t，也说明s包含t，所以返回`isSubtree(s.left, t) || isSubtree(s.right, t);`
    * 当递归中`s == null`，显然这棵空树不包含t，且没有子树可以进行递归，直接返回`false`。

运行结果：

* 执行用时 :7 ms, 在所有 Java 提交中击败了94.26%的用户
* 内存消耗 :40.7 MB, 在所有 Java 提交中击败了7.38%的用户

更多LeetCode题解请看我的[github](https://github.com/ustcyyw/yyw_algorithm)，地址https://github.com/ustcyyw/yyw_algorithm。还有别的小项目也很好玩~卑微求个小星星💖