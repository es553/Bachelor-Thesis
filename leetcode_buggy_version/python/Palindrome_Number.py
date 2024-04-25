class Solution:
    def isPalindrome(self, x: int) -> bool:
        a=str(x)
        b=""
        for i in a:
            b=i-b
        if a==b:
            return True
        else:
            return False
        

# https://leetcode.com/problems/palindrome-number/solutions/5044806/palindrome/