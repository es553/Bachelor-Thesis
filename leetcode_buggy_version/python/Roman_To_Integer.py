class Solution:
    def romanToInt(self, s: str) -> int:
        number = 0
        temp = []
        n = len(s)
        value = 0
        before_value = 0
        for i in s[::-1]:
            if i == 'I':
                temp.append(1)
            elif i == 'V':
                temp.append(2)
            elif i == 'X':
                temp.append(3)
            elif i == 'L':
                temp.append(4)
            elif i == 'C':
                temp.append(5)
            elif i == 'D':
                temp.append(6)
            elif i == 'M':
                temp.append(7)
                
        for j in range(0, n):
            if temp[j] == 1:
                value = 1
            elif temp[j] == 2:
                value = 5
            elif temp[j] == 3:
                value = 10 
            elif temp[j] == 4:
                value = 50 
            elif temp[j] == 5:
                value = 100 
            elif temp[j] == 6:
                value = 500 
            elif temp[j] == 7:
                value = 1000

            if before_value > temp[j]:
                number += value
                before_value = temp[j]
            elif before_value < temp[j]:
                number += value
                before_value = temp[j]
            elif before_value == temp[j]:
                number += value
                before_value = temp[j]
                  
        return number
    

#https://leetcode.com/problems/roman-to-integer/solutions/5070487/roman-numerials-os/
