### 解题思路
我们建立一个单栈来存储和更新乘除运算后的数，用一个字符变量表示op乘除符号。用sign=1或-1来表示加减符号。
还是记住几个关键点：
1.空格直接放过；
2.遇到加减运算符，st_num才出栈，并且更新ans和sign
3.遇到数字，先找完，再进栈，如果在它之前有乘除符号（也就是op不为‘#’），那么就要和弹出栈的数字做乘除运算更新它，在乘除运算完之后，才能入栈，然后op重置。
具体看代码:
![无标题1.png](https://pic.leetcode-cn.com/1615444023-jpFiWE-%E6%97%A0%E6%A0%87%E9%A2%981.png)


### 代码
```java
    public int calculate(String s) {
        int len=s.length();
        char[] str=s.toCharArray();
        Stack<Integer> st_num=new Stack<>();
        char op='#';         //记录乘除符号
        int ans=0,sign=1;    //记录加减符号
        for(int i=0;i<len;i++){
            if(str[i]==' ') continue;
            if(str[i]>='0'&&str[i]<='9'){
                int num=str[i]-'0';
                while(i<len-1&&str[i+1]>='0'&&str[i+1]<='9')  //找完这个数
                    num=num*10+(str[++i]-'0');
                if(op!='#'){                                //如果之前有乘除符号
                    if(op=='*')num*=st_num.pop();           //则将这个数运算之后，再重新进栈
                    else num=st_num.pop()/num;
                    op='#';                                //重置乘除符号
                }
                st_num.push(num);
            }
            else if(str[i]=='*'||str[i]=='/') op=str[i];  //更新乘除符号
            else{                                         //遇到加减符号则可以直接更新ans了
                ans+=st_num.pop()*sign;
                sign=str[i]=='+'?1:-1;   //更新加减符号
            }
        }
        return ans+st_num.pop()*sign;   //sign更新后，还有一次未计算
    }
```