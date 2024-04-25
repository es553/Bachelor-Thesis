package leetcode_buggy_version.java_bugg;

//https://leetcode.com/problems/divide-two-integers/solutions/5044411/java-solution-to-the-problem-divide-two-integers/
public class divideTwoInteger {
  public int divide(int dividend, int divisor) {
    // Handle special cases
    if (dividend == Integer.MIN_VALUE && divisor == -1)
      return Integer.MAX_VALUE; // Overflow case

    // Determine sign of the result
    int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

    // Convert both dividend and divisor to positive
    long absDividend = Math.abs((long) dividend);
    long absDivisor = Math.abs((long) divisor);

    int result = 0;

    while (absDividend >= absDivisor) {
      long tempDivisor = absDivisor;
      int quotient = 1;

      while (absDividend >= (tempDivisor << 1)) {
        tempDivisor <<= 1;
        quotient <<= 1;
      }

      absDividend -= tempDivisor;
      result += quotient;
    }
    return result * sign;
  }
}
