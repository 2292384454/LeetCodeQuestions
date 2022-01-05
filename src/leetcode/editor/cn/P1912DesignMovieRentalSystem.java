package leetcode.editor.cn;
//Java：设计电影租借系统

import java.util.*;

/**
 * <p>你有一个电影租借公司和 <code>n</code> 个电影商店。你想要实现一个电影租借系统，它支持查询、预订和返还电影的操作。同时系统还能生成一份当前被借出电影的报告。</p>
 *
 * <p>所有电影用二维整数数组 <code>entries</code> 表示，其中 <code>entries[i] = [shop<sub>i</sub>, movie<sub>i</sub>, price<sub>i</sub>]</code> 表示商店 <code>shop<sub>i</sub></code> 有一份电影 <code>movie<sub>i</sub></code> 的拷贝，租借价格为 <code>price<sub>i</sub></code> 。每个商店有 <strong>至多一份</strong> 编号为 <code>movie<sub>i</sub></code> 的电影拷贝。</p>
 *
 * <p>系统需要支持以下操作：</p>
 *
 * <ul>
 * <li><strong>Search：</strong>找到拥有指定电影且 <strong>未借出</strong> 的商店中 <strong>最便宜的 5 个</strong> 。商店需要按照 <strong>价格</strong> 升序排序，如果价格相同，则 <code>shop<sub>i</sub></code> <strong>较小</strong> 的商店排在前面。如果查询结果少于 5 个商店，则将它们全部返回。如果查询结果没有任何商店，则返回空列表。</li>
 * <li><strong>Rent：</strong>从指定商店借出指定电影，题目保证指定电影在指定商店 <strong>未借出</strong> 。</li>
 * <li><strong>Drop：</strong>在指定商店返还 <strong>之前已借出</strong> 的指定电影。</li>
 * <li><strong>Report：</strong>返回 <strong>最便宜的 5 部已借出电影</strong> （可能有重复的电影 ID），将结果用二维列表 <code>res</code> 返回，其中 <code>res[j] = [shop<sub>j</sub>, movie<sub>j</sub>]</code> 表示第 <code>j</code> 便宜的已借出电影是从商店 <code>shop<sub>j</sub></code> 借出的电影 <code>movie<sub>j</sub></code> 。<code>res</code> 中的电影需要按 <strong>价格</strong> 升序排序；如果价格相同，则<strong> </strong><code>shop<sub>j</sub></code> <strong>较小</strong> 的排在前面；如果仍然相同，则 <code>movie<sub>j</sub></code> <strong>较小 </strong>的排在前面。如果当前借出的电影小于 5 部，则将它们全部返回。如果当前没有借出电影，则返回一个空的列表。</li>
 * </ul>
 *
 * <p>请你实现 <code>MovieRentingSystem</code> 类：</p>
 *
 * <ul>
 * <li><code>MovieRentingSystem(int n, int[][] entries)</code> 将 <code>MovieRentingSystem</code> 对象用 <code>n</code> 个商店和 <code>entries</code> 表示的电影列表初始化。</li>
 * <li><code>List&lt;Integer&gt; search(int movie)</code> 如上所述，返回 <strong>未借出</strong> 指定 <code>movie</code> 的商店列表。</li>
 * <li><code>void rent(int shop, int movie)</code> 从指定商店 <code>shop</code> 借出指定电影 <code>movie</code> 。</li>
 * <li><code>void drop(int shop, int movie)</code> 在指定商店 <code>shop</code> 返还之前借出的电影 <code>movie</code> 。</li>
 * <li><code>List&lt;List&lt;Integer&gt;&gt; report()</code> 如上所述，返回最便宜的 <strong>已借出</strong> 电影列表。</li>
 * </ul>
 *
 * <p><strong>注意：</strong>测试数据保证 <code>rent</code> 操作中指定商店拥有 <strong>未借出 </strong>的指定电影，且 <code>drop</code> 操作指定的商店 <strong>之前已借出</strong> 指定电影。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * ["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
 * [[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
 * <strong>输出：</strong>
 * [null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
 *
 * <strong>解释：</strong>
 * MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
 * movieRentingSystem.search(1);  // 返回 [1, 0, 2] ，商店 1，0 和 2 有未借出的 ID 为 1 的电影。商店 1 最便宜，商店 0 和 2 价格相同，所以按商店编号排序。
 * movieRentingSystem.rent(0, 1); // 从商店 0 借出电影 1 。现在商店 0 未借出电影编号为 [2,3] 。
 * movieRentingSystem.rent(1, 2); // 从商店 1 借出电影 2 。现在商店 1 未借出的电影编号为 [1] 。
 * movieRentingSystem.report();   // 返回 [[0, 1], [1, 2]] 。商店 0 借出的电影 1 最便宜，然后是商店 1 借出的电影 2 。
 * movieRentingSystem.drop(1, 2); // 在商店 1 返还电影 2 。现在商店 1 未借出的电影编号为 [1,2] 。
 * movieRentingSystem.search(2);  // 返回 [0, 1] 。商店 0 和 1 有未借出的 ID 为 2 的电影。商店 0 最便宜，然后是商店 1 。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= n <= 3 * 10<sup>5</sup></code></li>
 * <li><code>1 <= entries.length <= 10<sup>5</sup></code></li>
 * <li><code>0 <= shop<sub>i</sub> < n</code></li>
 * <li><code>1 <= movie<sub>i</sub>, price<sub>i</sub> <= 10<sup>4</sup></code></li>
 * <li>每个商店 <strong>至多</strong> 有一份电影 <code>movie<sub>i</sub></code> 的拷贝。</li>
 * <li><code>search</code>，<code>rent</code>，<code>drop</code> 和 <code>report</code> 的调用 <strong>总共</strong> 不超过 <code>10<sup>5</sup></code> 次。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>Ordered Map</li><li>堆（优先队列）</li></div></div><p><div><li>👍 10</li><li>👎 0</li></div>
 */
