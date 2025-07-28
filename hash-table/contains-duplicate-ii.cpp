class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int,vector<int> > map;
        for(int i=0;i<nums.size();i++){
            if(map.find(nums[i])!=map.end()){
                int length = map[nums[i]].size();
                if(abs(i-map[nums[i]][length-1])<=k){
                    return true;
                }
                map[nums[i]].push_back(i);
                
                
            }else{
                vector<int> vec;
                vec.push_back(i);
                map[nums[i]] = vec;
                
            }
        }
        
        return false;
        
    }
};