```python3 []
# 使用二分法，目的只是为了少写几个IF = =||
def fbisect_left(fun,val, l, r):
    while(l<r):
        m = (l+r)//2
        if fun(m)<val: l = m+1
        else: r = m
    return l

class Solution:
    def minimumBoxes(self, n: int) -> int:
        # 从墙角出发，和墙角距离相等的方块视为“一层（layer）”。

        # 层数和占地面积的关系：
        def get2d(l):
            # 1+2+3+.....+l
            return l*(l+1)//2
        
        # 层数和方块数的关系：
        def get3d(l):
            # get2d(1)+get2d(2)+get2d(3)+.....+get2d(l)
            return l*(l+1)*(l+2)//6
        
        # 先估计一个最大层数：
        estimate = int((n*6)**(1/3)) - 1
        # 在估计值附近找到合适的值。
        targetLayer = fbisect_left(get3d, n, estimate-1, estimate+2);

        
        size = get2d(targetLayer-1)
        V = get3d(targetLayer-1)
        
        # 找到未满层的行数
        estimate = int(((n-V)*2)**0.5)
        rows = fbisect_left(get2d, n-V, estimate-1, estimate+2)
        return size + rows
```
时间复杂度O(1);
空间复杂度O(1);