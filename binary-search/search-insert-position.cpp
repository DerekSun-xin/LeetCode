class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        int mid = (low+high)/2; 
        
        while(low<high){
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                low=mid+1;
                mid=(low+high)/2;
            }else{
                high=mid-1;
                mid=(low+high)/2;
            }
        }
        cout<<high<<" "<<mid<<" "<<low<<endl;
        
        if(target>nums[mid]){
            return mid+1;
        }else{
            
            return mid;
        }
       
    }
};