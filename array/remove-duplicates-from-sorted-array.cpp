class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int check=nums[0];
        for(int i=1;i<nums.size();i++){
            if(nums[i]==check){
                nums[i]=50000;
            }else{
                check=nums[i];
            }
        }
        
        for(int i=0;i<nums.size();i++){
            cout<<nums[i]<<endl;
        }
        
        vector<int> num;
        for(int i=0;i<nums.size();i++){
            if(nums[i]!=50000){
                num.push_back(nums[i]);
            }
        }
        nums=num;
        return nums.size();
    }
};