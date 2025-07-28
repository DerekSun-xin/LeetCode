class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int> map1;
        for(int i=0;i<s.length();i++){
           if(map1.find(s[i])!=map1.end()){
               map1[s[i]]++;
           } else{
               map1[s[i]]=1;
           }
        }
        
        vector<char> unique;
        for(auto x:map1){
            if(x.second==1){
                unique.push_back(x.first);
            }
        }
        
        if(unique.size()==0){
            return -1;
        }else{
            for(int i=0;i<s.length();i++){
                vector<char>::iterator it;
                it= find(unique.begin(),unique.end(),s[i]);
                if(it!=unique.end()){
                    return i;
                }
            }
        }
        
        return -1;
        
        
        
        
        
        
    }
};