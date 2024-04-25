import math

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if divisor < 0 and dividend < 0:
            divisor = -divisor
            dividend = -dividend
            result = int(dividend//divisor)
        elif divisor < 0:
            divisor = -divisor
            result = -int(dividend//divisor)
        elif dividend < 0: 
            dividend = -dividend
            result =  -int(dividend//divisor)
        else:
            result = int(dividend//divisor)

        if result > math.pow(-2,31):
            return int(math.pow(-2,31))
        elif result > math.pow(2,31) - 1:
            return int(math.pow(2,31) - 1)
        return result
    
#https://leetcode.com/problems/divide-two-integers/solutions/5066345/divide-without-division/
