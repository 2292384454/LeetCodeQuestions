### 解题思路
回溯法,注意左右括号的数量一定是一样的，如果某一种括号超过半数，跳出循环。

### 代码

```c
//判断括号是否有效；
bool isValid(char * s,int n){
    char sym[17] = {0};
    int i,index = 1,time = 0,len = strlen(s);

    for(i = 0;i < len;i++){
        if(s[i] == '('){
            sym[index++] = s[i];
            time++;
            if(time > n) return false;
            continue;
        }
        if(sym[index-1] == '('){    //右括号左边一定要紧挨着左括号，否则返回false；
            sym[--index] = 0;
        }
        else
            return false;
    }
    return true;
}

//放置括号;
//注意返回值,返回的是二维数组最后一行(这一行的括号不是正确的)的指针;
//这种写法诡异,奈何力扣不允许用全局变量;
char** set(char** s,int index,int n){
    if(index == 2*n){   //放满就换一行,同时将数据复制到新的行，以此达到回溯效果;
        s++;  //使二维数组指针加一，达到换行效果;
        for(int i = 0;i < index;i++){
            s[0][i] = (s-1)[0][i];          //复制数据;
        }
        return s;   
    }
    s[0][index] = '(';      //随便先放一个;
    if(isValid(s[0],n)) s = set(s,index+1,n);
    s[0][index] = ')';      //不合格就再换一个;
    if(isValid(s[0],n)) s = set(s,index+1,n);
    s[0][index] = '\0';     //回溯之前要把当前的位置空出来;
    return s;
}

char ** generateParenthesis(int n, int* returnSize){
    *returnSize = 0;

    char** ret = malloc(sizeof(char*)*(n*n*n*n+1)); //立方和加一;
    for(int i = 0;i < n*n*n*n+1;i++){
        ret[i] = (char*)malloc(sizeof(char)*(2*n+1));
        memset(ret[i],0,sizeof(char)*(2*n+1));
    }


    char **s = set(ret,0,n);
    *returnSize = (s - ret);    //相减就是总行数;
    return ret;
}
```