public class P1912DesignMovieRentalSystem {
    public static void main(String[] args) {
        // TO TEST
        int[][] entries = new int[][]{
                {0, 418, 3},
                {9, 5144, 46},
                {2, 8986, 29},
                {6, 1446, 28},
                {3, 8215, 97},
                {7, 9105, 34},
                {6, 9105, 30},
                {5, 1722, 94},
                {9, 528, 40},
                {3, 850, 77},
                {3, 7069, 40},
                {8, 1997, 42},
                {0, 8215, 28},
                {7, 4050, 80},
                {4, 7100, 97},
                {4, 9686, 32},
                {4, 2566, 93},
                {2, 8320, 12},
                {2, 5495, 56}};
        MovieRentingSystem movieRentingSystem = new P1912DesignMovieRentalSystem().new MovieRentingSystem(10, entries);
        System.out.println(movieRentingSystem.search(7837));
        System.out.println(movieRentingSystem.search(5495));
        movieRentingSystem.rent(4, 7100);
        System.out.println(movieRentingSystem.search(9105));
        System.out.println(movieRentingSystem.search(1446));
        System.out.println(movieRentingSystem.report());
        movieRentingSystem.drop(4, 7100);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovieRentingSystem {
        // key:电影id，value:电影的价格（高20位）和商店（低20位）组成的有序集合
        HashMap<Integer, TreeSet<Long>> movies;
        // key:持有的电影，value:价格
        HashMap<Integer, Integer>[] shops;
        // 已借的电影:price（高20位）,shop（中20位）,movie（低20位）组成的有序集合
        TreeSet<Long> borrowed;
        // 商店（高20位）电影（低20位）组合对应的价格
        HashMap<Long, Integer> prices;

        // 获取低20位的遮罩
        private final long mask0 = 0xfffff;
        // 获取中20位的遮罩
        private final long mask1 = mask0 << 20;
        // 获取高20位的遮罩
        private final long mask2 = mask1 << 20;


        public MovieRentingSystem(int n, int[][] entries) {
            movies = new HashMap<>();
            shops = new HashMap[n];
            // 初始化 borrowed
            borrowed = new TreeSet<>();
            prices = new HashMap<>();
            for (int[] entry : entries) {
                int sIndex = entry[0], mIndex = entry[1], price = entry[2];
                // 填充 movies
                TreeSet<Long> priceAndShop = movies.getOrDefault(mIndex, new TreeSet<>());
                priceAndShop.add(((long) price) << 20 | sIndex);
                movies.put(mIndex, priceAndShop);
                // 填充 shops
                if (shops[sIndex] == null) {
                    shops[sIndex] = new HashMap<>();
                }
                shops[sIndex].put(mIndex, price);
                // 填充 prices
                prices.put(((long) sIndex) << 20 | mIndex, price);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> ret = new ArrayList<>();
            // 取得 movie 对应的 价格和商店组成的有序集合
            TreeSet<Long> priceAndShop = movies.getOrDefault(movie, new TreeSet<>());
            int count = 5;
            // 从有序集合中取得前 5 个
            Iterator<Long> it = priceAndShop.iterator();
            while (it.hasNext() && count > 0) {
                long info = it.next();
                ret.add((int) (info & mask0));
                count--;
            }
            return ret;
        }

        public void rent(int shop, int movie) {
            long price = shops[shop].get(movie);
            shops[shop].remove(movie);
            movies.get(movie).remove(price << 20 | shop);
            borrowed.add(price << 40 | ((long) shop) << 20 | movie);
        }

        public void drop(int shop, int movie) {
            long price = prices.get((long) shop << 20 | movie);
            long info = price << 40 | ((long) shop) << 20 | movie;
            borrowed.remove(info);
            shops[shop].put(movie, (int) price);
            TreeSet<Long> priceAndShop = movies.get(movie);
            priceAndShop.add(price << 20 | shop);
            movies.put(movie, priceAndShop);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> ret = new ArrayList<>();
            int count = 5;
            Iterator<Long> it = borrowed.iterator();
            while (it.hasNext() && count > 0) {
                long info = it.next();
                ret.add(Arrays.asList((int) ((info & mask1) >> 20), (int) (info & mask0)));
                count--;
            }
            return ret;
        }
    }

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
//leetcode submit region end(Prohibit modification and deletion)

}