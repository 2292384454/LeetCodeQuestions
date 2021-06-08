//给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。 
//
// 实现 NumArray 类： 
//
// 
// 
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值更新为 val 
// int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + 
//nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 最多调用 3 * 104 次 update 和 sumRange 方法 
// 
// 
// 
// Related Topics 树状数组 线段树 
// 👍 267 👎 0

package leetcode.editor.cn;

//Java：区域和检索 - 数组可修改
public class P307RangeSumQueryMutable {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray numArray = new P307RangeSumQueryMutable().new NumArray(nums);
        // TO TEST
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int sizeOfSegmentTree;//线段树的节点数量
        int[] SegmentTree;//用数组实现线段树
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sizeOfSegmentTree = (nums.length << 2) - 1;
            SegmentTree = new int[sizeOfSegmentTree];
            build(0, this.nums.length - 1, 1);
        }

        /**
         * 根据nums建线段树.
         *
         * @param left  nums的左边界（包含）
         * @param right nums的右边界（包含）
         * @param root  当前结点下标
         */
        private void build(int left, int right, int root) {
            if (left == right) {
                SegmentTree[root] = nums[left];
                return;
            }
            int mid = (right + left) >>> 1;
            build(left, mid, root << 1);
            build(mid + 1, right, root << 1 | 1);
            pushUp(root, root << 1, root << 1 | 1);
        }

        private void pushUp(int root, int lChild, int rChild) {
            SegmentTree[root] = SegmentTree[lChild] + SegmentTree[rChild];
        }

        //nums[index] to val,本题只有单个位置的更新，所以不用维护更新表
        public void update(int index, int val) {
            update(index, index, val, 0, nums.length - 1, 1);
        }

        /**
         * 更新线段树.
         *
         * @param l    要更新的区域左边界（包含）
         * @param r    要更新的区域右边界（包含）
         * @param C    更新值
         * @param L    nums左边界（包含）
         * @param R    nums右边界（包含）
         * @param root 开始向下更新的节点
         */
        private void update(int l, int r, int C, int L, int R, int root) {
            if (l <= L && r >= R) {//必定是l==L==R==r
                SegmentTree[root] = C;
                return;
            }
            //下发任务
            int mid = (L + R) >>> 1;
            if (l <= mid) {
                update(l, r, C, L, mid, root << 1);
            }
            if (r > mid) {
                update(l, r, C, mid + 1, R, root << 1 | 1);
            }
            pushUp(root, root << 1, root << 1 | 1);
        }


        public int sumRange(int left, int right) {
            return query(left, right, 0, nums.length - 1, 1);
        }

        private int query(int l, int r, int L, int R, int rt) {
            if (l <= L && r >= R) {
                return SegmentTree[rt];
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
            pushUp(rt, rt << 1, rt << 1 | 1);//沿途没有懒着的任务，所以每次更新完整个线段树所有节点的值都是正确的，这里都不用pushUp了
            return ans;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
