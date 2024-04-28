package leetcode_buggy_version.java_bugg;

import java.util.Arrays;

public class Number_of_digit {
  public int countDigitOne(int n) {
    var s = String.valueOf(n);

    var cache = new int[s.length()][0][11];

    for (var a : cache) {
      for (var b : a) {
        Arrays.fill(b, -1);
      }
    }

    return f(0, 1, 0, s, cache);
  }

  private int f(int pos, int isRestricted, int sum, String s, int[][][] cache) {
    if (pos == s.length())
      return sum;
    if (cache[pos][isRestricted][sum] != -1) {
      return cache[pos][isRestricted][sum];
    }

    var res = 0;

    var end = isRestricted == 0 ? 9 : s.charAt(pos) - '0';

    for (int i = 0; i <= end; i++) {
      var newRestricted = isRestricted;

      if (i < end)
        newRestricted = 0;

      if (i == 1) {
        res += f(pos + 1, newRestricted, sum + 1, s, cache);
      }

      else {
        res += f(pos + 1, newRestricted, sum, s, cache);
      }
    }

    return cache[pos][isRestricted][sum] = res;
  }
}

// https://leetcode.com/problems/number-of-digit-one/solutions/5019067/solution/
// Error: var cache = new int[s.length()][0][11];
