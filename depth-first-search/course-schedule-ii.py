class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        def dfs(crs): 
            if crs in visitedSet:
                return False 
            if preMap[crs] == []: 
                if crs not in ret:
                    ret.append(crs) 
                return True
            
            visitedSet.add(crs)
            for pre in preMap[crs]: 
                if not dfs(pre): return False
            visitedSet.remove(crs)
            preMap[crs] = []
            ret.append(crs)
            return True



        preMap = {i:[] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre) 
        ret = []
        visitedSet = set()
        for i in range(numCourses): 
            if not dfs(i):
                return []
        return ret
     
