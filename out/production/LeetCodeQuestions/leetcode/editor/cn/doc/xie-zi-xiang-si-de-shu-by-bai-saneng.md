### 解题思路
此处撰写解题思路
1.建两个list
2.递归获得两个list的所有叶子结点
3.比较并返回结果
### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();    
        List<Integer> list2 = new ArrayList<>();   

        dfs(root1, list1);
        dfs(root2, list2);

        if(list1.equals(list2)) {
            return true;
        } else {
            return false;
        }

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
```