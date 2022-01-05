package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
 * O(1)空间复杂度找出数组 arr 中每个元素出现的次数.
 * <p>
 * arr.length==n ，1<=arr[i]<=n
 * <p>
 * 创建时间: 2021/7/31 17:42
 *
 * @author KevinHwang
 */
public class InPlaceHash {
    public static void main(String[] args) {
        final int N = 10;
        Random random = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(N) + 1;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            while (arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            if (arr[i] - 1 == i) {
                arr[i] = Math.min(arr[i], 0) - 1;
            } else if (arr[i] > 0) {
                if (arr[arr[i] - 1] == arr[i]) {
                    arr[arr[i] - 1] = -1;
                }
                arr[arr[i] - 1] -= 1;
                arr[i] = Math.min(arr[i], 0);
            }
        }
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                System.out.println((i + 1) + " 出现了 " + (-arr[i]) + "次");
            }
        }
    }
}
