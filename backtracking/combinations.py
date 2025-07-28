class Solution:

    def combine(self, n: int, k: int) -> List[List[int]]: 
        comb = []
        def backtrack(index,path):
            if len(path) == k: 
                comb.append(list(path))
                return
            
            for i in range(index,n+1):
                    path.append(i)
                    backtrack(i+1,path)
                    path.remove(i)
            return
        backtrack(1,[])
        return comb

            
        
