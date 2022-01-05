package leetcode.editor.cn;
//Java：单词频率

/**
 * <p>设计一个方法，找出任意指定单词在一本书中的出现频率。</p>
 *
 * <p>你的实现应该支持如下操作：</p>
 *
 * <ul>
 * <li><code>WordsFrequency(book)</code>构造函数，参数为字符串数组构成的一本书</li>
 * <li><code>get(word)</code>查询指定单词在书中出现的频率</li>
 * </ul>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>WordsFrequency wordsFrequency = new WordsFrequency({&quot;i&quot;, &quot;have&quot;, &quot;an&quot;, &quot;apple&quot;, &quot;he&quot;, &quot;have&quot;, &quot;a&quot;, &quot;pen&quot;});
 * wordsFrequency.get(&quot;you&quot;); //返回0，&quot;you&quot;没有出现过
 * wordsFrequency.get(&quot;have&quot;); //返回2，&quot;have&quot;出现2次
 * wordsFrequency.get(&quot;an&quot;); //返回1
 * wordsFrequency.get(&quot;apple&quot;); //返回1
 * wordsFrequency.get(&quot;pen&quot;); //返回1
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>book[i]</code>中只包含小写字母</li>
 * <li><code>1 &lt;= book.length &lt;= 100000</code></li>
 * <li><code>1 &lt;= book[i].length &lt;= 10</code></li>
 * <li><code>get</code>函数的调用次数不会超过100000</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>字典树</li><li>数组</li><li>哈希表</li><li>字符串</li></div></div><p><div><li>👍 23</li><li>👎 0</li></div>
 */
public class P面试题_1602WordsFrequencyLcci {
    public static void main(String[] args) {
        String[] book = new String[]{"f", "f", "oiv", "nqvgj", "dxk", "haygr", "wyvxl", "nqvgj", "f",
                "dyfqm", "f", "spq", "f", "zeqyr", "f", "dxk", "dxk", "o", "bjwt", "sbph", "nb", "f",
                "f", "txamz", "nqvgj", "f", "hmqls", "f", "f", "smuff", "nvfl", "f", "pxa", "f", "f",
                "f", "f"};
        String[] getWord = new String[]{"nqvgj", "smuff", "nvfl", "dyfqm", "spq", "dxk", "haygr", "o",
                "zeqyr", "f", "txamz", "wyvxl", "hmqls", "nb", "sbph", "bjwt", "pxa", "wqvn"};
        WordsFrequency wordsFrequency = new P面试题_1602WordsFrequencyLcci().new WordsFrequency(book);
        // TO TEST
        for (String s : getWord) {
            System.out.println(wordsFrequency.get(s));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordsFrequency {
        int[] count;
        WordsFrequency[] next;

        public WordsFrequency() {
            count = new int[26];
            next = new WordsFrequency[26];
        }

        public WordsFrequency(String[] book) {
            this();
            for (String s : book) {
                add(this, s);
            }
        }

        public int get(String word) {
            if (word == null || word.length() == 0) {
                return 0;
            }
            return find(this, word);
        }

        public void add(WordsFrequency wordsFrequency, String s) {
            if (s == null || s.length() == 0) {
                return;
            }
            if (s.length() == 1) {
                wordsFrequency.count[s.charAt(0) - 'a']++;
                return;
            }
            if (wordsFrequency.next[s.charAt(0) - 'a'] == null) {
                wordsFrequency.next[s.charAt(0) - 'a'] = new WordsFrequency();
            }
            add(wordsFrequency.next[s.charAt(0) - 'a'], s.substring(1));
        }

        public int find(WordsFrequency wordsFrequency, String s) {
            if (wordsFrequency == null) {
                return 0;
            }
            if (s.length() == 1) {
                return wordsFrequency.count[s.charAt(0) - 'a'];
            }
            return find(wordsFrequency.next[s.charAt(0) - 'a'], s.substring(1));
        }
    }

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}