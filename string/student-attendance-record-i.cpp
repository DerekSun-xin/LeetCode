class Solution {
public:
    bool checkRecord(string s) {
        return firstCriteria(s) && secondCriteria(s);
    }
    
    bool firstCriteria(string s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='A'){
                count++;
            }
        }
        
        if(count<2){
            return true;
        }else{
            return false;
        }
    }
    
    bool secondCriteria(string s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='L'){
                count++;
            }else{
                if(count<3){
                    count = 0;
                }else{
                    return false;
                }
            }
        }
        
        if(count>=3){
            return false;
        }
        
        return true;
    }

   
};