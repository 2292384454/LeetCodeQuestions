package leetcode.editor.cn;

import java.util.*;

public class P1169InvalidTransactions {
    public static void main(String[] args) {
        Solution solution = new P1169InvalidTransactions().new Solution();
        // TO TEST
    }

    //Java：查询无效交易
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            int len = transactions.length;
            String[][] orders = new String[len][4];
            Map<String, List<Integer>> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                orders[i] = transactions[i].split(",");
                String name = orders[i][0], time = orders[i][1], amount = orders[i][2], city = orders[i][3];
                if (Integer.parseInt(amount) > 1000) {
                    set.add(i);
                }
                List<Integer> sameNames = map.getOrDefault(name, new ArrayList<>());
                for (int idx : sameNames) {
                    String[] order = orders[idx];
                    if (!order[3].equals(city) && Math.abs(Integer.parseInt(order[1]) - Integer.parseInt(time)) <= 60) {
                        set.add(idx);
                        set.add(i);
                    }
                }
                sameNames.add(i);
                map.put(name, sameNames);
            }
            List<String> ans = new ArrayList<>();
            for (int index : set) {
                ans.add(transactions[index]);
            }
            return ans;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}