class Solution:
    def reverse(self, x: int) -> int:
        INT_MAX = 2**31 -1
        INT_MIN = -2**31
        sign = -1 if x < 0 else 1
        if x > INT_MAX or x < INT_MIN:
            return x
        
        str_x = str(abs(x))
        reversed_str_x = str_x[::-1]
        reversed_x = int(reversed_str_x)
        
        reversed_x += sign
        
        if reversed_x > INT_MAX or reversed_x < INT_MIN:
            return 0
        
        return reversed_x
    
#https://leetcode.com/problems/reverse-integer/solutions/5044950/reverse-integer-problem-python3-solution/