class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map1;
        for(int i=0;i<nums2.size();i++){
            if(map1.find(nums2[i])!=map1.end()){
                map1[nums2[i]]++;
            }else{
                map1[nums2[i]]=1;
            }
        }
        
        vector<int> res;
        
       for(int i=0;i<nums1.size();i++){
          if(map1.find(nums1[i])!=map1.end()){
              if(map1[nums1[i]]!=0){
                  res.push_back(nums1[i]);
                  map1[nums1[i]]--;
              }
          }
       }
        
        return res;
        
    }
};