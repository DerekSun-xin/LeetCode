class Solution {
public:
    int search(vector<int>& nums, int target) {
        int begin = 0;
        int last = nums.size()-1;
        return b_search(nums,target,begin,last);
    }

    int b_search(vector<int>& nums, int target, int begin, int last){
        if(last<begin){
            return -1;
        }
        int mid = (begin+last)/2;

        if(last==begin+1){
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid+1]==target){
                return mid+1;
            }else{
                return -1;
            }
        }

        if(last==begin){
            if(nums[begin]==target){
                return begin;
            }else{
                return -1;
            }
        }

        if(target==nums[mid]){
            return mid;
            
        }else if(target>nums[mid]){
            return b_search(nums,target,mid,last);
        }else{
            return b_search(nums,target,begin,mid);
        }
    }
};