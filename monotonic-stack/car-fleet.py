class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position,speed))
        stack = []
        for position,speed in reversed(cars):
            time_to_dest = (target-position)/speed
            # if  (target-position)%speed==0:
            #     time_to_dest = (target-position)//speed
            # else:
            #     time_to_dest = (target-position)//speed+1
            if not stack or time_to_dest>stack[-1]:
                stack.append(time_to_dest)
        return len(stack)
            
        