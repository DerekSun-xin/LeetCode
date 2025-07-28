class Solution {
public:
    bool canPermutePalindrome(string s) {
        unordered_map<char,int> map;
        for(int i=0;i<s.length();i++){
            if(map.find(s[i])!=map.end()){
                map[s[i]]++;
            }else{
                map[s[i]]=1;
            }
        }
        
        int num = 0;
        int success = 0;
        for(auto i:map){
            if(i.second % 2!=0){
                num++;
            }
        }
        
        if(num>1){
            return false;
        }else{
            return true;
        }
        
    }
};