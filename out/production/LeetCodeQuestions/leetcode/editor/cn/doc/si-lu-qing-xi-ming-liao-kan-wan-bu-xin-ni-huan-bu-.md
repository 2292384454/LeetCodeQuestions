**分析**
还记不记得[如何求二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/si-lu-jian-dan-ming-liao-dai-ma-gan-cui-li-luo-b-2/)，那么如何求穿过根节点的直径，很显然答案就是将`左子树的最大深度` + `右子树的最大深度`；
但是题目中要求最大直径，也就是说最大直径路径不一定是穿过根节点的，所以要设置一个变量max，用来记录所有的子树的直径，然后更新最大值。

**思路**
1. 设置一个全局变量`max`；
2. 对`root`进行求最大深度，调用下`maxDeepth`方法；
    - 越过叶子节点，返回`0`；
    - 计算左子树最大深度`left`；
    - 计算右子树最大深度`right`；
    - （在这个位置：计算直径 = `left + right` , 然后再维护最大值`max`）
    - 返回左右子树较大者 `+ 1`；

**代码**
```java [] 
class Solution {
    int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        hepler(root);
        return sum;
    }

    private int hepler(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int l = hepler(root.left);
        int r = hepler(root.right);
        sum = Math.max(sum, l + r);
        return Math.max(l, r) + 1;
    }
}
```
![微信图片_20200921212827.jpg](https://pic.leetcode-cn.com/1600697476-bCMJKV-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200921212827.jpg)
