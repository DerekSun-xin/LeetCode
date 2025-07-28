class Solution {
public:
    char findTheDifference(string s, string t) {
        if(s.length()==0){
            return t[0];
        }
        
        unordered_map<char,int> map1;
        for(int i=0;i<s.length();i++){
            if(map1.find(s[i])!=map1.end()){
                map1[s[i]]++;
            }else{
                map1[s[i]]=1;
            }
        }
        
        for(int i=0;i<t.length();i++){
            if(map1.find(t[i])!=map1.end()){
                if(map1[t[i]]==0){
                    return t[i];
                }else{
                    map1[t[i]]--;
                }
            }else{
                return t[i];
            }
        }
        
       return NULL;
    }
};