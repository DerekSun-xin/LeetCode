class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        def dfs(crs,last): 
            stack = [crs] 
            while stack: 
                crs = stack.pop()
                visited.add(crs) 
                for pre in adj_list[crs]: 
                    if pre in visited and pre != last: 
                        # detect cycle
                        return False 
                    if pre == last:
                        continue
                    if not dfs(pre,crs):
                        return False
            return True 

        adj_list = {i:[] for i in range(n)}
        for e0, e1 in edges: 
            adj_list[e0].append(e1)
            adj_list[e1].append(e0)
        
        for i in range(n):
            visited = set()
            if not dfs(i,i) or len(visited) != n: 
                return False 
        return True
