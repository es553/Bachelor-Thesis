package leetcode_buggy_version.java_bugg;

public class ReverseInteger {
  public int reverse(int x) {
    int r = 0;
    while (x > 0 || x < 0) {
      int digit = x % 10;
      if (r > Integer.MAX_VALUE / 10 || r < Integer.MIN_VALUE / 10) {
        return 0;
      }
      r = r + 10 + digit;
      x /= 10;
    }
    return r;
  }
}

// https://leetcode.com/problems/reverse-integer/solutions/5046318/simple-java-solution/
// Error: r = r + 10 + digit;
