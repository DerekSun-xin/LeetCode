class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        def dfs(i): 
            stack = [i]
            visited.add(i)
            while stack: 
                crs = stack.pop()
                for neighbor in adj_list[crs]: 
                    if neighbor not in visited:
                        stack.append(neighbor)
                        visited.add(neighbor)

        adj_list = {i:[] for i in range(n)}
        for e0, e1 in edges:
            adj_list[e0].append(e1)
            adj_list[e1].append(e0)
        
        count = 0
        visited = set()
        for i in range(n):
            if i not in visited:
                dfs(i) 
                count+=1
        return count