  题目要求每一层在一个列表，很容易想到用队列+层次遍历的方法，难点就在于怎么区分各层，把每一层的元素分别放进对应的列表中。
  这里采用的是记录队列长度，每次把该层的元素值全部送入一个列表并将他们的子结点依次入队的方法，直接上代码。

```java []
class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            TreeNode p = root;//循环指针
            List<List<Integer>> result = new LinkedList<>();//要返回的结果列表
            Queue<TreeNode> myQueue = new LinkedList<TreeNode>();//辅助队列
            if (p == null) return result;//如果树为空就返回空表
            myQueue.offer(p);//将根节点入队
            while (!myQueue.isEmpty()) {//循环跳出条件为队空
                List<Integer> tempList = new ArrayList<>();//创建临时列表
                int len = myQueue.size();//记录下此时队列的长度
                for (int i = 0; i < len; i++) {//进行len次循环，刚好将本层元素的值全部出队并送入临时列表
                    p = myQueue.poll();//将队顶元素出队
                    tempList.add(p.val);//将队顶元素的值送入临时列表
                    if (p.left != null) myQueue.offer(p.left);//队顶元素左子节点入队
                    if (p.right != null) myQueue.offer(p.right);//队顶元素右子节点入队
                }
                result.add(0, tempList);
            }
            return result;
        }
    }
```
