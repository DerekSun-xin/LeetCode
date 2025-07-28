class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        ans = [0]*len(temperatures)
        for i in range(len(temperatures)):
            current_tmp = temperatures[i]
            if len(stack)!=0 and current_tmp>temperatures[stack[-1]]:
                while len(stack)!=0 and current_tmp>temperatures[stack[-1]]:
                    y = stack.pop()
                    ans[y] = i - y
            stack.append(i)
        return ans
            
                
        