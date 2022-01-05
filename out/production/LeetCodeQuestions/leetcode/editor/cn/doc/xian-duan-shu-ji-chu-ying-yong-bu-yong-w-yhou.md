### 解题思路
这题就是让你写一个线段树的阉割版本，没有区域增加操作，更新操作只针对一个点，只要求通过线段树的机制为query区域的和加速。
这样就不用维护懒增加和懒更新表了，进行操作的时候只要按照线段树的规则，从上到下维护好所有区间的值就可以了，由于更新操作都是针对点的，
所以都会一路通下去更新完毕，沿途不可能会有懒住任务的情况，所以连任务下发的操作也可以免了。
只要更新操作完成之后pushUp一下将各个分支节点的值改正就可以了。

时间复杂度：
更新操作：卡着边界下去，经过的节点数为树高，所以O(logN)
查询操作：卡着边界，最差情况就是查询的是某个点的值O(logN)
空间复杂度：
O（N）
### 代码

```java
class NumArray {
        int MAXN;
        int[] sum;
        int[] arr;

        public NumArray(int[] nums) {
            this.arr = nums;
            MAXN = nums.length << 2;
            sum = new int[MAXN];
            build(0, arr.length - 1, 1);
        }

        private void build(int l, int r, int rt) {
            if (l == r) {
                sum[rt] = arr[l];
                return;
            }
            int mid = l + ((r - l) >> 1);
            build(l, mid, rt << 1);
            build(mid + 1, r, rt << 1 | 1);
            pushUp(rt, rt << 1, rt << 1 | 1);
        }

        private void pushUp(int rt, int lc, int rc) {
            sum[rt] = sum[lc] + sum[rc];
        }

        //nums[index] to val,本题只有单个位置的更新，所以不用维护更新表
        public void update(int index, int val) {
            update(index, index, val, 0, arr.length - 1, 1);
        }

        private void update(int l, int r, int C, int L, int R, int rt) {
            if (l <= L && r >= R) {//必定是l==L==R==r
                sum[rt] = C;
                return;
            }
            //下发任务
            int mid = L + ((R - L) >> 1);
            if (l <= mid) {
                update(l, r, C, L, mid, rt << 1);
            }
            if (r > mid) {
                update(l, r, C, mid + 1, R, rt << 1 | 1);
            }
            pushUp(rt, rt << 1, rt << 1 | 1);
        }


        public int sumRange(int left, int right) {
            return query(left, right, 0, arr.length - 1, 1);
        }

        private int query(int l, int r, int L, int R, int rt) {
            if (l <= L && r >= R) {
                return sum[rt];
            }
            //任务下发
            int mid = L + ((R - L) >> 1);
            int ans = 0;
            if (l <= mid) {
                ans += query(l, r, L, mid, rt << 1);
            }
            if (r > mid) {
                ans += query(l, r, mid + 1, R, rt << 1 | 1);
            }
            pushUp(rt,rt<<1,rt<<1|1);//沿途没有懒着的任务，所以每次更新完整个线段树所有节点的值都是正确的，这里都不用pushUp了
            return ans;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
```