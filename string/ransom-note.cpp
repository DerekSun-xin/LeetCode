class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char,int> map1;
        
        for(int i=0;i<magazine.length();i++){
            if(map1.find(magazine[i])!=map1.end()){
                map1[magazine[i]]++;
            }else{
                map1[magazine[i]]=1;
            }
        }
        
        
        for(int i=0;i<ransomNote.length();i++){
            if(map1.find(ransomNote[i])==map1.end()){
                //Not Found;
                return false;
            }else{
                if(map1[ransomNote[i]]==0){
                    //Not Found;
                    return false;
                }else{
                    map1[ransomNote[i]]--;
                }
            }
        }
        
        return true;
    }
};