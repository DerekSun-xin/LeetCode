class Solution {
    private int p1, p2 = 0; 

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge Sort: 
        int length = nums1.length + nums2.length; 
        if (length % 2 ==0){
            for(int i = 0; i < length/2 - 1; i++){
                int tmp = getMin(nums1, nums2); 
            }
            return (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2.0; 
        }else{
            for(int i = 0; i < length/2; i++){
                int tmp = getMin(nums1, nums2); 
            }
            return getMin(nums1, nums2); 
        }
        
    }

    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards 
    private int getMin(int[] nums1, int[] nums2){
        if (p1 < nums1.length && p2 < nums2.length){
            return nums1[p1] <= nums2[p2] ? nums1[p1++]: nums2[p2++]; 
        }else if(p1 < nums1.length){
            return nums1[p1++]; 
        }else if(p2 < nums2.length){
            return nums2[p2++]; 
        }
        return -1; 
    }
}