package leetcode.editor.cn;

public class P1620CoordinateWithMaximumNetworkQuality {
    public static void main(String[] args) {
        Solution solution = new P1620CoordinateWithMaximumNetworkQuality().new Solution();
        // TO TEST
    }

    //Java：网络信号最好的坐标
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int maxX = 0, minX = Integer.MAX_VALUE, maxY = 0, minY = Integer.MAX_VALUE;
            for (int[] t : towers) {
                maxX = Math.max(maxX, t[0]);
                maxY = Math.max(maxY, t[1]);
                minX = Math.min(minX, t[0]);
                minY = Math.min(minY, t[1]);
            }
            int xLen = maxX - minX + 1, yLen = maxY - minY + 1, maxSignal = 0, ansX = 0, ansY = 0;
            int[][] mat = new int[xLen][yLen];
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    int x = minX + i, y = minY + j;
                    for (int[] t : towers) {
                        double d = Math.sqrt((x - t[0]) * (x - t[0]) + (y - t[1]) * (y - t[1]));
                        int signal = d > radius ? 0 : (int) (t[2] / (1 + d));
                        mat[i][j] += signal;
                    }
                    if (mat[i][j] > maxSignal) {
                        maxSignal = mat[i][j];
                        ansX = x;
                        ansY = y;
                    }
                    if (mat[i][j] == maxSignal) {
                        if (x < ansX || (x == ansX && y < ansY)) {
                            ansX = x;
                            ansY = y;
                        }
                    }
                }
            }
            return new int[]{ansX, ansY};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}