class Solution {
    public boolean isPalindrome(String s) {
        // 1. String operation
        // Convert s to lowercase
        s = s.toLowerCase(); 
        // Remove all non-alphanumeric characters
        String pattern = "[^a-z0-9]"; 
        s = s.replaceAll(pattern, ""); 
        
        // 2. Two pointers. 
        // One from start and one from end. Both move towards the center. 
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--; 
            }else{
                return false; 
            }
        }
        return true; 
    }
}