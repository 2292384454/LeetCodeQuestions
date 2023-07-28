package leetcode.editor.cn;

public class P1700NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        Solution solution = new P1700NumberOfStudentsUnableToEatLunch().new Solution();
        // TO TEST
        int[] students = new int[]{1, 1, 1, 0, 0, 1}, sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        System.out.println(solution.countStudents(students, sandwiches));
    }

    //Java：无法吃午餐的学生数量
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] cnt = new int[2];
            for (int student : students) {
                cnt[student]++;
            }
            int n = sandwiches.length;
            for (int i = 0; i < n; i++) {
                if ((--cnt[sandwiches[i]]) < 0) {
                    return n - i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}