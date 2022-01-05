### 解题思路
两次循环
第一次遍历数组拼接成一个长字符串S
第二次遍历数组查找字符串在S中出现的位置，如果是别人的子串，那么在S中的出现次数一定 >= 2，那么起始跟结束的位置索引一定是不一样的，如果一样说明不是子串。
注意：为了避免前一字符串的尾部与后一字符串的头部构成混淆项，各字符串用,隔开拼接。

### 代码

```java
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            builder.append(str + ",");
        }

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (builder.toString().indexOf(str) != builder.toString().lastIndexOf(str)) {
                list.add(str);
            }
        }
        return list;
    }
}
```