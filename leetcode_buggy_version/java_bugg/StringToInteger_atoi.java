package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/string-to-integer-atoi/solutions/5044295/easy-java-solution/
public class StringToInteger_atoi {
  public int myAtoi(String s) {
    s = s.strip();
    if (s.isEmpty())
      return 0;

    int sign = 1;
    if (s.charAt(0) == '-') {
      sign = -1;
      s = s.substring(1);
    } else if (s.charAt(0) == '+') {
      s = s.substring(1);
    }

    long result = 0;

    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c))
        break;

      int digit = c - '0';
      result = result * 10 + digit;

      if (sign * result <= Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      if (sign * result >= Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
    }

    int returnResult = sign * (int) result;
    return returnResult;
  }
}
