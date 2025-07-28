class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if(nums.size()==0){
            return 0; 
        }
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]==val){
                nums[i]=5000;
            }
        }
        
        vector<int> ret;
        for(int i=0;i<nums.size();i++){
            if(nums[i]!=5000){
                ret.push_back(nums[i]);
            }
        }
        
        nums=ret;
        return nums.size();
    }
};