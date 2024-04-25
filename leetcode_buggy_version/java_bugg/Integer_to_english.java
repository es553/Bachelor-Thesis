package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/integer-to-english-words/solutions/5039745/java-solution-using-recursion/
public class Integer_to_english {
  private final String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
  private final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
      "Ninety" };

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    return process(num);
  }

  public String process(int num) {
    StringBuilder sb = new StringBuilder();
    if (num >= 1000000000) {
      sb.append(process(num / 1000000000)).append(" Billion ").append(process(num % 1000000000));
    } else if (num >= 1000000) {
      sb.append(process(num / 1000000)).append(" Million ").append(process(num % 1000000));
    } else if (num >= 1000) {
      sb.append(process(num / 1000)).append(" Thousand ").append(process(num % 1000));
    } else if (num >= 100) {
      sb.append(belowTwenty[num / 100]).append(" Hundred ").append(process(num % 100));
    } else if (num >= 20) {
      sb.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
    } else {
      sb.append(belowTwenty[num]);
    }
    return sb.toString().trim();
  }
}
