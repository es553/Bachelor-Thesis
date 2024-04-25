package leetcode_buggy_version.java_bugg;

//https://leetcode.com/problems/zigzag-conversion/solutions/5037707/beats-95-users-with-java-easy-solution/
public class ZigzagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1)
      return s;

    StringBuilder str = new StringBuilder();
    int n = s.length();
    int formula = (numRows - 1) * 2;

    for (int i = 0; i < numRows; i++) {
      int index = i;
      while (index < n) {
        str.append(s.charAt(index));

        if (i != 0 && i != numRows - 1) {
          int k1 = formula - 2 * i;
          int k2 = index + k1;

          if (k2 < n) {
            str.append(s.charAt(k2));
          }
        }
        index += formula;
      }
    }
    return str.toString();
  }
}
