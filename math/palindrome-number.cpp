class Solution {
public:
    bool isPalindrome(int x) {
        string y = to_string(x);
        if(y.length()==1){
            return true;
        }
        
        if(y.length()%2==0){
           int mid = y.length()/2;
            for(int i=0;i<mid;i++){
                if(y[i]!=y[y.length()-1-i]){
                    return false;
                }
            }
        }else{
           int mid = y.length()/2;
            for(int i=0;i<mid;i++){
                if(y[i]!=y[y.length()-1-i]){
                    return false;
                }
            }
        }
            return true;
    }

};