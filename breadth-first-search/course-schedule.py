class Solution:
    # backtracking is a kind of DFS. They share the same format. All of them share the recursion format. 
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def dfs(crs): 
            if crs in visitSet:
                # Detect a cycle
                return False
            if preMap[crs] == []:
                return True 
            
            visitSet.add(crs)
            for pre in preMap[crs]: 
                if not dfs(pre): return False
            preMap[crs] = []
            visitSet.remove(crs) 
            return True


        # map each course to prereq list
        preMap = {i: [] for i in range(numCourses)}
        for crs, pre in prerequisites: 
            preMap[crs].append(pre)
        
        # visitSet = all courses along the curr DFS path 
        visitSet = set() 
        for crs in range(numCourses):
            if not dfs(crs): return False 
        return True