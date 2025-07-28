class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def backtrack(path,string):
            if string == "":
                res.append(path[:])
                return

            for i in range(len(string)):
                part = string[:i+1]
                remaining = string[i+1:]
                if part == part[::-1]:
                    path.append(part)
                    backtrack(path,remaining)
                    path.pop()

        backtrack([],s)
        return res


            


        