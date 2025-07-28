class Solution {
public:
    bool detectCapitalUse(string word) {
           if(!isupper(word[0])){  
               return secondCriteria(word);
           }else{
              
                return firstCriteria(word)||thirdCriteria(word);
           }  
        
    }
    
    bool secondCriteria(string word){ 
        for(int i=0;i<word.size();i++){
            if(isupper(word[i])){
                return false;
            }
        }
        return true;
    }
    
    bool firstCriteria(string word){
        for(int i=0;i<word.size();i++){
            if(isupper(word[i])){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    bool thirdCriteria(string word){
        for(int i=0;i<word.size();i++){
            if(i==0){
               if(!isupper(word[i])){
                   return false;
               } 
            }else{
                if(isupper(word[i])){
                   return false;
               } 
            }
        }
        return true;
    }
    
};