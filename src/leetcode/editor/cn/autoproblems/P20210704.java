package leetcode.editor.cn.autoproblems;

import java.util.Arrays;
import java.util.Random;

/**
 * 2021年7月4日看到的一个有意思的题目.
 * <p>
 * 给定包含N个数的无序数组S（可能包含负数，0，正数，N>=3）。求三个数A,B,C，使其和的绝对值最小。
 * <p>
 * 例如：S={-9，0，1，3，6}，A=-9,B=3,C=6,MIN=0
 * <p>
 * 创建时间: 2021/7/4 16:14
 *
 * @author KevinHwang
 */
public class P20210704 {
    public static void main(String[] args) {
        // TO TEST
        Solution solution = new P20210704().new Solution();
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) - 50;
        }
        System.out.println(Arrays.toString(arr));
        int[] ans = solution.minABS(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println("abs=" + (ans[0] + ans[1] + ans[2]));
    }

    class Solution {
        /**
         * 对数组a排序后枚举其中1个数cur（a[i]），使用双向指针head、tail从数组两端更新（注意剔除掉cur）。
         * 根据a[head]+a[tail]+cur的正负号来更新head或tail。若为负则head++，否则tail--。一旦和为0即退出。
         * 同时根据此和来更新MIN。最后MIN即为所求。利用三个变量X,Y,Z记录任一最优解在排序后数组中的下标。
         * 该方法最坏的时间复杂度为O(N^2)。
         */
        public int[] minABS(int[] arr) {
            int min = Integer.MAX_VALUE;
            int[] ans = new int[3];
            // Arrays.sort(arr);
            quickSort(arr);
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                int low = 0, high = len - 1;
                while (low <= high) {
                    if (low == i) {
                        low++;
                        continue;
                    }
                    if (high == i) {
                        high--;
                        continue;
                    }
                    int sum = arr[i] + arr[low] + arr[high];
                    int abs = Math.abs(sum);
                    if (abs < min) {
                        min = abs;
                        ans[0] = arr[low];
                        ans[1] = arr[i];
                        ans[2] = arr[high];
                        // 提前退出，节约时间
                        if (min == 0) {
                            break;
                        }
                    } else if (abs < 0) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            return ans;
        }

        /**
         * 复习一下快排
         */
        private void quickSort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l <= r) {
                int pos = partition(nums, l, r);
                quickSort(nums, l, pos - 1);
                quickSort(nums, pos + 1, r);
            }
        }

        private int partition(int[] nums, int l, int r) {
            int temp = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= temp) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] <= temp) {
                    l++;
                }
                nums[r] = nums[l];
            }
            nums[l] = temp;
            return l;
        }

    }
}
