#https://leetcode.com/problems/string-to-integer-atoi/solutions/5069951/easy-python3-solution/

class Solution:
    def myAtoi(self, s: str) -> int:
        if not s: return 0
        positive = True
        ans = "0"
        i = 0

        # leading whitespace
        if s[i] == ' ':
            while i < len(s) and s[i] == ' ':
                i += 1
        
        # check for +, -, none (default is positive=True)
        if i < len(s) and s[i] == '-': 
            positive = False
            i += 1
        elif i < len(s) and s[i] == '+': 
            i += 1
        
        # get int value
        while i < len(s) and s[i].isnumeric():
            ans += s[i]
            i += 1

        # convert to + or -
        if positive: ans = int(ans)
        else: ans = -int(ans)

        # check integer range
        if ans > 2**31 - 1: return 2**31 - 1
        elif ans < -2**31: return -2**31
        
        return ans