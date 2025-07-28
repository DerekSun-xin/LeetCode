class Solution {
public:
    int thirdMax(vector<int>& nums) {
        vector<int> distinct;
        sort(nums.begin(),nums.end(),greater<int>());
        for(int i=0;i<nums.size();i++){
            if(find(distinct.begin(),distinct.end(),nums[i])==distinct.end()){
                distinct.push_back(nums[i]);
                if(distinct.size()==3){
                    return distinct[2];
                }
            }
        }
        
        return distinct[0];
    }
};