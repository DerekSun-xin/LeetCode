class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
       string prefix ="";
       
        bool judge = true;
        string first = strs[0];
        for(int i=1;i<strs.size();i++){
            if(strs[i]!=first){
                judge=false;
                break;
            }
        }
        if(judge){
            return first;
        }
        
        for(int i=0;i<=200;i++){
            char test=strs[0][i];
            for(int j=0;j<strs.size();j++){
                if(strs[j][i]!=test){
                    return prefix;
                }
            }
            prefix+=test;
            
        }
        return prefix;
    }
};