class Solution {
public:
    int singleNumber(vector<int>& nums) {
        map<int,int> mymap;
        for(int i=0;i<nums.size();i++){
            mymap[nums[i]]=0;
        }
        
        for(int i=0;i<nums.size();i++){
            mymap[nums[i]]++;
        }
        
        for (map<int,int>::iterator it=mymap.begin(); it!=mymap.end(); ++it){
            if(it->second==1){
                return it->first;
            }
        }
            return 0;
    }
};