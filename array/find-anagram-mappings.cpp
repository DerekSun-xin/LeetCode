class Solution {
public:
    vector<int> anagramMappings(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ret;
        for(int i=0;i<nums1.size();i++){
            auto it = find(nums2.begin(),nums2.end(),nums1[i]);
            int index = it-nums2.begin();
            ret.push_back(index);
        }
        return ret;
    }
};