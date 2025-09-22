class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Sliding window
        if (s1.length() > s2.length()){
            return false; 
        }
        HashMap<Character, Integer> s1Count = new HashMap<>(); 
        HashMap<Character, Integer> s2Count = new HashMap<>(); 

        for(int i = 0; i < s1.length(); i++){
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s2Count.equals(s1Count)){
            return true; 
        }

        // the s2Count maintains a window size of s1.length(); 
        int left = 0; 
        for(int j = s1.length(); j < s2.length(); j++){
            char curChar = s2.charAt(j); 
            s2Count.put(curChar, s2Count.getOrDefault(curChar, 0) + 1);
            
            char leftChar = s2.charAt(left); 
            s2Count.put(leftChar, s2Count.get(leftChar) - 1);
            if (s2Count.get(leftChar) == 0){
                s2Count.remove(leftChar); 
            }
            left++; 

            if (s2Count.equals(s1Count)){
                return true;
            }
        }

        return false; 
    }
}