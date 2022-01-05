**注释见**
1、递归
```cpp
class Solution {
public:
    bool compare(TreeNode* left, TreeNode* right) {
        if (left == NULL && right == NULL) return true; // 若左右节点都为空，则到目前为止是对称的，返回真
        else if (left == NULL || right == NULL) return false; // 左右节点有一个不为空，都不对称，返回假
        else if (left->val != right->val) return false; // 左右节点都不空，但是值不等，也不对称，返回假
        // 注意：上面判断用的else if，最后剩下的情况就是左右节点都不空，且值相等
        // 然后递归判断子树的
        // 外层是左节点的左子树和右节点的右子树判断对称
        bool outside = compare(left->left, right->right);
        // 内层是左节点的右子树和右节点的左子树判断对称
        bool inside = compare(left->right, right->left);
        // 若内外层都对称，则当前二叉树对称
        // 反之则不对称
        bool isSame = outside && inside;
        return isSame;
    }
    bool isSymmetric(TreeNode* root) {
        if (!root) return true; // 判空，空既是真
        return compare(root->left, root->right);
    }
}
```
2、迭代
```cpp
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (!root) return true; // 判空，空既是真
        queue<TreeNode*> q; // 新建队列
        q.push(root->left); // 左子树根节点入队
        q.push(root->right); // 右子树根节点入队
        while (!q.empty()) {
            // 取出队列中的前两位存放的左右子树的根节点
            TreeNode *lNode = q.front();
            q.pop();
            TreeNode *rNode = q.front();
            q.pop();
            // 进行判断
            // 若左右节点都为空，则到目前为止是对称的，直接进行下一轮循环
            if (lNode == NULL && rNode == NULL) continue;
            else if (lNode == NULL || rNode == NULL) return false;// 左右节点有一个不为空，都不对称，返回假
            else if (lNode->val != rNode->val) return false;// 左右节点都不空，但是值不等，也不对称，返回假
            // 注意：上面判断用的else if，最后剩下的情况就是左右节点都不空，且值相等
            // 接着将当前子树的外层节点入队
            q.push(lNode->left);
            q.push(rNode->right);
            // 将当前子树的内层节点入队
            q.push(lNode->right);
            q.push(rNode->left);
            // 入队完成之后
            // 队列中相邻的两个节点即是需要比较的子树节点
        }
        return true;
    }
};
```
