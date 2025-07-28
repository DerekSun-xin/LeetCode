class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "": 
            return []
        my_dict = {"2":"abc", "3":"def","4":"ghi","5":"jkl","6":"mno","7":"pqrs","8":"tuv","9":"wxyz"}
        output = []
        def backtrack(index, path):
            if len(path) == len(digits): 
                output.append(path)
                return 
            
            for i in range(len(my_dict[digits[index]])):
                path += my_dict[digits[index]][i]
                backtrack(index + 1, path)
                path = path[:-1] 
        backtrack(0,"")
        return output 
        