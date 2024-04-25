class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 2:
            return len(s)
        max_length = 0
        first, second = 0, 1
        sub = set()
        sub.add(s[0])
        while first < len(s) and second < len(s):
            ch = s[second]
            if ch in sub:
                while ch in sub:
                    sub.remove(s[first])
                    ch += 1
                continue
            second += 1
            sub.add(ch)
            max_length = max(max_length, len(sub))
        return max_length
    
#https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/5070127/1-approach-2-solutions-explained-properly/