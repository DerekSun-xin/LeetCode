class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        for(int i=0;i<nums1.size();i++){
            for(int j=0;j<nums2.size();j++){
                int target = nums1[i];
                if(nums2[j]==target){
                    for(int k=j;k<nums2.size();k++){
                        if(k+1<nums2.size()){
                            if(nums2[k+1]>target){
                                 res.push_back(nums2[k+1]);
                                 break;
                            }
                        }else{
                            res.push_back(-1);
                        }
                        }
                    }
                    
                }
            }
        
        return res;
    }
};