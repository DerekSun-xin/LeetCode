class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }
        int[] tCount = new int[128]; 
        for(int i = 0; i < t.length(); i++){  
            char curChar = t.charAt(i); 
            tCount[curChar]++; 
        }

        int[] minWindow = {0, Integer.MAX_VALUE}; 
        int l = 0; 
        int required = t.length(); 
        for(int r = 0; r < s.length(); r++){
            char curChar = s.charAt(r); 

            if (tCount[curChar] > 0){
                required--; 
            }
            tCount[curChar]--; 
            while (required == 0){
                if (r-l+1 < minWindow[1] - minWindow[0]){
                    minWindow[0] = l;
                    minWindow[1] = r+1; 
                }
                
                // Move left index
                char leftChar = s.charAt(l);
                tCount[leftChar]++; 
                
                if (tCount[leftChar] > 0){
                    required++; 
                }
            
                l++; 
            }
        }

        if (minWindow[1] - minWindow[0] > s.length()){
            return ""; 
        }else{
            return s.substring(minWindow[0], minWindow[1]); 
        }
    }
}