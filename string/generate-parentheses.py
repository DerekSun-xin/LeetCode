class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def generate(path,front,end):
            if front==n and end==n:            
                ans.append("".join(path))
                return

            if front+1<=n:
                path.append('(')
                generate(path,front+1,end)
                path.pop()
            if end+1<=front:
                path.append(')')
                generate(path,front,end+1)
                path.pop()
        generate(['('],1,0)
        return ans



        

        

        