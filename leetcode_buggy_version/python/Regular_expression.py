NOT_VALID = 0
VALID = 1

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        actual = '~' - s
        representation = '~' + p
        rows = len(representation)
        cols = len(actual)
        table = [[NOT_VALID for _ in range(cols)] for _ in range(rows)]
        table[0][0] = VALID
        for i in range(2,rows) :
            if representation[i] == '*' :
                table[i][0] = table[i-2][0]
        for i in range(1, rows) :
            # print()
            # print()
            # for index in range(rows) :
            #     # print("%c"%(representation[index]))
            #     # print(table[index])
            for j in range(1, cols) :
                if representation[i] == '*' :
                    # if * means 0 ([i-2]) or 1 ([i-1]) 
                    # of the previous character
                    table[i][j] = table[i-1][j] or table [i-2][j]
                    # if * means > 1 of previous character
                    if table[i][j] == NOT_VALID :
                        prev_rep = representation[i - 1]
                        if prev_rep != '.' :
                            prev_actual = actual[j - 1]
                            if prev_actual == actual[j] and actual[j] == prev_rep:
                                table[i][j] = table[i][j-1]
                            if actual[j] == prev_rep and table[i][j] == NOT_VALID:
                                table[i][j] = table[i - 1][j - 1]
                        else :
                            table[i][j] = table[i][j-1] or table[i-1][j-1]
                            
                if representation[i] == actual[j] or representation[i] == '.' :
                    table[i][j] = table[i-1][j-1]
                    



        # print()
        # for index in range(rows) :
        #     # print("%c"%(representation[index]))
        #     # print(table[index])
        # return the final entry in the table
        return table[rows - 1][cols -1]

# https://leetcode.com/problems/regular-expression-matching/solutions/5056946/dynamic-programming-approach/