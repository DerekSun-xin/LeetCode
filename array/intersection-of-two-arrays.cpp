class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map1;      
        for(int i=0;i<nums1.size();i++){
            if(map1.find(nums1[i])!=map1.end()){
                map1[nums1[i]]++;
            }else{
                map1[nums1[i]]=1;
            }
        }
        
        unordered_map<int,int> map2;
        for(int i=0;i<nums2.size();i++){
             if(map2.find(nums2[i])!=map2.end()){
                map2[nums2[i]]++;
            }else{
                map2[nums2[i]]=1;
            }
        }
        
        vector<int> res;
        for(auto x:map1){
            if(map2.find(x.first)!=map2.end()){
                res.push_back(x.first);
            }
        }
        
        return res;
        
    }
};