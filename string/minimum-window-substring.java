class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }
        HashMap<Character, Integer> sCount = new HashMap<>(); 
        HashMap<Character, Integer> tCount = new HashMap<>(); 
        for(int i = 0; i < t.length(); i++){  
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1); 
        }
        int[] minWindow = {0, Integer.MAX_VALUE}; 
        int l = 0; 
        int haveCharCount = 0; 
        for(int r = 0; r < s.length(); r++){
            char curChar = s.charAt(r); 
            if (tCount.containsKey(curChar)){
                if (sCount.getOrDefault(curChar, 0) < tCount.get(curChar)){
                    haveCharCount++; 
                }
                sCount.put(curChar, sCount.getOrDefault(curChar, 0)+1); 
            }
            while (haveCharCount == t.length()){
                if (r-l+1 < minWindow[1] - minWindow[0]){
                    minWindow[0] = l;
                    minWindow[1] = r; 
                }
                // Move left index
                char leftChar = s.charAt(l);
                if (tCount.containsKey(leftChar)){
                    sCount.put(leftChar, sCount.get(leftChar) - 1); 
                    if (sCount.get(leftChar) < tCount.get(leftChar)){
                        haveCharCount--;
                    }
                }
                l++; 
            }
        }

        if (minWindow[1] - minWindow[0] > s.length()){
            return ""; 
        }else{
            return s.substring(minWindow[0], minWindow[1]+1); 
        }
    }
}