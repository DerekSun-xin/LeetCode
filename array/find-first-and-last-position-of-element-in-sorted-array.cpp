class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int begin = 0; 
        int end = nums.size()-1;      
        vector<int> ret;
        binarySearch(nums,begin,end,target,ret);
        if(ret.size()==0){
            ret.push_back(-1);
            ret.push_back(-1);
            return ret;
        }else{
            return ret;
        }
        
    }

    void binarySearch(vector<int>& nums, int begin, int end, int target,vector<int>& ret){
        if(begin<=end){
            int mid = (begin+end)/2;
            //Case1: if mid = target
            if(nums[mid]==target){
                ret = findPos(nums,mid,target);
            }else if(nums[mid]>target){
                //Go Left
                end = mid-1;
                binarySearch(nums,begin,end,target,ret);
            }else{
                begin = mid+1;
                binarySearch(nums,begin,end,target,ret);
            }
        }
        
    }

    vector<int> findPos(vector<int>& nums,int mid,int target){
        int firstPos = mid;
        int lastPos = mid;
        vector<int> ret;
        for(int i=mid-1;i>=0;i--){
           if(nums[i]==target){
               firstPos = i;
           }else{
               break;
           }
        }
        //cout<<firstPos<<endl;
        for(int i=mid+1;i<nums.size();i++){
            if(nums[i]==target){
                lastPos = i;
            }else{
                break;
            }
        }

        ret.push_back(firstPos);
        ret.push_back(lastPos);
        return ret;
    }
    
};