class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        # BFS with multiple gate source
        rows, cols = len(rooms), len(rooms[0])
        visited = set()
        q = collections.deque()
        my_dict = {}
        
        # Append all gate into q
        for row in range(rows):
            for col in range(cols):
                if rooms[row][col] == 0:
                    q.append((row,col))
                    visited.add((row,col))
                    my_dict[(row,col)] = 0
                elif rooms[row][col] == -1:
                    my_dict[(row,col)] = -1
                     
        # Do BFS
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        while q:
            length = len(q)
            for i in range(length):
                r, c = q.popleft()
                dist = my_dict[(r,c)]
                for dr, dc in directions:
                    nr = r + dr
                    nc = c + dc
                    if nr in range(rows) and nc in range(cols) and rooms[nr][nc] == 2147483647 and (nr,nc) not in visited:
                        q.append((nr,nc))
                        visited.add((nr,nc))
                        my_dict[(nr,nc)] = dist+1
        
        for r in range(rows):
            for c in range(cols):   
                if (r,c) in my_dict:
                    rooms[r][c] = my_dict[(r,c)]
                else:
                    rooms[r][c] = 2147483647
        
                        

        





                        




