class Solution:
    memo = dict()
    def uniquePaths(self, m: int, n: int) -> int:
        m-=1
        n-=1
        def Paths(m,n):
            if (m,n) in Solution.memo.keys():
                return Solution.memo[(m,n)]
            if m<0 or n<0:
                Solution.memo[(m,n)] = 0
                return 0
            if m==0 and n==0:
                Solution.memo[(m,n)] = 1
                return 1
            Solution.memo[(m,n)] = Paths(m,n-1)+Paths(m-1,n)
            return Paths(m,n-1)+Paths(m-1,n)
        return Paths(m,n)
            
        