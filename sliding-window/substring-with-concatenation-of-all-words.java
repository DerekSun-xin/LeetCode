class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Handle edge cases where inputs are invalid 
        if (s == null || s.length() == 0 || words == null || words.length == 0){
            return new ArrayList<>(); 
        }

        // 1. Set up initial variables 
        List<Integer> result = new ArrayList<>(); 
        int wordLength = words[0].length();
        int totalWords = wordLength * words.length; 

        if (s.length() < totalWords){
            return result; 
        }

        // 2. Create a frequency map of the words we need to find
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word: words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1); 
        }

        // 3. Iterate all the possible starting points of the substring
        for (int i = 0; i < wordLength; i++){
            int left = i; // left pointer
            int count = 0; // number of valid words seen 
            Map<String, Integer> seenWords = new HashMap<>();

            for (int j = i; j + wordLength <= s.length(); j += wordLength){
                String currentWord = s.substring(j, j + wordLength); 

                if (wordsMap.containsKey(currentWord)){
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    count += 1; 

                    while (seenWords.get(currentWord) > wordsMap.get(currentWord)){
                        String leftWord = s.substring(left, left + wordLength); 
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1); 
                        left += wordLength; 
                        count--;
                    }

                    if (count == words.length){
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength); 
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        count--; 
                    }
                } else{
                    seenWords.clear(); 
                    count = 0; 
                    left = j + wordLength; 
                }
            }
        }
        return result;
    }
}