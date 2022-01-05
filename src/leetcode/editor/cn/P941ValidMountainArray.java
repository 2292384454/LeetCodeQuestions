//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// A.length >= 3 
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：[2,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：[3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
//
// 
// Related Topics 数组 
// 👍 125 👎 0

package leetcode.editor.cn;

//Java：有效的山脉数组
public class P941ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new P941ValidMountainArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;//如果数组长度小于3，那么一定不是山脉数组
            }
            int i = 1;
            while (i < arr.length && arr[i] > arr[i - 1])//找到山顶（如果是山脉数组）
            {
                i++;
            }
            if (i == 1 || i == arr.length)//如果山顶在第一个位置或者越界，那么返回false
            {
                return false;
            }
            while (i < arr.length) {//判断从山顶往后是不是都是严格递减的
                if (arr[i] >= arr[i - 1]) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
