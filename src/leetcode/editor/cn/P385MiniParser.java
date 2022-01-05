package leetcode.editor.cn;
//Java：迷你语法分析器

import java.util.*;

/**
 * <p>给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。</p>
 *
 * <p>列表中的每个元素只可能是整数或整数嵌套列表</p>
 *
 * <p><strong>提示：</strong>你可以假定这些字符串都是格式良好的：</p>
 *
 * <ul>
 * <li>字符串非空</li>
 * <li>字符串不包含空格</li>
 * <li>字符串只包含数字<code>0-9</code>、<code>[</code>、<code>-</code>、<code>,</code>、<code>]</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>给定 s = &quot;324&quot;,
 *
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>给定 s = &quot;[123,[456,[789]]]&quot;,
 *
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 *
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * i.  一个 integer 包含值 456
 * ii. 一个包含一个元素的嵌套列表
 * a. 一个 integer 包含值 789
 * </pre>
 * <div><div>Related Topics</div><div><li>栈</li><li>深度优先搜索</li><li>字符串</li></div></div><p><div><li>👍 65</li><li>👎 0</li></div>
 */
public class P385MiniParser {
    public static void main(String[] args) {
        Solution solution = new P385MiniParser().new Solution();
        // TO TEST
        String s = "[123,456,[788,799,833],[[]],10,[]]";
        NestedInteger ans = solution.deserialize(s);
        System.out.println(ans);
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        String ans;
        List<NestedInteger> l;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            l = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            ans = String.valueOf(value);
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return l == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return Integer.parseInt(ans);
        }


        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            ans = String.valueOf(value);
        }


        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            l.add(ni);
        }


        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return l;
        }

        @Override
        public String toString() {
            if (isInteger()) {
                return ans;
            } else {
                return l.toString();
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 记录左括号与右括号
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        public NestedInteger deserialize(String s) {
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(i);
                } else if (c == ']') {
                    map.put(stack.pop(), i);
                }
            }
            return helper(s, 0, s.length()).getList().get(0);
        }

        public NestedInteger helper(String s, int start, int end) {
            NestedInteger ans = new NestedInteger();
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    int j = map.get(i);
                    // 左右括号之间的内容，递归
                    ans.add(helper(s, i + 1, j));
                    i = j + 1;
                } else if (c == ',') {
                    // 数字添加到 ans 中
                    try {
                        ans.add(new NestedInteger(Integer.parseInt(sb.toString())));
                    } catch (NumberFormatException ignored) {
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                    // 到结尾了，数字添加到 ans 中
                    if (i == end - 1) {
                        try {
                            ans.add(new NestedInteger(Integer.parseInt(sb.toString())));
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}