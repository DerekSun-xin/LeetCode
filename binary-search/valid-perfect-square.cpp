class Solution {
public:
    bool isPerfectSquare(int num) {
        long long begin = 1;
        long long end = num;
        long long mid = begin+(end-begin)/2;
        
        while(begin<=end){
           
                long long sqrt = mid*mid;
                if(sqrt>num){
                    end = mid-1;
                }else if(sqrt<num){
                    begin = mid+1;
                }else{
                    return true;
                } 
            
            
            
            
            mid = begin+(end-begin)/2;
        }
        
        return false;
        
        
        
        
    }
};