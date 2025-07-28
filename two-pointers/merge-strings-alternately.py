class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i, j = 0, 0
        result = ""
        min_len = min(len(word1),len(word2)) 
        for i in range(min_len): 
            result += word1[i]
            result += word2[j]
            j += 1 
        half_length = len(result)//2 
        if half_length == len(word1): 
            result += word2[half_length:]
        else: 
            result += word1[half_length:] 
        return result 


        