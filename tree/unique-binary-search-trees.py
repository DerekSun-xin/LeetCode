class Solution:
    def numTrees(self, n: int) -> int:
        memo = dict()

        def generateTrees(start,end):
            if (start,end) in memo.keys():
                return memo[(start,end)]
            if start>end:
                return 0

            
            all_trees = 0

            for i in range(start,end+1):
                numLeft = generateTrees(start,i-1)
                numRight = generateTrees(i+1,end)
                currentNum = 0
                if numLeft==0 and numRight ==0:
                     currentNum = 1
                else:
                    if numLeft == 0:
                        currentNum = numRight
                    elif numRight == 0:
                        currentNum =numLeft
                    else:
                        currentNum =numLeft*numRight
                all_trees+=currentNum
            memo[(start,end)] = all_trees
            return all_trees

        
        return generateTrees(1,n) if n else 0 