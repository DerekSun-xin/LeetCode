class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        leng = len(costs)
        for i in range(1,len(costs)):
            for j in range(0,3):
                if j==0:
                    costs[i][j] = costs[i][j]+min(costs[i-1][j+1],costs[i-1][j+2])
                elif j==1:
                    costs[i][j] = costs[i][j]+min(costs[i-1][j-1],costs[i-1][j+1])
                else:
                    costs[i][j] = costs[i][j]+min(costs[i-1][j-1],costs[i-1][j-2])
        return min(costs[leng-1][0],costs[leng-1][1],costs[leng-1][2])
                
