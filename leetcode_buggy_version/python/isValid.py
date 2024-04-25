#https://leetcode.com/problems/valid-parentheses/solutions/4973258/most-comprehensive-approach-code-commented/

class Solution:
    def isValid(self, s: str) -> bool:
        if s[0] in (')', '}', ']'):
            return False

        stack = []

        par = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        for paran in s:
            if paran in ('(', '[', '{'): # 1
                stack.append(paran)

            elif stack and par[paran] == stack[-1]: # 2
                stack.pop()

            else:
                return False # 3

        return len(stack) == 1

    # 1. If we encounter an open bracket, then append it.
    # 2. Else if it is a closed one, use it as an entry in the dict to retrieve the corresponding bracket and compare  it with the last element in the stack.
    # 3. Finally, if the stack is empty and the next char not in ('(', '[', '{')), return false.