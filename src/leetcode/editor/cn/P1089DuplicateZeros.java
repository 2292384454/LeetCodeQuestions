//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 
// 👍 72 👎 0

package leetcode.editor.cn;

//Java：复写零
public class P1089DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new P1089DuplicateZeros().new Solution();
        // TO TEST


        int[] arr = new int[]{0, 1, 9, 2, 6, 0, 0, 4, 1, 0};
        solution.duplicateZeros(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int count = 0;//用于记录数组中的可复制的0的个数 如 原数组若为1，0，2，3，0，4，则真正可以复制的0其实只有一个（index = 1）
            int flag = 0;//用于记录数组中最后一个可复制的0的索引
            for (int i = 0; i < arr.length; i++)//遍历一遍寻找可以复制的0的总数
            {
                if (arr[i] == 0 && i + 1 + count < arr.length) { //0可复制的要求：自身索引向后移一位 + 前面因复制0造成的移动的位移量  在数组总长度之内
                    count++;
                    flag = i;//记录数组中最后一个可复制的0的索引（ 1，0，2，3，0，4中即为index = 1 的0是最后一个可以复制的0，此时flag = 1）
                }
            }

            if (count == 0) {
                return;//说明没有可以复制的0，直接返回原数组
            }

            for (int i = arr.length - count - 1, j = arr.length - 1; i >= 0 && j >= 0; i--, j--) { //i代表真正被包含到结果数组中的最后一个索引，如 原数组若为1，0，2，3，0，4，
                //结果为 1，0，0，2，3，0，则i代表的就是原数组中的0（index= 4）
                //j指向最后一个元素
                if (arr[i] != 0 || (i > flag && arr[i] == 0)) {
                    arr[j] = arr[i];
                }
                    //当 原数组为1，0，2，3，0，4，结果为 1，0，0，2，3，0，时，可以发现index为4的0是不能被复制的，此时之前的flag就派上了用场，
                    //若i指向的数字为0但索引却大于最后一个可复制的0的索引(flag)，则不能复制此0
                else {
                    arr[j--] = 0;//否则 若i指向的值为0时，arr[j]和arr[j-1]都赋值为0
                    arr[j] = 0;
                }

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
