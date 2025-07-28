class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(path, index, remain):
            if remain == 0: 
                output.append(list(path))
                return 
            if remain < 0: 
                return  
            for i in range(index, n):  
                if i != index and candidates[i] == candidates[i-1]: 
                    continue
                path.append(candidates[i])
                backtrack(path, i + 1, remain - candidates[i])
                path.pop()

        candidates.sort()
        output = []
        n = len(candidates)
        backtrack([], 0, target) 
        return output
        