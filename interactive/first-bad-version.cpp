// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        return find(start,end);
    }
    
    int find(int start, int end){
        int mid = start+(end-start)/2;
        if(isBadVersion(mid)==true){
            if(isBadVersion(mid-1)!=true){
                return mid;
            }else{
                return find(start,mid);
            }
        }else{
            if(isBadVersion(mid+1)==true){
                return mid+1;
            }else{
                return find(mid,end);
            }
        }
    }
    
};