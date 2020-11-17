可以结合下面的代码进行思考；

1.二分搜索-->>寻找在有序列表里比目标字母大的最小字母：
    这里可以理解成为左边界搜索，当mid值等于target时，也去进行left=mid+1的操作，这样当循环结束的时候，结果就会是target的下一位，即比目标字母大的最小字母；

2.循环比较的巧妙处理：
    什么时候会产生循环比较？
    可以通过例子来理解：
         1.  target = 'z',letters = ['a', 'b']，return 'a'
         2.  target = 'j',letters = ['c', 'f','j']，return 'c'
         3.  target = 'k',letters = ['c', 'f','j']，return 'c'
    这三个例子都有两个共同的特点：
        1.  letters里没有比target大的元素，又因为letters已经排好序了，这里可以就得出：target>=letters[letters.length-1]；
        2.  return 的 'a','c','c'都是列表的第一个元素，也就是说，循环比较下来，比target大的元素就是列表里最小的元素（当然是在满足上述特点<1>的条件下）即 return letters[0];这里大家可以把letters的元素们和target按照从小到大的顺序连成闭环进行斟酌；

所以附上代码，望大家一起交流成长；

```
    public static char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length;

        if(target>=letters[letters.length-1]){//循环比较的处理
            return letters[0];
        }else{
            while (left<right){//二分搜索的应用
                int mid=(left+right)/2;
                if(letters[mid]<=target)left=mid+1;
                if(letters[mid]>target)right=mid;
            }
            return letters[left];
        }
    }

```
`内联代码`
