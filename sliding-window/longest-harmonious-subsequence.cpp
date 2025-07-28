class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int,int> map1;
        for(int i=0;i<nums.size();i++){
            if(map1.find(nums[i])!=map1.end()){
                map1[nums[i]]++;
            }else{
                map1[nums[i]]=1;
            }
        }
        
        int size = 0;
        for(auto x:map1){
            int standard = x.first;
            int number = x.second;
            if(map1.find(standard+1)!=map1.end()){
                if(number+map1[standard+1]>size){
                    size = number+map1[standard+1];
                }
            }
            if(map1.find(standard-1)!=map1.end()){
                if(number+map1[standard-1]>size){
                    size = number+map1[standard-1];
                }
            }
            
        }
        
       return size;
        
    }
};