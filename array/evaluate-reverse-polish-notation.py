class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operands = {'+', '-', '*','/'}
        stack = []
        for i in range(len(tokens)):
            if tokens[i] in operands:
                second = stack.pop()
                first = stack.pop()
                result = 0
                if tokens[i] == '+':
                    result = first+second
                elif tokens[i] == '-':
                    result = first-second
                elif tokens[i] == '*':
                    result = first*second
                else:
                    result = int(first/second)
                stack.append(result)
            else:
                stack.append(int(tokens[i]))
        
        return stack[0]



        