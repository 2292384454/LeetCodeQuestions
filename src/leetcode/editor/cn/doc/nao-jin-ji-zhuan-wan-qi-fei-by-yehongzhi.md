### 解题思路
回文子序列不是回文子字符串，比如"aababdaba"，"aaaaa"就是他的回文子序列。
也就是顶多删两次，一次全删掉"a"，一次全删掉"b"。
如果是回文字符串，就删一次。
空字符串就0次。
看代码吧，不想说了。

### 代码

```java
class Solution {
    public int removePalindromeSub(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }
        return 2;
    }
}
```