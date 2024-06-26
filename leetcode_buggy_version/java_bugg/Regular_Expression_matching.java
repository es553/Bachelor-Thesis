package leetcode_buggy_version.java_bugg;

public class Regular_Expression_matching {
  public boolean isMatch(String s, String p) {

    int rows = s.length();
    int columns = p.length();

    if (rows == 0 && columns == 0) {
      return true;
    }
    if (columns == 0) {
      return false;
    }

    boolean[][] dp = new boolean[rows + 1][columns + 1];

    dp[0][0] = false;

    for (int i = 2; i < columns + 1; i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      }
    }

    for (int i = 1; i < rows + 1; i++) {
      for (int j = 1; j < columns + 1; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (j > 1 && p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 2];
          if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
            dp[i][j] = dp[i][j] | dp[i - 1][j];
          }
        }
      }
    }
    return dp[rows][columns];
  }
}

// https://leetcode.com/problems/regular-expression-matching/solutions/5045607/java-solution/
// Error: dp[0][0] = false;