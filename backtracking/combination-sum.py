class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = []
        def dfs(cur,result, path): 
            if result == 0:
                if path not in output: 
                    output.append(path.copy())
                return 
            if result < 0:
                return 
            
            for i in range(cur,len(candidates)): 
                path.append(candidates[i])
                dfs(i,result - candidates[i], path)
                path.remove(candidates[i]) 
        dfs(0,target,[])
        return output