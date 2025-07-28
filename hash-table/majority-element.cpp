class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if(nums.size()==1){
            return nums[0];
        }
        
        unordered_map<int,int> map;
        int max = 0;
        int value = 0;
        for(int i=0;i<nums.size();i++){ 
            int key = nums[i];
            if(map.find(key)!=map.end()){
                map[key]++;
                if(map[key]>max){
                    max = map[key];
                    value = key;
                }
            }else{
                map[nums[i]]=1;
            }
        }
        
        return value;
    }
}; 