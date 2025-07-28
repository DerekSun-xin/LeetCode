class Solution {
public:
    int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid=x/2;
        
        while(low<high){
             long square = (long)mid*mid;
            if(x==square){
                return mid;
            }else if(x>square){
                 long bigger = (mid+1)*(mid+1);
                if(x<bigger){
                    return mid;
                }else{
                    low=mid+1;
                    mid=(low+high)/2;
                }
                
            }else if(x<square){
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        
        return mid;
    }
};