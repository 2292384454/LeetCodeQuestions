本题首先是字符串的分离。 根据空格进行分离 C++没有直接split函数很蛋疼
分离后就是两个哈希表 双向映射  和leetcode[205]题一样。
要注意的地方是： 分离字符串时最后一个字符串 没有空格判定 直接末尾判定即可。
```
class Solution {
public:
    bool wordPattern(string pattern, string str) {
        map<char,string> mp;
        map<string,char> pm;
        int j=0;
        vector<string>arr;
        for(int i=0;i<str.size();++i){
            if(i==str.size()-1){
                arr.push_back(str.substr(j,str.size()-j));
            }
            if(str[i]==' '){
                arr.push_back(str.substr(j,i-j));
                j=i+1;
            }
        }
        if(pattern.size()!=arr.size()) return false;
        for(int i=0;i<pattern.size();++i){
            if(mp.find(pattern[i])!=mp.end() && mp[pattern[i]]!=arr[i]){
                return false;
            }
            if(pm.find(arr[i])!=pm.end()&& pm[arr[i]]!=pattern[i])
                return false;
            
            mp[pattern[i]]=arr[i];
            pm[arr[i]]=pattern[i];
        }
        return true;

    }
};
```
