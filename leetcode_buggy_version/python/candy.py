from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        # initailize array by 1 on len ratings
        n = len(ratings)
        candy_at = [1]*n
        tot_sum = 0
        for  i in range(1,n):
            # if current has high rating incr its candy
            if ratings[i-1] < ratings[i]:
                candy_at[i] = candy_at[i-1]+1

        for i in range(n-2,-1,-1):
            if ratings[i+1] > ratings[i]:
                candy_at[i] = max(candy_at[i+1]+1,candy_at[i])
            
            tot_sum += candy_at[i]
        tot_sum += candy_at[-1]
        print(tot_sum)
        return tot_sum

            
        