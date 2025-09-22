class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }
        HashMap<Character, Integer> sCount = new HashMap<>(); 
        HashMap<Character, Integer> tCount = new HashMap<>(); 
        for(int i = 0; i < t.length(); i++){
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1); 
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1); 
        }
        if (sCount.equals(tCount)){
            return s.substring(0, t.length()); 
        }
        
        int left = 0; 
        String subString = ""; 
        for(int j = t.length(); j < s.length(); j++){
            char curChar = s.charAt(j); 
            sCount.put(curChar, sCount.getOrDefault(curChar, 0) + 1);
            while (cover(sCount, tCount)){
                if (subString.isEmpty() || j - left + 1 < subString.length()){
                    subString = s.substring(left, j+1); 
                }
                sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1); 
                left++; 
            }
        }
        return subString; 
    }

    private boolean cover(HashMap<Character, Integer> sCount, HashMap<Character, Integer> tCount){
        for (Map.Entry<Character, Integer> entry: tCount.entrySet()){
            if (sCount.getOrDefault(entry.getKey(), 0) < entry.getValue()){
                return false; 
            }
        }
        return true; 
    }
}