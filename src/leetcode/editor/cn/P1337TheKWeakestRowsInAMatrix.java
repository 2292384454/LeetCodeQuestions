//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 二分查找 
// 👍 41 👎 0

package leetcode.editor.cn;


//Java：矩阵中战斗力最弱的 K 行
public class P1337TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P1337TheKWeakestRowsInAMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            int[] result = new int[k];
            int[] counts = new int[m];
            for (int i = 0; i < m; i++) {
                counts[i] = countOfOne(mat[i]);
            }
            //count[i]的范围都在[0,n]范围内，找到counts数组中前k小的数
            int c = 0, kk = 0;
            while (kk < k) {
                for (int i = 0; i < m; i++) {
                    if (counts[i] == c) {
                        if (kk < k) {
                            result[kk++] = i;
                        } else {
                            return result;
                        }
                    }
                }
                c++;
            }
            return result;
        }

        /**
         * 用二分查找找到最后一个1的位置，返回其加1的结果即为arr中1的个数
         *
         * @param arr 输入数组
         * @return arr中1的个数
         */
        public int countOfOne(int[] arr) {
            int left = 0, right = arr.length - 1, mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if ((mid + 1 < arr.length && arr[mid] == 1 && arr[mid + 1] == 0) || mid + 1 == arr.length && arr[mid] == 1) {
                    return mid + 1;
                } else if (arr[mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
