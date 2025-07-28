class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        for(int i=0;i<=n;i++){
            if(find(nums.begin(),nums.end(),i)!=nums.end()){
                continue;
            }else{
                return i;
            }
        }
        return 0;
    }
    
};