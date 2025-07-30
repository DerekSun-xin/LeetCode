class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length; 
        int k = (m + n) / 2; 
        if ((m+n) % 2 == 1){
            return solve(nums1, nums2, k, 0, m - 1, 0, n -1); 
        }else{
            return (solve(nums1, nums2, k, 0, m-1, 0, n-1) + solve(nums1,nums2,k - 1, 0, m-1, 0, n-1)) / 2.0; 
        }
    }

    public int solve(
        int[] A, 
        int[] B, 
        int k, 
        int aStart,
        int aEnd, 
        int bStart, 
        int bEnd
    ){
        if (aStart > aEnd){
            return B[k - aStart];
        }
        if (bStart > bEnd){
            return A[k - bStart]; 
        }
        // Get the middle index of two ranges: 
        int aIndex = (aStart+aEnd)/2;
        int bIndex = (bStart+bEnd)/2;
        // Get the middle value of two ranges:
        int aMidVal = A[aIndex];
        int bMidVal = B[bIndex]; 
        // Cut one range by half each time based on condition: 
        if (k > aIndex + bIndex){
            // Remove the left part of smaller range
            if (aMidVal > bMidVal){
                bStart = bIndex + 1; 
                return solve(A,B,k, aStart, aEnd, bStart, bEnd); 
            }else{
                aStart = aIndex + 1;
                return solve(A,B,k, aStart, aEnd, bStart, bEnd); 
            }
        }else{
            // Remove the right part of the larger range
            if (aMidVal > bMidVal){
                aEnd = aIndex - 1;
                return solve(A,B,k, aStart, aEnd, bStart, bEnd); 

            }else{
                bEnd = bIndex - 1;
                return solve(A,B,k, aStart, aEnd, bStart, bEnd); 
            }
        }
        
    }
}