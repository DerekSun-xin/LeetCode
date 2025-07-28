class Solution {
public:
    int arrangeCoins(int n) {
        long begin = 0;
        long end = n;
        if(n==1){
            return 1;
        }else{
            return int(helper(n,begin,end)) ;
            
        }

        
    }
    
    long helper(int n, long begin, long end){
        long middle =  begin+(end-begin)/2;
        
        if(n<sum(middle)){
            end = middle;
        }else if(n>=sum(middle) && n<sum(middle+1)){
            return middle;
        }else{
            begin = middle;
        }
        
        return helper(n,begin,end);
    }

    long sum(long n){
        return (1+n)*n/2;
    }
};